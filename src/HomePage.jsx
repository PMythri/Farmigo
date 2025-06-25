import React from "react";
import "./HomePage.css";

function HomePage() {
  return (
    <main className="homepage-main">
      <section className="homepage-hero">
        <h1>Welcome to Farmigo</h1>
        <p>
          Empowering Farmers, Dealers, and Service Providers. Discover the best crops for every season and connect with the right people for your agricultural needs.
        </p>
      </section>
      <section className="seasonal-crops">
        <h2>Crops by Season</h2>
        <div className="crops-grid">
          <div className="crop-card">
            <img src="wheat.webp" />
            <h3>Wheat (Winter)</h3>
          </div>
          <div className="crop-card">
            <img src="rice.jpg" />
            <h3>Rice (Monsoon)</h3>
          </div>
          <div className="crop-card">
            <img src="maize.webp" />
            <h3>Maize (Summer)</h3>
          </div>
          <div className="crop-card">
            <img src="mustard.webp" />
            <h3>Mustard (Winter)</h3>
          </div>
          <div className="crop-card">
            <img src="sugarcane.jpg" />
            <h3>Sugarcane (All Season)</h3>
          </div>
        </div>
      </section>
    </main>
  );
}

export default HomePage;