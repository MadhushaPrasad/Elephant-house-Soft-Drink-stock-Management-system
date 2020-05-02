/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom.impl;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.sims.dao.CrudUtil;
import lk.ijse.sims.dao.custom.OrderTypeDAO;

/**
 *
 * @author acer
 */
public class OrderTypeDAOImpl implements OrderTypeDAO{

    @Override
    public ObservableList<String> getOrderType() throws Exception {
        String sql = "SELECT type FROM OrderType";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> OrderType = FXCollections.observableArrayList();
        while (rst.next()) {
            OrderType.add(rst.getString("type"));

        }
        return OrderType;
    }
    
}
