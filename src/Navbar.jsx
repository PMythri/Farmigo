import React from "react";
import { NavLink } from "react-router-dom";
import "./Navbar.css";

function Navbar() {
  return (
    <header className="navbar">
      <div className="navbar-logo">Farmigo</div>
      <nav className="navbar-buttons">
        <NavLink to="/">Home</NavLink>
        <NavLink to="/service">Service</NavLink>
        <NavLink to="/login">Login</NavLink>
        <NavLink to="/register">Register</NavLink>
        <NavLink to="/contact">Contact Us</NavLink>
        <NavLink to="/about">About</NavLink>
      </nav>
    </header>
  );
}

export default Navbar;