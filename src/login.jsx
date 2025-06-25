import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { useNavigate } from "react-router-dom";

 const Login=()=>{
const [username, setusername] = useState("");
const [password, setpassword] = useState("");
const [email, setemail] = useState("");
const navigate = useNavigate();

const handleLogin = (e) => {
    e.preventDefault();
    if (username === "admin" && password === "1234") {
      navigate("/dashboard");
    } else {
      alert("Invalid credentials");
    }
  };
  return (
    <div className="login-container">
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <input type="text" placeholder="Username" onChange={(e) => setUsername(e.target.value)} required />
        <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} required />
         <input type="email" placeholder="email" onChange={(e) => setemail(e.target.value)} required />
        <button type="submit">Login</button>
      </form>
    </div>
    );
};


export default Login;
