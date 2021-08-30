package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CategeryDAO;
import entity.Catagory;
import entity.Customer;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategeryDAOImpl implements CategeryDAO {


    @Override
    public boolean add(Catagory catagory) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Catagory catagory) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Catagory search(String s) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Catagory> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM Category";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Catagory> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Catagory(rst.getString("CategoryID"),rst.getString("CategoryName")));
        }
        return list;
    }

    @Override
    public ArrayList<String> getCategoryID() throws SQLException, ClassNotFoundException {
        String sql = "select categoryID from product";
        ResultSet res = CrudUtil.executeQuery(sql);
        ArrayList<String> arrayList=new ArrayList<>();
        while (res.next()){
            arrayList.add(res.getString(1));
        }
        System.out.println(arrayList);
        return arrayList;
    }
    }

