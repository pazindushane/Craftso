package dto;

public class DeliverDTO {
    private String DeliID;
    private String OID;
    private String CustContact;
    private String ProductName;
    private String Qty;
    private String Area;
    private String Delifee;
    private Double Amount;

    public DeliverDTO() {
    }

    public DeliverDTO(String deliID, String OID, String custContact, String productName, String qty, String area, String delifee, Double amount) {
        DeliID = deliID;
        this.OID = OID;
        CustContact = custContact;
        ProductName = productName;
        Qty = qty;
        Area = area;
        Delifee = delifee;
        Amount = amount;
    }

    public String getDeliID() {
        return DeliID;
    }

    public void setDeliID(String deliID) {
        DeliID = deliID;
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

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getDelifee() {
        return Delifee;
    }

    public void setDelifee(String delifee) {
        Delifee = delifee;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }
}
