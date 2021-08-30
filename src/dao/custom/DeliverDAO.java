package dao.custom;

import dao.CrudDAO;
import entity.Deliver;

public interface DeliverDAO extends CrudDAO<Deliver,String> {
        String getLastID() throws Exception;
}
