package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ProductDAO;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean add(Product product) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO Product VALUES (?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(SQL,product.getCatID(), product.getProductName(), product.getProductID(), product.getMaterial(), product.getUnitPrice(), product.getQtyOnHand());
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        String SQL = "DELETE FROM Product WHERE ProductID = ?";
        return CrudUtil.executeUpdate(SQL,s);
    }

    @Override
    public boolean update(Product product) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE  Product SET ProductID=?,CategoryID=?,ProductName=?,Material=?,UnitPrice=?,QtyOnHand=?   ";
        return CrudUtil.executeUpdate(SQL,product.getProductID(),product.getCatID(), product.getProductName(), product.getMaterial(), product.getUnitPrice(), product.getQtyOnHand());

    }

    @Override
    public Product search(String s) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM Product WHERE ProductID =?";
        ResultSet rst = CrudUtil.executeQuery(SQL, s);
        while (rst.next()) {
            return new Product(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5), rst.getInt(6));
        }
        return null;
    }

    @Override
    public ObservableList<Product> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM Product";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Product> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Product(rst.getString("CategoryID"),rst.getString("ProductName"),rst.getString("ProductID"),rst.getString("Material"),rst.getDouble("UnitPrice"),rst.getInt("QtyOnHand")));
        }
        return list;
    }


    @Override
    public String getLastID() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select ProductID from product order by ProductID desc limit 1");

        while (rst.next())
            return rst.getString(1);

        return null;
    }

    @Override
    public ArrayList<String> getProductnames(String id) throws SQLException, ClassNotFoundException {
        String sql = "select ProductID from product where categoryID=?";
        System.out.println(id + "id");


        ArrayList<String> recordList = new ArrayList<>();
        System.out.println("ssss");
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        while (rst.next()) {

            System.out.println(rst.getString(1));

            recordList.add(rst.getString(1));
        }
        return recordList;
    }

    @Override
    public ArrayList<String> getCategoryID() throws SQLException, ClassNotFoundException {
        String sql = "select categoryID from product";
        ResultSet res = CrudUtil.executeQuery(sql);
        ArrayList<String> arrayList = new ArrayList<>();
        while (res.next()) {

            arrayList.add(res.getString(1));
            System.out.println(arrayList);
        }

        return arrayList;
    }

    @Override
    public ArrayList<Object> Searchp(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT ProductID,Material,UnitPrice,QtyOnHand FROM product WHERE ProductID =?";
        ArrayList<Object> recordList = new ArrayList<>();

        ResultSet rst = CrudUtil.executeQuery(sql, id);
        while (rst.next()) {
            recordList.add(rst.getString("ProductID"));
            recordList.add(rst.getString("Material"));


            recordList.add(rst.getDouble("UnitPrice"));
            recordList.add(rst.getInt("QtyOnHand"));
        }
        return recordList;

    }

    @Override
    public String getLastCID() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select CategoryID from product order by CategoryID desc limit 1");

        while (rst.next())
            return rst.getString(1);

        return null;
    }
}
