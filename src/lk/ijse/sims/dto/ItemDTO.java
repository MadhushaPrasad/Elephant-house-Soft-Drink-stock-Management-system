/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dto;

/**
 *
 * @author dell
 */
public class ItemDTO {
    private String itemID;
    private String volumeID;
    private String itemBatchID;
    private String ManufactureDate;
    private String ExpiryDate;
    private String ItemName;

    public ItemDTO() {
    }

    public ItemDTO(String itemID, String volumeID, String itemBatchID, String ManufactureDate, String ExpiryDate, String ItemName) {
        this.itemID = itemID;
        this.volumeID = volumeID;
        this.itemBatchID = itemBatchID;
        this.ManufactureDate = ManufactureDate;
        this.ExpiryDate = ExpiryDate;
        this.ItemName = ItemName;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getVolumeID() {
        return volumeID;
    }

    public void setVolumeID(String volumeID) {
        this.volumeID = volumeID;
    }

    public String getItemBatchID() {
        return itemBatchID;
    }

    public void setItemBatchID(String itemBatchID) {
        this.itemBatchID = itemBatchID;
    }

    public String getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(String ManufactureDate) {
        this.ManufactureDate = ManufactureDate;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
    
    
}
