package dao.custom;

import dao.CrudDAO;
import entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO extends CrudDAO<Product, String> {



    String getLastID() throws Exception;

    ArrayList<String> getProductnames(String id) throws SQLException, ClassNotFoundException;
    ArrayList<String> getCategoryID()throws SQLException, ClassNotFoundException;
    ArrayList<Object> Searchp(String id) throws SQLException, ClassNotFoundException;

    String getLastCID() throws Exception;


}
