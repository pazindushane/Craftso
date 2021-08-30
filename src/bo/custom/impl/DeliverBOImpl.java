package bo.custom.impl;

import bo.custom.DeliverBO;
import dao.DAOFactory;
import dao.custom.DeliverDAO;
import dao.custom.OrderDAO;

public class DeliverBOImpl implements DeliverBO {
    DeliverDAO c = (DeliverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DELIVER);
    @Override
    public String getLastDID() throws Exception {
        return c.getLastID();
    }
}
