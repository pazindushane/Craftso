package bo.custom.impl;

import bo.custom.CartBO;
import dao.DAOFactory;
import dao.custom.CartDAO;
import dao.custom.CategeryDAO;
import dao.custom.OrderDAO;
import dao.custom.ProductDAO;
import dao.custom.impl.ProductDAOImpl;
import db.DBConnection;
import dto.*;
import entity.Catagory;
import entity.Orders;
import entity.Product;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartBOImpl implements CartBO {
    CartDAO c = (CartDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CART);
    ProductDAO productDAO = new ProductDAOImpl();
    CategeryDAO categeryDAO = (CategeryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CATEGORY);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);


    @Override
    public ArrayList<String> search(String id) throws ClassNotFoundException, SQLException {


        return null;
    }

    @Override
    public boolean add(CartDTO cart) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public String getLastPID() throws Exception {
        return null;
    }

    @Override
    public ProductDTO searchProduct(String toString) throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
//    public ProductDTO searchProduct(String a) throws SQLException, ClassNotFoundException {
//        Product product = productDAO.search(a);
//    return new ProductDTO(product.getProductID(),product.getCatID(),product.getProductName(),product.getMaterial(),product.getUnitPrice(),product.getQtyOnHand(),);
//
//
//    }

    @Override
    public boolean addcart(OrdersDTO cart) throws ClassNotFoundException, SQLException {
        return Boolean.parseBoolean(null);
    }


    @Override
    public boolean purchaseOrder(CustomeeDTO customeeDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            for (OrdersDTO dto : customeeDTO.getOrderDetailListt()) {

                boolean isAdded = orderDAO.add(new Orders(
                        dto.getOID(),
                        dto.getCustContact(),
                        dto.getCategoryID(),
                        dto.getProductName(),
                        dto.getMaterial(),
                        Double.parseDouble(String.valueOf(dto.getUnitPrice())),
                        Integer.parseInt(String.valueOf(dto.getQty()))

                ));
                if (!isAdded) {
                    connection.rollback();
                    return false;
                }
                if (isAdded) {

                    for (ProductDTO dtoo : customeeDTO.getProductListt()) {
                        boolean isPaid = productDAO.update(new Product(
                                dtoo.getCatID(),
                                dtoo.getProductName(),
                                dtoo.getProductID(),
                                dtoo.getMaterial(),
                                Double.parseDouble(String.valueOf(dtoo.getUnitPrice())),
                                Integer.parseInt(String.valueOf(dtoo.getQtyOnHand()))

                        ));

                        if (!isPaid) {
                            connection.rollback();
                            return false;
                        }

                    }
                    connection.commit();
                    return true;

                } else {
                    connection.rollback();
                    return false;
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            connection.setAutoCommit(true);

        }
    return true;
    }
}

