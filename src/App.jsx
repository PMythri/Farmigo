import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./Navbar";
import HomePage from "./HomePage";
import LoginPage from "./LoginPage";
import RegisterPage from "./RegisterPage";
import ContactUs from "./ContactUs";
import "./App.css"
function App() {
  return (
    <Router>
      <header>
      <Navbar /></header>
      <main>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/contact" element={<ContactUs />} /> 
        <Route path="/service" element={<ServicePage />} /> 
      </Routes>
      </main>
    </Router>
  );
}

export default App;