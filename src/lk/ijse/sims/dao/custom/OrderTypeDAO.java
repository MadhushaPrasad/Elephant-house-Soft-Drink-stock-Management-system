/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.sims.dao.SuperDAO;


/**
 *
 * @author acer
 */
public interface OrderTypeDAO extends SuperDAO{
    public ObservableList<String> getOrderType() throws Exception;
    
}
