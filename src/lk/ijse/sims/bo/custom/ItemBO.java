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
import lk.ijse.sims.dto.ItemDTO;

/**
 *
 * @author dell
 */
public interface ItemBO extends SuperBO{
    public boolean addItem(ItemDTO item) throws SQLException, ClassNotFoundException, Exception;

    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException, Exception;

    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException, Exception;
    
    public ObservableList<String> getItemBatchID() throws Exception;

    public ObservableList<String> getVolumeID() throws Exception;
}
