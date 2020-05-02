/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao;

import lk.ijse.sims.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.sims.dao.custom.impl.ItemBatchDAOImpl;
import lk.ijse.sims.dao.custom.impl.ItemDAOImpl;
import lk.ijse.sims.dao.custom.impl.LoginDAOImpl;
import lk.ijse.sims.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.sims.dao.custom.impl.OrderTypeDAOImpl;
import lk.ijse.sims.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.sims.dao.custom.impl.QueryDAOImpl;
import lk.ijse.sims.dao.custom.impl.StockDAOImpl;
import lk.ijse.sims.dao.custom.impl.UserDAOImpl;
import lk.ijse.sims.dao.custom.impl.VolumeDAOImpl;

/**
 *
 * @author acer
 */
public class DAOFactory {

    private static DAOFactory dAOFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public enum DAOType {
        LOGIN, USER, CUSTOMER, VOLUME, ITEM, STOCK,
        ITEM_BATCH, ORDERS, ORDERDETAILS, ORDERTYPE, QUERY
    }

    public SuperDAO getDAOType(DAOType types) {
        switch (types) {
            case LOGIN:
                return new LoginDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case STOCK:
                return new StockDAOImpl();
            case ITEM_BATCH:
                return new ItemBatchDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case VOLUME:
                return new VolumeDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case ORDERTYPE:
                return new OrderTypeDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
