/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.ijse.sims.dao.CrudDAO;
import lk.ijse.sims.entity.Item;

/**
 *
 * @author acer
 */
public interface ItemDAO extends CrudDAO<Item, String>{
    public ObservableList<String> getItemBatchID() throws Exception;

    public ObservableList<String> getVolumeID() throws Exception;
     public ObservableList<String> getItemIDAll() throws ClassNotFoundException, SQLException, Exception;
}
