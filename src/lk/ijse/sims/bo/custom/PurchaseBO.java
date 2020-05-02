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
import lk.ijse.sims.dto.CustomDTO;
import lk.ijse.sims.dto.OrdersDTO;
import lk.ijse.sims.entity.CustomEntity;

/**
 *
 * @author acer
 */
public interface PurchaseBO extends SuperBO {

    public boolean purchaseOrder(OrdersDTO dto) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<CustomEntity> searchOrders(String oid) throws Exception;

    public ObservableList<String> orderType() throws ClassNotFoundException, SQLException, Exception;

    public ObservableList<String> getCustomerAll() throws ClassNotFoundException, SQLException, Exception;
    
    public ObservableList<String> getItemIDAll() throws ClassNotFoundException, SQLException, Exception;
    
     public CustomDTO searchItem(String id) throws ClassNotFoundException, SQLException, Exception;
    

}
