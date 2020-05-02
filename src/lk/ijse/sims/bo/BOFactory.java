/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo;

import lk.ijse.sims.bo.custom.impl.CustomerBOImpl;
import lk.ijse.sims.bo.custom.impl.ItemBOImpl;
import lk.ijse.sims.bo.custom.impl.ItemBatchBOImpl;
import lk.ijse.sims.bo.custom.impl.LoginBOImpl;
import lk.ijse.sims.bo.custom.impl.PurchaseBOImpl;
import lk.ijse.sims.bo.custom.impl.StockBOImpl;
import lk.ijse.sims.bo.custom.impl.UserBOImpl;
import lk.ijse.sims.bo.custom.impl.VolumeBOImpl;

/**
 *
 * @author acer
 */
public class BOFactory {

    private static BOFactory bOFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public enum BOType {
        LOGIN, USER, CUSTOMER, VOLUME, ITEM, ORDERS, ORDERDETAILS, STOCK,
        ITEM_BATCH, PURCHASE;
    }

    public SuperBO getBOType(BOType types) {
        switch (types) {
            case LOGIN:
                return new LoginBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case STOCK:
                return new StockBOImpl();
            case ITEM_BATCH:
                return new ItemBatchBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case VOLUME:
                return new VolumeBOImpl();
            case PURCHASE:
                return new PurchaseBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
