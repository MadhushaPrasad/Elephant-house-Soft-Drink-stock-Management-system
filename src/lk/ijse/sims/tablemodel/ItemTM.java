/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.tablemodel;

/**
 *
 * @author acer
 */
public class ItemTM {
    private String BatchID;
    private String ItemID;
    private String VolumeID;
    private String ItemName;
    private String ManufactureDate;
    private String EpiryDate;

    public ItemTM() {
    }

    public ItemTM(String BatchID, String ItemID, String VolumeID, String ItemName, String ManufactureDate, String EpiryDate) {
        this.BatchID = BatchID;
        this.ItemID = ItemID;
        this.VolumeID = VolumeID;
        this.ItemName = ItemName;
        this.ManufactureDate = ManufactureDate;
        this.EpiryDate = EpiryDate;
    }

    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String BatchID) {
        this.BatchID = BatchID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public String getVolumeID() {
        return VolumeID;
    }

    public void setVolumeID(String VolumeID) {
        this.VolumeID = VolumeID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(String ManufactureDate) {
        this.ManufactureDate = ManufactureDate;
    }

    public String getEpiryDate() {
        return EpiryDate;
    }

    public void setEpiryDate(String EpiryDate) {
        this.EpiryDate = EpiryDate;
    }
    
}
