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
import lk.ijse.sims.dao.custom.OrdersDAO;
import lk.ijse.sims.entity.Orders;

/**
 *
 * @author acer
 */
public class OrdersDAOImpl implements OrdersDAO{

    @Override
    public boolean add(Orders t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Orders values(?,?,?,?)", t.getCustID(), t.getoID(), t.getoTID(),t.getDate());
    }

    @Override
    public boolean update(Orders t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update  Orders  set CustID=?, oTID=?, date=? where oID=?", t.getCustID(),t.getoTID(),t.getDate(),t.getoID());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Orders where oID=?", id);
    }

    @Override
    public Orders search(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Orders where oID=?)", id);
        Orders orders = null;
        while (rst.next()) {
            orders = new Orders(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4));
        }
        return orders;
    }

    @Override
    public ArrayList<Orders> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Orders");
        ArrayList<Orders> allOrders = new ArrayList<>();
        while (rst.next()) {
            allOrders.add(new Orders(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4)));
        }
        return allOrders;
    }
    
}
