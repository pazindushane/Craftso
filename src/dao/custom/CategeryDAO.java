package dao.custom;

import dao.CrudDAO;
import entity.Catagory;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategeryDAO extends CrudDAO<Catagory, String> {
    ArrayList<String> getCategoryID()throws SQLException, ClassNotFoundException;
}
