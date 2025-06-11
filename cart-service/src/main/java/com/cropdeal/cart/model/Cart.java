package com.cropdeal.cart.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;  // ID of the dealer who owns the cart

    @ElementCollection
    private List<String> selectedCrops;  // List of crop names in cart

    private Double totalPrice; // Store the total price of selected crops

    // Default constructor
    public Cart() {}

    // Constructor with all fields
    public Cart(int userId, List<String> selectedCrops, Double totalPrice) {
        this.userId = userId;
        this.selectedCrops = selectedCrops;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getSelectedCrops() {
        return selectedCrops;
    }

    public void setSelectedCrops(List<String> selectedCrops) {
        this.selectedCrops = selectedCrops;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}