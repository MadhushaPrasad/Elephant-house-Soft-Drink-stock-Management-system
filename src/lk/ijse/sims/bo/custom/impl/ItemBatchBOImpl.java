/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.sims.bo.custom.ItemBatchBO;
import lk.ijse.sims.dao.DAOFactory;
import lk.ijse.sims.dao.custom.ItemBatchDAO;
import lk.ijse.sims.dto.Item_BatchDTO;
import lk.ijse.sims.entity.Item_Batch;

/**
 *
 * @author acer
 */
public class ItemBatchBOImpl implements ItemBatchBO{
   ItemBatchDAO dao = (ItemBatchDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.ITEM_BATCH);
    @Override
    public boolean addItemBatch(Item_BatchDTO itemBatch) throws SQLException, ClassNotFoundException, Exception {
        return dao.add(new Item_Batch(itemBatch.getSid(), itemBatch.getBatchID(), itemBatch.getMfDate(), itemBatch.getExDate(), itemBatch.getPrice()));
    }

    @Override
    public boolean deleteItemBatch(String id) throws ClassNotFoundException, SQLException, Exception {
       return dao.delete(id);
    }

    @Override
    public boolean updateItemBatch(Item_BatchDTO itemBatch) throws SQLException, ClassNotFoundException, Exception {
       return dao.update(new Item_Batch(itemBatch.getSid(), itemBatch.getBatchID(), itemBatch.getMfDate(), itemBatch.getExDate(), itemBatch.getPrice()));
    }

    @Override
    public Item_BatchDTO searchItemBatch(String id) throws ClassNotFoundException, SQLException, Exception {
       Item_Batch item_Batch = dao.search(id);
       return new Item_BatchDTO(item_Batch.getsID(), item_Batch.getiBID(), item_Batch.getMfDate(), item_Batch.geteXDATE(), item_Batch.getPrice());
    }

    @Override
    public ArrayList<Item_BatchDTO> getAllItem() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Item_BatchDTO> allItemBatch = new ArrayList<>();
        ArrayList<Item_Batch> all = dao.getAll();
        for (Item_Batch a : all) {
            allItemBatch.add(new Item_BatchDTO(a.getsID(), a.getiBID(), a.getMfDate(), a.geteXDATE(), a.getPrice()));
        }
        return allItemBatch;
    }
}
