/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dto;

/**
 *
 * @author acer
 */
public class Item_BatchDTO {

    private String sid;
    private String batchID;
    private String mfDate;
    private String exDate;
    private double Price;

    public Item_BatchDTO() {
    }

    public Item_BatchDTO(String sID, String iBID, String mfDate, String eXDATE, double Price) {
        this.sid = sID;
        this.batchID = iBID;
        this.mfDate = mfDate;
        this.exDate = eXDATE;
        this.Price = Price;
    }

 

  

    public String getMfDate() {
        return mfDate;
    }

    public void setMfDate(String mfDate) {
        this.mfDate = mfDate;
    }

   

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }


    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the batchID
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * @param batchID the batchID to set
     */
    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    /**
     * @return the exDate
     */
    public String getExDate() {
        return exDate;
    }

    /**
     * @param exDate the exDate to set
     */
    public void setExDate(String exDate) {
        this.exDate = exDate;
    }
    
    
}
