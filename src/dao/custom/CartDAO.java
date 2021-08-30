package dao.custom;

import dao.CrudDAO;
import entity.Cart;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CartDAO extends CrudDAO<Cart, String> {
    String getLastID() throws Exception;

}
