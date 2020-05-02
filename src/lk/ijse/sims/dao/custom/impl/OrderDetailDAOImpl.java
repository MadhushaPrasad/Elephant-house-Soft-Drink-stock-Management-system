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
import lk.ijse.sims.dao.custom.OrderDetailDAO;
import lk.ijse.sims.entity.OrderDetails;

/**
 *
 * @author acer
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{

    @Override
    public boolean add(OrderDetails t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("insert into OrderDetails values(?,?,?,?)", t.getiID(), t.getoID(), t.getQty(), t.getUnitPrice());
    }

    @Override
    public boolean update(OrderDetails t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update OrderDetails  set iID=?,qty=?,UnitPrice=? where oID=?", t.getiID(), t.getQty(), t.getUnitPrice(), t.getoID());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from OrderDetails where oID=?", id);
    }

    @Override
    public OrderDetails search(String id) throws ClassNotFoundException, SQLException {
       ResultSet rst = CrudUtil.executeQuery("select * from OrderDetails where oID=?", id);
        OrderDetails detail = null;
        while (rst.next()) {
            detail = new OrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3)+"",rst.getDouble(4)+"");
        }
        return detail;
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws ClassNotFoundException, SQLException {
         ResultSet rst = CrudUtil.executeQuery("select * from OrderDetail");
        ArrayList<OrderDetails> allOrderDetails = new ArrayList<>();
        while (rst.next()) {
            allOrderDetails.add(new OrderDetails(rst.getString(1), rst.getString(2), rst.getInt(3)+"", rst.getDouble(4)+""));
        }
        return allOrderDetails;
    }
    
}
