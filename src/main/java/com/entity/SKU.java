package com.entity;

public class SKU {
    private int skuId;
    private String skuName;
    private int skuCode;
    private double skuPrice;
    private int skuSpuId;
    private String skuImage;
    private String skuDescription;
    private int skuCategory;
    private String skuBulletin;
    private int retailerId;
    private Retailer retailer;
    private Category category;
    private String categoryName;
    private int skuStatus;
    private int skuNum;

    @Override
    public String toString() {
        return "SKU{" +
                "skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", skuCode=" + skuCode +
                ", skuPrice=" + skuPrice +
                ", skuSpuId=" + skuSpuId +
                ", skuImage='" + skuImage + '\'' +
                ", skuDescription='" + skuDescription + '\'' +
                ", skuCategory=" + skuCategory +
                ", skuBulletin='" + skuBulletin + '\'' +
                ", retailerId=" + retailerId +
                ", retailer=" + retailer +
                ", category=" + category +
                ", categoryName='" + categoryName + '\'' +
                ", skuStatus=" + skuStatus +
                ", skuNum=" + skuNum +
                ", skuSpecification='" + skuSpecification + '\'' +
                '}';
    }

    public int getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(int skuNum) {
        this.skuNum = skuNum;
    }

    public int getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(int skuStatus) {
        this.skuStatus = skuStatus;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public String getSkuBulletin() {
        return skuBulletin;
    }

    public void setSkuBulletin(String skuBulletin) {
        this.skuBulletin = skuBulletin;
    }

    public int getSkuCategory() {
        return skuCategory;
    }

    public void setSkuCategory(int skuCategory) {
        this.skuCategory = skuCategory;
    }

    public String getSkuImage() {
        return skuImage;
    }

    public void setSkuImage(String skuImage) {
        this.skuImage = skuImage;
    }

    public String getSkuDescription() {
        return skuDescription;
    }

    public void setSkuDescription(String skuDescription) {
        this.skuDescription = skuDescription;
    }

    public String getSkuSpecification() {
        return skuSpecification;
    }

    public void setSkuSpecification(String skuSpecification) {
        this.skuSpecification = skuSpecification;
    }

    private String skuSpecification;

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(int skuCode) {
        this.skuCode = skuCode;
    }

    public double getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(double skuPrice) {
        this.skuPrice = skuPrice;
    }

    public int getSkuSpuId() {
        return skuSpuId;
    }

    public void setSkuSpuId(int skuSpuId) {
        this.skuSpuId = skuSpuId;
    }
}
