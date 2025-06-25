import React, { useState } from "react";

export default function ContactUs() {
  const [form, setForm] = useState({
    name: "",
    email: "",
    message: "",
  });
  const [submitted, setSubmitted] = useState(false);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmitted(true);
    // You can add an API call here to send the message if needed
  };

  return (
    <div className="main-container">
      <h2>Contact Us</h2>
      {submitted ? (
        <div style={{ color: "green", marginBottom: "1rem", fontWeight: "bold" }}>
          Thank you for contacting us! We will get back to you soon.
        </div>
      ) : (
        <form className="register-form" onSubmit={handleSubmit}>
          <label>
            Name:
            <input
              type="text"
              name="name"
              required
              value={form.name}
              onChange={handleChange}
              placeholder="Enter your name"
            />
          </label>
          <label>
            Email:
            <input
              type="email"
              name="email"
              required
              value={form.email}
              onChange={handleChange}
              placeholder="Enter your email"
            />
          </label>
          <label>
            Message:
            <textarea
              name="message"
              required
              value={form.message}
              onChange={handleChange}
              placeholder="Type your message"
              rows={5}
              style={{ resize: "vertical" }}
            />
          </label>
          <button type="submit">Send Message</button>
        </form>
      )}
    </div>
  );
}