/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.sims.dao.CrudUtil;
import lk.ijse.sims.dao.custom.QueryDAO;
import lk.ijse.sims.entity.CustomEntity;

/**
 *
 * @author acer
 */
public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomEntity> searchOrders(String orderID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomEntity searchItem(String id) throws ClassNotFoundException, SQLException, Exception {
        ResultSet rst = CrudUtil.executeQuery("select i.ItemName, i.MFdate, i.EXDate, v.QTY, v.price FROM item i, volume v where i.vID = v.vID && i.iID = ? ", id);
        CustomEntity item = null;
        while (rst.next()) {
            item = new CustomEntity();
            item.setItemName(rst.getString(1));
            item.setMFDate(rst.getString(2));
            item.setEXDate(rst.getString(3));
            item.setUnitPrice(rst.getDouble(5));
            item.setQty(rst.getInt(4));
        }
        return item;
    }
}
