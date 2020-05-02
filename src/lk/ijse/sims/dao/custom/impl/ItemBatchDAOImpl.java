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
import lk.ijse.sims.dao.custom.ItemBatchDAO;
import lk.ijse.sims.entity.Item_Batch;

/**
 *
 * @author acer
 */
public class ItemBatchDAOImpl implements ItemBatchDAO {

    @Override
    public boolean add(Item_Batch t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("INSERT INTO item_batch VALUES(?,?,?,?,?)", t.getsID(), t.getiBID(), t.getMfDate(), t.geteXDATE(), t.getPrice());
    }

    @Override
    public boolean update(Item_Batch t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("UPDATE item_batch SET sID=?,mfDate=?,eXDATE=?,Price=? WHERE iBID=?", t.getsID(), t.getMfDate(), t.geteXDATE(), t.getPrice(), t.getiBID());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("DELETE FROM item_batch WHERE iBID=?", id);
    }

    @Override
    public Item_Batch search(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item_batch WHERE iBID=?", id);
        Item_Batch itemBatch = null;
        while (rst.next()) {
            itemBatch = new Item_Batch();
            itemBatch.setsID(rst.getString(1));
            itemBatch.setiBID(rst.getString(2));
            itemBatch.setMfDate(rst.getString(3));
            itemBatch.seteXDATE(rst.getString(4));
            itemBatch.setPrice(rst.getDouble(5));
        }
        return itemBatch;
    }

    @Override
    public ArrayList<Item_Batch> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item_batch");
        ArrayList<Item_Batch> allItemBatch = new ArrayList<>();
        while (rst.next()) {
            Item_Batch customer = new Item_Batch(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
            allItemBatch.add(customer);
        }
        return allItemBatch;
    }
}
