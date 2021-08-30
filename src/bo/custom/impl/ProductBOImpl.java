package bo.custom.impl;

import bo.custom.ProductBO;
import dao.DAOFactory;
import dao.custom.CartDAO;
import dao.custom.ProductDAO;
import dao.custom.impl.ProductDAOImpl;
import dto.CustomerDTO;
import dto.ProductDTO;
import entity.Customer;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductBOImpl implements ProductBO {
    ProductDAO c = (ProductDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRODUCT);
    CartDAO d = (CartDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CART);

    private final ProductDAO productDAO = new ProductDAOImpl();




    @Override
    public String getLastCustID() throws Exception {
        return c.getLastID();
    }

    @Override
    public boolean add(ProductDTO product) throws ClassNotFoundException, SQLException {
       Product pro = new Product(product.getCatID(),product.getProductName(),product.getProductID(),product.getMaterial(),product.getUnitPrice(),product.getQtyOnHand());
        return c.add(pro);
    }

    @Override
    public ObservableList<ProductDTO> getAll() throws ClassNotFoundException, SQLException {
        ObservableList<Product> customers = c.getAll();
        ObservableList<ProductDTO> list = FXCollections.observableArrayList();
        for (Product c : customers) {
            list.add(new ProductDTO(c.getCatID(),c.getProductName(),c.getProductID(),c.getMaterial(),c.getUnitPrice(),c.getQtyOnHand()));
        }
        return list;
    }

    @Override
    public ProductDTO search(String id) throws ClassNotFoundException, SQLException {
        Product product = c.search(id);
        return new ProductDTO(product.getCatID(),product.getProductName(),product.getProductID(),product.getMaterial(),product.getUnitPrice(),product.getQtyOnHand());


}


    @Override
    public ArrayList<String> getAllc() throws Exception {
        return c.getCategoryID();
    }

    @Override
    public ArrayList<String> getAllp(String value) throws SQLException, ClassNotFoundException {
        return c.getProductnames(value);
    }

    @Override
    public ArrayList<Object> Searchpp(String value) throws SQLException, ClassNotFoundException {

        return c.Searchp(value);
    }

    @Override
    public String getLastCatID() throws Exception {
        return c.getLastCID();
    }

    @Override
    public boolean update(ProductDTO productDTO) throws ClassNotFoundException, SQLException {
        Product product = new Product(productDTO.getCatID(),productDTO.getProductName(),productDTO.getProductID(),productDTO.getMaterial(),productDTO.getUnitPrice(),productDTO.getQtyOnHand());
        return c.update(product);
    }


}
