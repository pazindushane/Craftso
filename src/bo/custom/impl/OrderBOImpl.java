package bo.custom.impl;

import bo.custom.OrderBO;
import dao.DAOFactory;
import dao.custom.OrderDAO;
import dto.OrdersDTO;
import entity.Orders;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    OrderDAO c = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public boolean add(OrdersDTO orders) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(OrdersDTO orders) throws ClassNotFoundException, SQLException {
        return false;
    }

//    @Override
//    public OrdersDTO search(String id) throws ClassNotFoundException, SQLException {
//        Orders orders = c.search(id);
//        return new OrdersDTO(orders.getOID(),orders.getCustContact(),orders.getCategoryID(),orders.getProductName(),orders.getMaterial(),orders.getQty());
//
//    }

    @Override
    public ObservableList<OrdersDTO> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getLastOID() throws Exception {
        return c.getLastID();
    }
}
