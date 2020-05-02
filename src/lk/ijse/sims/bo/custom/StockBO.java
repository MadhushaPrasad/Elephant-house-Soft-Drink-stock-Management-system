/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.ijse.sims.bo.SuperBO;
import lk.ijse.sims.dto.StockDTO;

/**
 *
 * @author acer
 */
public interface StockBO extends SuperBO{
     public boolean addStock(StockDTO stock) throws SQLException, ClassNotFoundException, Exception;

    public boolean deleteStock(String id) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateStock(StockDTO stock) throws SQLException, ClassNotFoundException, Exception;

    public StockDTO searchStock(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<StockDTO> getAllStock() throws ClassNotFoundException, SQLException, Exception;
    
    public ObservableList<String> getStockID()throws ClassNotFoundException,SQLException,Exception;
}
