package dao.custom;

import dao.CrudDAO;
import entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer, String> {
     String getLastID() throws Exception;
}
