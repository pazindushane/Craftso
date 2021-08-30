package dto;

import java.util.ArrayList;

public class ProductDTO {


    private String CatID;
    private String ProductName;
    private String ProductID;
    private String Material;
    private Double unitPrice;
    private Integer qtyOnHand;


    public ProductDTO() {
    }

    public ProductDTO(String catID, String productName, String productID, String material, double unitPrice, int qtyOnHand) {
        this.CatID = catID;
        this.ProductName = productName;
        this.ProductID = productID;
        this.Material = material;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
