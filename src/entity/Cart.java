package entity;

public class Cart {
    private String PCategory;
    private String PName;
    private String PID;
    private String Description;
    private Double UPrice;
    private String QTY;
    private String OID;

    public Cart() {
    }

    public Cart(String PCategory, String PName, String PID, String description, Double UPrice, String QTY, String OID) {
        this.PCategory = PCategory;
        this.PName = PName;
        this.PID = PID;
        Description = description;
        this.UPrice = UPrice;
        this.QTY = QTY;
        this.OID = OID;
    }

    public String getPCategory() {
        return PCategory;
    }

    public void setPCategory(String PCategory) {
        this.PCategory = PCategory;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getUPrice() {
        return UPrice;
    }

    public void setUPrice(Double UPrice) {
        this.UPrice = UPrice;
    }

    public String getQTY() {
        return QTY;
    }

    public void setQTY(String QTY) {
        this.QTY = QTY;
    }

    public String getOID() {
        return OID;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }
}
