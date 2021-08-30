package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ProductDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductBO extends SuperBO {


    String getLastCustID() throws Exception;

    public boolean add(ProductDTO product) throws ClassNotFoundException, SQLException;

    public ObservableList<ProductDTO> getAll() throws ClassNotFoundException, SQLException;

    public ProductDTO search(String id) throws ClassNotFoundException,SQLException;

   // ProductDTO searchProduct(String toString) throws SQLException, ClassNotFoundException;

    public ArrayList<String> getAllc()throws Exception;

    ArrayList<String> getAllp(String value) throws SQLException, ClassNotFoundException;

    ArrayList<Object> Searchpp(String value) throws SQLException, ClassNotFoundException;

    String getLastCatID() throws Exception;

    public boolean update(ProductDTO productDTO) throws ClassNotFoundException,SQLException;



}
