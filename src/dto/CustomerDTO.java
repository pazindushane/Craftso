package dto;

public class CustomerDTO {
    private String CustContact;
    private String CustID;
    private String CustName;
    private String Address;
    private String Email;

    public CustomerDTO() {
    }

    public CustomerDTO(String custContact, String custID, String custName, String address, String email) {
        CustContact = custContact;
        CustID = custID;
        CustName = custName;
        Address = address;
        Email = email;
    }

    public String getCustContact() {
        return CustContact;
    }

    public void setCustContact(String custContact) {
        CustContact = custContact;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String custID) {
        CustID = custID;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
