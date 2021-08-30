package entity;

import dto.OrdersDTO;

import java.util.ArrayList;

public class Product {

    private String CatID;
    private String ProductName;
    private String ProductID;
    private String Material;
    private Double unitPrice;
    private Integer qtyOnHand;


    public Product(){
    }

    public Product(String catID, String productName, String productID, String material, Double unitPrice, Integer qtyOnHand) {
        CatID = catID;
        ProductName = productName;
        ProductID = productID;
        Material = material;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getCatID() {
        return CatID;
    }

    public void setCatID(String catID) {
        CatID = catID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(Integer qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
