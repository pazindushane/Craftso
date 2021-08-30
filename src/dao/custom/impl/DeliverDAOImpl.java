package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.DeliverDAO;
import entity.Deliver;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliverDAOImpl implements DeliverDAO {
    @Override
    public String getLastID() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select DeliverID  from Deliver order by DeliverID  desc limit 1");

        while (rst.next())
            return rst.getString(1);

        return null;
    }

    @Override
    public boolean add(Deliver deliver) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Deliver deliver) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Deliver search(String s) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Deliver> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }
}
