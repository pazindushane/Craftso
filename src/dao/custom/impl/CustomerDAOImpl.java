package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO Customer VALUES (?,?,?,?,?)";
        return CrudUtil.executeUpdate(SQL, customer.getCustContact(), customer.getCustID(), customer.getCustName(), customer.getAddress(), customer.getEmail());
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        String SQL = "DELETE FROM Customer WHERE CustContact = ?";
        return CrudUtil.executeUpdate(SQL,s);
    }

    @Override
    public boolean update(Customer customer) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE Customer SET CustContact=?, CustID=?, CustName=?, Address=? ,Email=?";
        return CrudUtil.executeUpdate(SQL,customer.getCustContact(),customer.getCustID(),customer.getCustName(),customer.getAddress(),customer.getEmail());
    }

    @Override
    public Customer search(String s) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM Customer WHERE CustContact=?";
        ResultSet rst = CrudUtil.executeQuery(SQL,s);
        if (rst.next()){
            return new Customer(rst.getString("CustContact"),rst.getString("CustID"),rst.getString("CustName"),rst.getString("Address"),rst.getString("Email"));
        }
        return null;
    }

    @Override
    public ObservableList<Customer> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM Customer";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Customer> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Customer(rst.getString("CustContact"),rst.getString("CustID"),rst.getString("CustName"),rst.getString("Address"),rst.getString("Email")));
        }
        return list;
    }




    @Override
    public String getLastID() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select CustID from Customer order by CustID desc limit 1");

        while (rst.next())
            return rst.getString(1);

        return null;
    }
}
