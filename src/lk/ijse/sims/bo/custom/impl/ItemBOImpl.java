/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.ijse.sims.bo.custom.ItemBO;
import lk.ijse.sims.dao.DAOFactory;
import lk.ijse.sims.dao.custom.ItemDAO;
import lk.ijse.sims.dto.ItemDTO;
import lk.ijse.sims.entity.Item;

/**
 *
 * @author acer
 */
public class ItemBOImpl implements ItemBO {

    ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.ITEM);

    @Override
    public boolean addItem(ItemDTO item) throws SQLException, ClassNotFoundException, Exception {
        return dao.add(new Item(item.getItemID(), item.getVolumeID(), item.getItemBatchID(), item.getManufactureDate(), item.getExpiryDate(), item.getItemName()));
    }

    @Override
    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException, Exception {
        return dao.delete(id);
    }

    @Override
    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException, Exception {
        return dao.update(new Item(item.getItemID(), item.getVolumeID(), item.getItemBatchID(), item.getManufactureDate(), item.getExpiryDate(), item.getItemName()));
    }

    @Override
    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException, Exception {
        Item searchItem = dao.search(id);
        return new ItemDTO(searchItem.getiID(), searchItem.getvID(), searchItem.getiBID(), searchItem.getMFDate(), searchItem.getEXDate(), searchItem.getItemName());
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<ItemDTO> allItem = new ArrayList<>();
        ArrayList<Item> all = dao.getAll();
        for (Item item : all) {
            allItem.add(new ItemDTO(item.getiID(), item.getvID(), item.getiBID(), item.getMFDate(), item.getEXDate(), item.getItemName()));
        }
        return allItem;
    }

    @Override
    public ObservableList<String> getItemBatchID() throws Exception {
        return dao.getItemBatchID();
    }

    @Override
    public ObservableList<String> getVolumeID() throws Exception {
        return dao.getVolumeID();
    }

}
