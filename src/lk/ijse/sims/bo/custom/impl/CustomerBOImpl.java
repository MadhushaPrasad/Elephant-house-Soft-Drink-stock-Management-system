/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.ijse.sims.bo.custom.CustomerBO;
import lk.ijse.sims.dao.DAOFactory;
import lk.ijse.sims.dao.custom.CustomerDAO;
import lk.ijse.sims.dto.CustomerDTO;
import lk.ijse.sims.entity.Customer;

/**
 *
 * @author acer
 */
public class CustomerBOImpl implements CustomerBO{
    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException, Exception {
            return dao.add(new Customer(customer.getCustomer_ID(), customer.getCustomer_FName(), customer.getCustomer_LName(), customer.getCustomerAddress(), customer.getCustomer_Tel()));
    }

    @Override
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
       return dao.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException, Exception {
       return dao.update(new Customer(customer.getCustomer_ID(), customer.getCustomer_FName(), customer.getCustomer_LName(), customer.getCustomerAddress(), customer.getCustomer_Tel()));
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        Customer searCustomer = dao.search(id);
        return new CustomerDTO(searCustomer.getCustID(), searCustomer.getFName(), searCustomer.getLName(), searCustomer.getAddress(), searCustomer.getTelNumber());
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = dao.getAll();
        for (Customer a : all) {
            allCustomers.add(new CustomerDTO(a.getCustID(), a.getFName(), a.getLName(), a.getAddress(), a.getTelNumber()));
        }
        return allCustomers;
    }

    @Override
    public ObservableList<String> getCustomerID() throws Exception {
        return dao.getCustomerID();
    }

    
}
