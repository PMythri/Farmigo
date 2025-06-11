package com.Project.DealerService.dto;

import java.util.List;

public class CartDto {
    private int userId;
    private List<String> selectedCrops;
    private List<String> cropTypes;
    private List<String> cropSeasons;
    private Double totalPrice;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public List<String> getSelectedCrops() { return selectedCrops; }
    public void setSelectedCrops(List<String> selectedCrops) { this.selectedCrops = selectedCrops; }

    public List<String> getCropTypes() { return cropTypes; }
    public void setCropTypes(List<String> cropTypes) { this.cropTypes = cropTypes; }

    public List<String> getCropSeasons() { return cropSeasons; }
    public void setCropSeasons(List<String> cropSeasons) { this.cropSeasons = cropSeasons; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
}