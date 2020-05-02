/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.ijse.sims.bo.custom.PurchaseBO;
import lk.ijse.sims.dao.DAOFactory;
import lk.ijse.sims.dao.custom.CustomerDAO;
import lk.ijse.sims.dao.custom.ItemDAO;
import lk.ijse.sims.dao.custom.OrderDetailDAO;
import lk.ijse.sims.dao.custom.OrderTypeDAO;
import lk.ijse.sims.dao.custom.OrdersDAO;
import lk.ijse.sims.dao.custom.QueryDAO;
import lk.ijse.sims.db.DBConnection;
import lk.ijse.sims.dto.CustomDTO;
import lk.ijse.sims.dto.OrderDetailsDTO;
import lk.ijse.sims.dto.OrdersDTO;
import lk.ijse.sims.entity.CustomEntity;
import lk.ijse.sims.entity.OrderDetails;
import lk.ijse.sims.entity.Orders;

/**
 *
 * @author acer
 */
public class PurchaseBOImpl implements PurchaseBO{
    QueryDAO dao = (QueryDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.QUERY);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.ORDERDETAILS);
    OrdersDAO ordersDao = (OrdersDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.ORDERS);
    OrderTypeDAO otDAO = (OrderTypeDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.ORDERTYPE);
    CustomerDAO custDAo = (CustomerDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.CUSTOMER);
    ItemDAO idao = (ItemDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.ITEM);
   
    @Override
    public boolean purchaseOrder(OrdersDTO dto) throws ClassNotFoundException, SQLException, Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean addDetailsandType = ordersDao.add(new Orders(dto.getCustID(), dto.getoID(), dto.getoTID(), dto.getDate()));
        if(addDetailsandType){
            for (OrderDetailsDTO o : dto.getOrderDetails()){
                boolean ordeDetailAded = orderDetailDAO.add(new OrderDetails(o.getoID(), o.getiID(), o.getQty(), o.getUnitPrice()));
                if (!ordeDetailAded) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

    }
    @Override
    public ArrayList<CustomEntity> searchOrders(String oid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 

    @Override
    public ObservableList<String> orderType() throws ClassNotFoundException, SQLException, Exception {
        return otDAO.getOrderType();
    }

    @Override
    public ObservableList<String> getCustomerAll() throws ClassNotFoundException, SQLException, Exception {
        return custDAo.getCustomerID();
    }

    @Override
    public CustomDTO searchItem(String id) throws ClassNotFoundException, SQLException, Exception {
        CustomEntity searCustomer = dao.searchItem(id);
        return new CustomDTO(searCustomer.getQty(),searCustomer.getUnitPrice(),searCustomer.getMFDate(),searCustomer.getEXDate(),searCustomer.getItemName());
    }

    @Override
    public ObservableList<String> getItemIDAll() throws ClassNotFoundException, SQLException, Exception {
        return idao.getItemIDAll();
    }
}
