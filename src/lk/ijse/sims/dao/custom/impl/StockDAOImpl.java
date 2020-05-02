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
import lk.ijse.sims.dao.custom.StockDAO;
import lk.ijse.sims.entity.Stock;

/**
 *
 * @author acer
 */
public class StockDAOImpl implements StockDAO {

    @Override
    public ObservableList<String> getStockID() throws Exception {
        String sql = "SELECT sID FROM stock";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> stockID = FXCollections.observableArrayList();
        while (rst.next()) {
            stockID.add(rst.getString("sID"));
        }
        return stockID;
    }

    @Override
    public boolean add(Stock t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("INSERT INTO stock VALUES(?,?,?)", t.getsID(), t.getDate(), t.getPrice());
    }

    @Override
    public boolean update(Stock t) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("UPDATE  stock SET Price=?,Date=? WHERE sID=?", t.getPrice(), t.getDate(), t.getsID());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
       return CrudUtil.executeUpdate("delete * from stock where sID=?", id);
    }

    @Override
    public Stock search(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM stock WHERE sID=?", id);
        Stock stock = null;
        while (rst.next()) {
            stock = new Stock();
            stock.setsID(rst.getString(1));
            stock.setDate(rst.getString(2));
            stock.setPrice(rst.getDouble(3));
        }
        return stock;
    }

    @Override
    public ArrayList<Stock> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM stock");
        ArrayList<Stock> list = new ArrayList<>();
        while (rst.next()) {
            Stock stock = new Stock(rst.getString(1), rst.getString(2), rst.getDouble(3));
            list.add(stock);
        }
        return list;
    }

}
