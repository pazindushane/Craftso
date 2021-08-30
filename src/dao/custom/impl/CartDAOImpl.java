package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CartDAO;
import entity.Cart;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDAOImpl implements CartDAO {
    @Override
    public boolean add(Cart cart) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Cart cart) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Cart search(String s) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Cart> getAll() throws ClassNotFoundException, SQLException {


        return null;
    }



    @Override
    public String getLastID() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select PID from Cart order by PID desc limit 1");

        while (rst.next())
            return rst.getString(1);

        return null;
    }


}
