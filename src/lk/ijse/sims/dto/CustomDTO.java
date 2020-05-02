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
public class CustomDTO {
    
    
    
     private String oid;
    private String date;
    private String customerID;
    private String itemCode;
    private int qty;
    private double unitPrice;
    private String oTID;
     private String MFDate;
    private String EXDate;
    private String ItemName;
    

    public CustomDTO(String oid, String date, String customerID, String itemCode, int qty, double unitPrice, String oTID, String MFDate, String EXDate, String ItemName) {
        this.oid = oid;
        this.date = date;
        this.customerID = customerID;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.oTID = oTID;
        this.MFDate = MFDate;
        this.EXDate = EXDate;
        this.ItemName = ItemName;
    }
    

//    private String customer_ID;
//    private String customer_FName;
//    private String customer_LName;
//    private String customerAddress;
//    private String customer_Tel;
//
//    private String itemID;
//    private String ManufactureDate;
//    private String ExpiryDate;
//    private String ItemName;
//
//    private String batchID;
//    private String mfDate;
//    private String exDate;
//    private double Price;
//
//    private String stock_ID;
//    private String stock_Date;
//    private double stock_Price;
//
//    private String user_Name;
//    private String user_Email;
//    private String user_Password;
//
//    private String volume_ID;
//    private String volume_size;
//    private int volume_qty;
//    private double price;
//
//    private String CustID;
//    private String oID;
//    private String oTID;
//    private String date;
//
//    private String type;
//
//    private String iID;
//    private String qty;
//    private String UnitPrice;

//    public CustomDTO() {
//    }
//
//    public CustomDTO(String customer_ID, String customer_FName, String customer_LName, String customerAddress, String customer_Tel, String itemID, String ManufactureDate, String ExpiryDate, String ItemName, String batchID, String mfDate, String exDate, double Price, String stock_ID, String stock_Date, double stock_Price, String user_Name, String user_Email, String user_Password, String volume_ID, String volume_size, int volume_qty, double price, String CustID, String oID, String oTID, String date, String type, String iID, String qty, String UnitPrice) {
//        this.customer_ID = customer_ID;
//        this.customer_FName = customer_FName;
//        this.customer_LName = customer_LName;
//        this.customerAddress = customerAddress;
//        this.customer_Tel = customer_Tel;
//        this.itemID = itemID;
//        this.ManufactureDate = ManufactureDate;
//        this.ExpiryDate = ExpiryDate;
//        this.ItemName = ItemName;
//        this.batchID = batchID;
//        this.mfDate = mfDate;
//        this.exDate = exDate;
//        this.stock_ID = stock_ID;
//        this.stock_Date = stock_Date;
//        this.stock_Price = stock_Price;
//        this.user_Name = user_Name;
//        this.user_Email = user_Email;
//        this.user_Password = user_Password;
//        this.volume_ID = volume_ID;
//        this.volume_size = volume_size;
//        this.volume_qty = volume_qty;
//        this.price = price;
//        this.CustID = CustID;
//        this.oID = oID;
//        this.oTID = oTID;
//        this.date = date;
//        this.type = type;
//        this.iID = iID;
//        this.qty = qty;
//        this.UnitPrice = UnitPrice;
//    }
//
//    public String getCustomer_ID() {
//        return customer_ID;
//    }
//
//    public void setCustomer_ID(String customer_ID) {
//        this.customer_ID = customer_ID;
//    }
//
//    public String getCustomer_FName() {
//        return customer_FName;
//    }
//
//    public void setCustomer_FName(String customer_FName) {
//        this.customer_FName = customer_FName;
//    }
//
//    public String getCustomer_LName() {
//        return customer_LName;
//    }
//
//    public void setCustomer_LName(String customer_LName) {
//        this.customer_LName = customer_LName;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public String getCustomer_Tel() {
//        return customer_Tel;
//    }
//
//    public void setCustomer_Tel(String customer_Tel) {
//        this.customer_Tel = customer_Tel;
//    }
//
//    public String getItemID() {
//        return itemID;
//    }
//
//    public void setItemID(String itemID) {
//        this.itemID = itemID;
//    }
//
//    public String getManufactureDate() {
//        return ManufactureDate;
//    }
//
//    public void setManufactureDate(String ManufactureDate) {
//        this.ManufactureDate = ManufactureDate;
//    }
//
//    public String getExpiryDate() {
//        return ExpiryDate;
//    }
//
//    public void setExpiryDate(String ExpiryDate) {
//        this.ExpiryDate = ExpiryDate;
//    }
//
//    public String getItemName() {
//        return ItemName;
//    }
//
//    public void setItemName(String ItemName) {
//        this.ItemName = ItemName;
//    }
//
//    public String getBatchID() {
//        return batchID;
//    }
//
//    public void setBatchID(String batchID) {
//        this.batchID = batchID;
//    }
//
//    public String getMfDate() {
//        return mfDate;
//    }
//
//    public void setMfDate(String mfDate) {
//        this.mfDate = mfDate;
//    }
//
//    public String getExDate() {
//        return exDate;
//    }
//
//    public void setExDate(String exDate) {
//        this.exDate = exDate;
//    }
//
//    public double getPrice() {
//        return Price;
//    }
//
//    public void setPrice(double Price) {
//        this.Price = Price;
//    }
//
//    public String getStock_ID() {
//        return stock_ID;
//    }
//
//    public void setStock_ID(String stock_ID) {
//        this.stock_ID = stock_ID;
//    }
//
//    public String getStock_Date() {
//        return stock_Date;
//    }
//
//    public void setStock_Date(String stock_Date) {
//        this.stock_Date = stock_Date;
//    }
//
//    public double getStock_Price() {
//        return stock_Price;
//    }
//
//    public void setStock_Price(double stock_Price) {
//        this.stock_Price = stock_Price;
//    }
//
//    public String getUser_Name() {
//        return user_Name;
//    }
//
//    public void setUser_Name(String user_Name) {
//        this.user_Name = user_Name;
//    }
//
//    public String getUser_Email() {
//        return user_Email;
//    }
//
//    public void setUser_Email(String user_Email) {
//        this.user_Email = user_Email;
//    }
//
//    public String getUser_Password() {
//        return user_Password;
//    }
//
//    public void setUser_Password(String user_Password) {
//        this.user_Password = user_Password;
//    }
//
//    public String getVolume_ID() {
//        return volume_ID;
//    }
//
//    public void setVolume_ID(String volume_ID) {
//        this.volume_ID = volume_ID;
//    }
//
//    public String getVolume_size() {
//        return volume_size;
//    }
//
//    public void setVolume_size(String volume_size) {
//        this.volume_size = volume_size;
//    }
//
//    public int getVolume_qty() {
//        return volume_qty;
//    }
//
//    public void setVolume_qty(int volume_qty) {
//        this.volume_qty = volume_qty;
//    }
//    public String getCustID() {
//        return CustID;
//    }
//
//    public void setCustID(String CustID) {
//        this.CustID = CustID;
//    }
//
//    public String getoID() {
//        return oID;
//    }
//
//    public void setoID(String oID) {
//        this.oID = oID;
//    }
//
//    public String getoTID() {
//        return oTID;
//    }
//
//    public void setoTID(String oTID) {
//        this.oTID = oTID;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getiID() {
//        return iID;
//    }
//
//    public void setiID(String iID) {
//        this.iID = iID;
//    }
//
//    public String getQty() {
//        return qty;
//    }
//
//    public void setQty(String qty) {
//        this.qty = qty;
//    }
//
//    public String getUnitPrice() {
//        return UnitPrice;
//    }
//
//    public void setUnitPrice(String UnitPrice) {
//        this.UnitPrice = UnitPrice;
//    }
//
    public CustomDTO(int qty, double unitPrice, String MFDate, String EXDate, String ItemName) {
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.MFDate = MFDate;
        this.EXDate = EXDate;
        this.ItemName = ItemName;
    }
    public CustomDTO() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getoTID() {
        return oTID;
    }

    public void setoTID(String oTID) {
        this.oTID = oTID;
    }

    public String getMFDate() {
        return MFDate;
    }

    public void setMFDate(String MFDate) {
        this.MFDate = MFDate;
    }

    public String getEXDate() {
        return EXDate;
    }

    public void setEXDate(String EXDate) {
        this.EXDate = EXDate;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
    
}
