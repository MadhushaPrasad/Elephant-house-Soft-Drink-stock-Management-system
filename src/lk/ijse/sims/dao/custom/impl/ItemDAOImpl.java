/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.sims.dao.CrudUtil;
import lk.ijse.sims.dao.custom.ItemDAO;
import lk.ijse.sims.entity.Item;

/**
 *
 * @author acer
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(Item t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?,?,?)", t.getiID(), t.getvID(), t.getiBID(), t.getMFDate(), t.getEXDate(), t.getItemName());
    }

    @Override
    public boolean update(Item t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("UPDATE item SET vID=?,iBID=?,MFDate=?,EXDate=?,ItemName=? WHERE iID=? ", t.getvID(), t.getiBID(), t.getMFDate(), t.getEXDate(), t.getItemName(), t.getiID());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE iID=?", id);
    }

    @Override
    public Item search(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item WHERE iID=?", id);
        Item item = null;
        while (rst.next()) {
            item = new Item();
            item.setiID(rst.getString(1));
            item.setvID(rst.getString(2));
            item.setiBID(rst.getString(3));
            item.setMFDate(rst.getString(4));
            item.setEXDate(rst.getString(5));
            item.setItemName(rst.getString(6));
        }
        return item;
    }

    @Override
    public ArrayList<Item> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item");
        ArrayList<Item> allItem = new ArrayList<>();
        while (rst.next()) {
            Item item = new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
            allItem.add(item);
        }
        return allItem;
    }

    @Override
    public ObservableList<String> getItemBatchID() throws Exception {
        String sql = "SELECT iBID FROM item_batch";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> itemBatchID = FXCollections.observableArrayList();
        while (rst.next()) {;
            itemBatchID.add(rst.getString("iBID"));
        }
        return itemBatchID;
    }

    @Override
    public ObservableList<String> getVolumeID() throws Exception {
        String sql = "SELECT vID FROM volume";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> volumeID = FXCollections.observableArrayList();
        while (rst.next()) {
            volumeID.add(rst.getString("vID"));

        }
        return volumeID;
    }

    @Override
    public ObservableList<String> getItemIDAll() throws ClassNotFoundException, SQLException, Exception {
        String sql = "SELECT iID FROM item";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> itemID = FXCollections.observableArrayList();
        while (rst.next()) {
            itemID.add(rst.getString("iID"));

        }
        return itemID;
    }

}
