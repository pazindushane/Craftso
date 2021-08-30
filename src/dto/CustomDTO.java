package dto;

public class CustomDTO {

    private String CatID;
    private String ProductName;
    private String ProductID;
    private String Material;
    private double unitPrice;
    private int qty;
    private int qtyOnHand;
    private String OrderID;
    private String CustCont;

    public CustomDTO() {
    }

    public CustomDTO(String catID, String productName, String productID, String material, double unitPrice, int qty, int qtyOnHand, String orderID, String custCont) {
        this.CatID = catID;
        this.ProductName = productName;
        this.ProductID = productID;
        this.Material = material;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.qtyOnHand = qtyOnHand;
        OrderID = orderID;
        CustCont = custCont;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getCustCont() {
        return CustCont;
    }

    public void setCustCont(String custCont) {
        CustCont = custCont;
    }
}
