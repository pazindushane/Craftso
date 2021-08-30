package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    public boolean add(CustomerDTO customer) throws ClassNotFoundException, SQLException;
    public boolean delete(String id) throws ClassNotFoundException,SQLException;
    public boolean update(CustomerDTO customer) throws ClassNotFoundException,SQLException;
    public CustomerDTO search(String id) throws ClassNotFoundException,SQLException;
    public ObservableList<CustomerDTO> getAll() throws ClassNotFoundException, SQLException;
    String getLastCustID() throws Exception;

}
