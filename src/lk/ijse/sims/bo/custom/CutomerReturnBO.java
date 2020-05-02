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
import lk.ijse.sims.dto.CustomerReturnDTO;

/**
 *
 * @author acer
 */
public interface CutomerReturnBO extends SuperBO {

    public ObservableList<String> orderType() throws ClassNotFoundException, SQLException, Exception;

    public ObservableList<String> getCustomerAll() throws ClassNotFoundException, SQLException, Exception;

    public ObservableList<String> getItemIDAll() throws ClassNotFoundException, SQLException, Exception;

    public ObservableList<String> getVolumeAll() throws ClassNotFoundException, SQLException, Exception;
    
     public boolean addCustomer(CustomerReturnDTO customer) throws SQLException, ClassNotFoundException, Exception;

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateCustomer(CustomerReturnDTO customer) throws SQLException, ClassNotFoundException, Exception;

    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<CustomerReturnDTO> getAllCustomers() throws ClassNotFoundException, SQLException, Exception;

    public ObservableList<String> getCustomerID() throws Exception;

}
