package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER , CART , ORDER ,PRODUCT,CATEGORY,DELIVER;
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case CART:
                return new CartDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case PRODUCT:
                return new ProductDAOImpl();
            case CATEGORY:
                return new CategeryDAOImpl();
            case DELIVER:
                return new DeliverDAOImpl();

            default:
                return null;
        }
    }
}
