import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function LoginPage() {
  const [role, setRole] = useState("FARMER");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    let endpoint, payload;
    if (role === "FARMER") {
      endpoint = "http://localhost:8787/auth/farmer/login";
      payload = { Farmername: username, password };
    } else {
      endpoint = "http://localhost:8787/auth/dealer/login";
      payload = { username, password };
    }
    try {
      const res = await axios.post(endpoint, payload);
      localStorage.setItem("token", res.data.token);
      localStorage.setItem("role", role);
      alert("Login successful!");
      if (role === "FARMER") navigate("/farmer");
      else navigate("/dealer");
    } catch (err) {
      alert("Login failed: " + (err.response?.data?.message || err.message));
    }
  };

  return (
    <div className="main-container">
      <h2>Login</h2>
      <form className="login-form" onSubmit={handleSubmit}>
        <label>
          {role === "FARMER" ? "Farmer Name:" : "Dealer Username:"}
          <input type="text" required value={username} onChange={e => setUsername(e.target.value)} />
        </label>
        <label>
          Password:
          <input type="password" required value={password} onChange={e => setPassword(e.target.value)} />
        </label>
        <label>
          Role:
          <select value={role} onChange={e => setRole(e.target.value)}>
            <option value="FARMER">Farmer</option>
            <option value="DEALER">Dealer</option>
          </select>
        </label>
        <button type="submit">Login</button>
      </form>
    </div>
  );
}