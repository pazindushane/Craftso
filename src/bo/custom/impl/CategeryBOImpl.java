package bo.custom.impl;

import bo.custom.CategeryBO;
import dao.DAOFactory;
import dao.custom.CategeryDAO;


public class CategeryBOImpl implements CategeryBO {
    CategeryDAO categeryDAO = (CategeryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CATEGORY);


}
