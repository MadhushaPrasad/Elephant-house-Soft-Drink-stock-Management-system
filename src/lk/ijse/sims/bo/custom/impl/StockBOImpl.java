/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.ijse.sims.bo.custom.StockBO;
import lk.ijse.sims.dao.DAOFactory;
import lk.ijse.sims.dao.custom.StockDAO;
import lk.ijse.sims.dto.StockDTO;
import lk.ijse.sims.entity.Stock;

/**
 *
 * @author acer
 */
public class StockBOImpl implements StockBO {

    StockDAO dao = (StockDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.STOCK);

    @Override
    public boolean addStock(StockDTO stock) throws SQLException, ClassNotFoundException, Exception {
        return dao.add(new Stock(stock.getStock_ID(), stock.getStock_Date(), stock.getStock_Price()));
    }

    @Override
    public boolean deleteStock(String id) throws ClassNotFoundException, SQLException, Exception {
         return dao.delete(id);
    }

    @Override
    public boolean updateStock(StockDTO stock) throws SQLException, ClassNotFoundException, Exception {
        return dao.update(new Stock(stock.getStock_ID(), stock.getStock_Date(), stock.getStock_Price()));
    }

    @Override
    public StockDTO searchStock(String id) throws ClassNotFoundException, SQLException, Exception {
        Stock searchStock = dao.search(id);
        return new StockDTO(searchStock.getsID(), searchStock.getDate(), searchStock.getPrice());
    }

    @Override
    public ArrayList<StockDTO> getAllStock() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<StockDTO> getAllStock = new ArrayList<>();
        ArrayList<Stock> all = dao.getAll();
        for (Stock stock : all) {
            getAllStock.add(new StockDTO(stock.getsID(), stock.getDate(), stock.getPrice()));
        }
        return getAllStock;
    }

    @Override
    public ObservableList<String> getStockID() throws ClassNotFoundException, SQLException, Exception {
        return dao.getStockID();
    }

}
