package bo.custom;

import bo.SuperBO;
import dto.*;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CartBO extends SuperBO {
    public ArrayList<String> search(String id) throws ClassNotFoundException,SQLException;
    public boolean add(CartDTO cart) throws ClassNotFoundException, SQLException;
    String getLastPID() throws Exception;

    ProductDTO searchProduct(String toString) throws SQLException, ClassNotFoundException;
    //public ArrayList<ProductDTO> getAllp() throws ClassNotFoundException, SQLException;
    //public ArrayList<CatagoryDTO> getAllc() throws ClassNotFoundException, SQLException;
     //public RoomDTO searchRoom(String RoomNo) throws SQLException, ClassNotFoundException;
    public boolean addcart(OrdersDTO cart) throws ClassNotFoundException, SQLException;
    //public boolean purchaseOrder(CustomeeDTO dto) throws ClassNotFoundException,SQLException;

    boolean purchaseOrder(CustomeeDTO customeeDTO) throws SQLException, ClassNotFoundException;
}
