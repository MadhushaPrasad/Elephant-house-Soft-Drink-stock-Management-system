/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.sims.dao.CrudDAO;
import lk.ijse.sims.entity.Stock;

/**
 *
 * @author acer
 */
public interface StockDAO extends CrudDAO<Stock, String>{
     public ObservableList<String> getStockID() throws Exception;
}
