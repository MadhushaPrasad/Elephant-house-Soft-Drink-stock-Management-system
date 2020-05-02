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
public class VolumeDTO {

    private String volume_ID;
    private String volume_size;
    private int volume_qty;
    private double price;

    public VolumeDTO() {
    }

    public VolumeDTO(String volume_ID, String volume_size, int volume_qty, double price) {
        this.volume_ID = volume_ID;
        this.volume_size = volume_size;
        this.volume_qty = volume_qty;
        this.price = price;
    }

    public String getVolume_ID() {
        return volume_ID;
    }

    public void setVolume_ID(String volume_ID) {
        this.volume_ID = volume_ID;
    }

    public String getVolume_size() {
        return volume_size;
    }

    public void setVolume_size(String volume_size) {
        this.volume_size = volume_size;
    }

    public int getVolume_qty() {
        return volume_qty;
    }

    public void setVolume_qty(int volume_qty) {
        this.volume_qty = volume_qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
