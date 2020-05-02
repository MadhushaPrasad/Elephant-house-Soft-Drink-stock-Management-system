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
public class VolumeTM {
    private String Volume_ID;
    private String Volume_Size;
    private int QTY;
    private double Unit_price;

    public VolumeTM() {
    }

    public VolumeTM(String Volume_ID, String Volume_Size, int QTY, double Unit_price) {
        this.Volume_ID = Volume_ID;
        this.Volume_Size = Volume_Size;
        this.QTY = QTY;
        this.Unit_price = Unit_price;
    }

    public String getVolume_ID() {
        return Volume_ID;
    }

    public void setVolume_ID(String Volume_ID) {
        this.Volume_ID = Volume_ID;
    }

    public String getVolume_Size() {
        return Volume_Size;
    }

    public void setVolume_Size(String Volume_Size) {
        this.Volume_Size = Volume_Size;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public double getUnit_price() {
        return Unit_price;
    }

    public void setUnit_price(double Unit_price) {
        this.Unit_price = Unit_price;
    }
    
}
