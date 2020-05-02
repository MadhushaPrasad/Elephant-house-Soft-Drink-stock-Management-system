/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.sims.bo.SuperBO;
import lk.ijse.sims.dto.Item_BatchDTO;

/**
 *
 * @author acer
 */
public interface ItemBatchBO extends SuperBO{
     public boolean addItemBatch(Item_BatchDTO itemBatch) throws SQLException, ClassNotFoundException, Exception;

    public boolean deleteItemBatch(String id) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateItemBatch(Item_BatchDTO itemBatch) throws SQLException, ClassNotFoundException, Exception;

    public Item_BatchDTO searchItemBatch(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<Item_BatchDTO> getAllItem() throws ClassNotFoundException, SQLException, Exception;
}
