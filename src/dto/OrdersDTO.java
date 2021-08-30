package dto;

import java.util.ArrayList;

public class OrdersDTO {
    private String OID;
    private String CustContact;
    private String CategoryID;
    private String ProductName;
    private String Material;
    private Double UnitPrice;
    private Integer Qty;


    public OrdersDTO() {
    }

    public OrdersDTO(String OID, String custContact, String categoryID, String productName, String material, Double unitPrice, Integer qty) {
        this.OID = OID;
        CustContact = custContact;
        CategoryID = categoryID;
        ProductName = productName;
        Material = material;
        UnitPrice = unitPrice;
        Qty = qty;
    }

    public String getOID() {
        return OID;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }

    public String getCustContact() {
        return CustContact;
    }

    public void setCustContact(String custContact) {
        CustContact = custContact;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }
}
