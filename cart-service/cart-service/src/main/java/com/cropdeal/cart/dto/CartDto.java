package com.cropdeal.cart.dto;
import java.util.List;

public class CartDto {
    private int userId;
    private List<String> selectedCrops;
    private Double totalPrice;

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