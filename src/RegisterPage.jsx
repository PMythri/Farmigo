import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function RegisterPage() {
  const [role, setRole] = useState("FARMER");
  // Common fields
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  // Farmer fields
  const [bankAccountNo, setBankAccountNo] = useState("");
  const [ifsc, setIfsc] = useState("");
  const [crops, setCrops] = useState("");
  const [location, setLocation] = useState("");
  // Dealer fields
  const [phoneNumber, setPhoneNumber] = useState("");
  const [businessName, setBusinessName] = useState("");
  const [selectedCrops, setSelectedCrops] = useState("");
  const [totalPrice, setTotalPrice] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    let endpoint, payload;
    if (role === "FARMER") {
      endpoint = "http://localhost:8787/auth/farmer/register";
      payload = {
        farmername: username,
        password,
        email,
        bankAccountNo,
        ifsc,
        crops,
        location,
        role,
      };
    } else {
      endpoint = "http://localhost:8787/auth/dealer/register";
      payload = {
        username,
        password,
        email,
        phoneNumber,
        businessName,
        role,
        selectedCrops: selectedCrops.split(",").map(s => s.trim()),
        totalPrice: Number(totalPrice),
      };
    }
    try {
      const res = await axios.post(endpoint, payload);
      localStorage.setItem("token", res.data.token);
      localStorage.setItem("role", role);
       alert("Registration successful!");
      if (role === "FARMER") navigate("/farmer");
      else navigate("/dealer");
    } catch (err) {
      alert("Registration failed: " + (err.response?.data?.message || err.message));
    }
  };

  return (
    <div className="main-container">
      <h2 className="register-heading">Register</h2>
    
      <form className="register-form" onSubmit={handleSubmit}>
        <label>
          {role === "FARMER" ? "Farmer Name:" : "Dealer Username:"}
          <input
            type="text"
            required
            value={username}
            onChange={e => setUsername(e.target.value)}
            placeholder={role === "FARMER" ? "Enter farmer name" : "Enter dealer username"}
          />
        </label>
        <label>
          Email:
          <input
            type="email"
            required
            value={email}
            onChange={e => setEmail(e.target.value)}
            placeholder="Enter email"
          />
        </label>
        <label>
          Password:
          <input
            type="password"
            required
            value={password}
            onChange={e => setPassword(e.target.value)}
            placeholder="Enter password"
          />
        </label>
        {role === "FARMER" && (
          <>
            <label>
              Bank Account No:
              <input
                type="text"
                required
                value={bankAccountNo}
                onChange={e => setBankAccountNo(e.target.value)}
                placeholder="Enter bank account number"
              />
            </label>
            <label>
              IFSC:
              <input
                type="text"
                required
                value={ifsc}
                onChange={e => setIfsc(e.target.value)}
                placeholder="Enter IFSC code"
              />
            </label>
            <label>
              Crops:
              <input
                type="text"
                required
                value={crops}
                onChange={e => setCrops(e.target.value)}
                placeholder="e.g. Wheat, Rice"
              />
            </label>
            <label>
              Location:
              <input
                type="text"
                required
                value={location}
                onChange={e => setLocation(e.target.value)}
                placeholder="Enter location"
              />
            </label>
          </>
        )}
        {role === "DEALER" && (
          <>
            <label>
              Phone Number:
              <input
                type="text"
                required
                value={phoneNumber}
                onChange={e => setPhoneNumber(e.target.value)}
                placeholder="Enter phone number"
              />
            </label>
            <label>
              Business Name:
              <input
                type="text"
                required
                value={businessName}
                onChange={e => setBusinessName(e.target.value)}
                placeholder="Enter business name"
              />
            </label>
            <label>
              Selected Crops:
              <input
                type="text"
                required
                value={selectedCrops}
                onChange={e => setSelectedCrops(e.target.value)}
                placeholder="e.g. Wheat, Rice"
              />
            </label>
            <label>
              Total Price:
              <input
                type="number"
                required
                value={totalPrice}
                onChange={e => setTotalPrice(e.target.value)}
                placeholder="Enter total price"
              />
            </label>
          </>
        )}
        <label>
          Role:
          <select value={role} onChange={e => setRole(e.target.value)}>
            <option value="FARMER">Farmer</option>
            <option value="DEALER">Dealer</option>
          </select>
        </label>
        <button type="submit">Register</button>
      </form>
    </div>
  );
}