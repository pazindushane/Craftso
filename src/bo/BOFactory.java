package bo;

import bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        if (boFactory==null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{
        CUSTOMER , CART , ORDER, PRODUCT, CATEGERY ,DELIVER;
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case CART:
                return new CartBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case PRODUCT:
                return new ProductBOImpl();
            case CATEGERY:
                return new CategeryBOImpl();
            case DELIVER:
                return new DeliverBOImpl();

            default:
                return null;
        }
    }
}
