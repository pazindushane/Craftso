package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.OrdersDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface OrderBO extends SuperBO {
    public boolean add(OrdersDTO orders) throws ClassNotFoundException, SQLException;
    public boolean delete(String id) throws ClassNotFoundException,SQLException;
    public boolean update(OrdersDTO orders) throws ClassNotFoundException,SQLException;
    //public OrdersDTO search(String id) throws ClassNotFoundException,SQLException;
    public ObservableList<OrdersDTO> getAll() throws ClassNotFoundException, SQLException;
    String getLastOID() throws Exception;
}
