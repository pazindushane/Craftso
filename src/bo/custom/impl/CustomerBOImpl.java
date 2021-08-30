package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO c = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean add(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        Customer cust = new Customer(customer.getCustContact(),customer.getCustID(),customer.getCustName(),customer.getAddress(),customer.getEmail());
        return c.add(cust);
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return c.delete(id);
    }

    @Override
    public boolean update(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        Customer cust = new Customer(customer.getCustContact(),customer.getCustID(),customer.getCustName(),customer.getAddress(),customer.getEmail());
        return c.update(cust);
    }

    @Override
    public CustomerDTO search(String id) throws ClassNotFoundException, SQLException {
        Customer customer = c.search(id);
        return new CustomerDTO(customer.getCustContact(),customer.getCustID(),customer.getCustName(),customer.getAddress(),customer.getEmail());
    }

    @Override
    public ObservableList<CustomerDTO> getAll() throws ClassNotFoundException, SQLException {
        ObservableList<Customer> customers = c.getAll();
        ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
        for (Customer c : customers) {
            list.add(new CustomerDTO(c.getCustContact(),c.getCustID(),c.getCustName(),c.getAddress(),c.getEmail()));
        }
        return list;
    }

    @Override
    public String getLastCustID() throws Exception {
        return c.getLastID();
    }


}
