package dao.custom;

import dao.CrudDAO;

import entity.Orders;

public interface OrderDAO extends CrudDAO<Orders, String> {
    String getLastID() throws Exception;
}
