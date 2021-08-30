package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDAO;
import entity.Customer;
import entity.Orders;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String getLastID() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select OID from Orders order by OID desc limit 1");

        while (rst.next())
            return rst.getString(1);

        return null;
    }


    @Override
    public boolean add(Orders orders) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO orders VALUES (?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(SQL,orders.getOID(),orders.getCustContact(),orders.getCategoryID(),orders.getProductName(),orders.getMaterial(),orders.getQty());
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        String SQL = "DELETE FROM orders WHERE OID = ?";
        return CrudUtil.executeUpdate(SQL,s);
    }

    @Override
    public boolean update(Orders orders) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE orders SET OID=?, CustContact=?, CategoryID=?, ProductName=? ,Material=?, Qty=?";
        return CrudUtil.executeUpdate(SQL,orders.getOID(),orders.getCustContact(),orders.getCategoryID(),orders.getProductName(),orders.getMaterial(),orders.getQty());
    }

    @Override
    public Orders search(String s) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM orders WHERE OID=?";
        ResultSet rst = CrudUtil.executeQuery(SQL,s);
        if (rst.next()){
            return new Orders(rst.getString("OID"),rst.getString("CustContact"),rst.getString("CategoryID"),rst.getString("ProductName"),rst.getString("Material"),rst.getDouble("UnitPrice"),rst.getInt("Qty"));
        }
        return null;
    }

    @Override
    public ObservableList<Orders> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }


}
