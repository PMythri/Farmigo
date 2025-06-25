import React, { useState } from "react";

function LoginForm() {
  const [formData, setFormData] = useState({
    name: "",
    phone: "",
    email: "",
    age: "",
    dob: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("User Data:", formData); // Simulate form submission
    alert("Form submitted successfully!");
  };

  return (
    <div style={{ maxWidth: "400px", margin: "auto", padding: "20px", border: "1px solid #ccc" }}>
      <h2>User Login</h2>
      <form onSubmit={handleSubmit}>
        <label>Name:</label>
        <input type="text" name="name" value={formData.name} onChange={handleChange} required />
        
        <label>Phone Number:</label>
        <input type="tel" name="phone" value={formData.phone} onChange={handleChange} required />

        <label>Email ID:</label>
        <input type="email" name="email" value={formData.email} onChange={handleChange} required />

        <label>Age:</label>
        <input type="number" name="age" value={formData.age} onChange={handleChange} required />

        <label>Date of Birth:</label>
        <input type="date" name="dob" value={formData.dob} onChange={handleChange} required />

        <button type="submit" style={{ marginTop: "10px" }}>Submit</button>
      </form>
    </div>
  );
}

export default LoginForm;