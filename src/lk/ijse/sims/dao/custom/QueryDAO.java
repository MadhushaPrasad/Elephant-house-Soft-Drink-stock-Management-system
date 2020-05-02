/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.sims.dao.SuperDAO;
import lk.ijse.sims.entity.CustomEntity;

/**
 *
 * @author acer
 */
public interface QueryDAO extends SuperDAO {

    public ArrayList<CustomEntity> searchOrders(String orderID) throws Exception;

    public CustomEntity searchItem(String id) throws ClassNotFoundException, SQLException, Exception;
}
