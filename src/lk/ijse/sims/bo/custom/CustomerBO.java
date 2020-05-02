/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.ijse.sims.bo.SuperBO;
import lk.ijse.sims.dto.CustomerDTO;

/**
 *
 * @author acer
 */
public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException, Exception;

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException, Exception;

    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException, Exception;

    public ObservableList<String> getCustomerID() throws Exception;
}
