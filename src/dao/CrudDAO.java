package dao;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T, ID> extends SuperDAO {
    public boolean add(T t) throws ClassNotFoundException, SQLException;
    public boolean delete(ID id) throws ClassNotFoundException,SQLException;
    public boolean update(T t) throws ClassNotFoundException,SQLException;
    public T search(ID id) throws ClassNotFoundException,SQLException;
    public ObservableList<T> getAll() throws ClassNotFoundException,SQLException;


}
