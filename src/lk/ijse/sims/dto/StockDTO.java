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
public class StockDTO {

    private String stock_ID;
    private String stock_Date;
    private double stock_Price;

    public StockDTO() {
    }

    public StockDTO(String stock_ID, String stock_Date, double stock_Price) {
        this.stock_ID = stock_ID;
        this.stock_Date = stock_Date;
        this.stock_Price = stock_Price;
    }

    public String getStock_ID() {
        return stock_ID;
    }

    public void setStock_ID(String stock_ID) {
        this.stock_ID = stock_ID;
    }

    public String getStock_Date() {
        return stock_Date;
    }

    public void setStock_Date(String stock_Date) {
        this.stock_Date = stock_Date;
    }

    public double getStock_Price() {
        return stock_Price;
    }

    public void setStock_Price(double stock_Price) {
        this.stock_Price = stock_Price;
    }

}
