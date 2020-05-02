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
public class CustomerDTO {

    private String customer_ID;
    private String customer_FName;
    private String customer_LName;
    private String customerAddress;
    private String customer_Tel;

    public CustomerDTO() {
    }

    public CustomerDTO(String customer_ID, String customer_FName, String customer_LName, String customerAddress, String customer_Tel) {
        this.customer_ID = customer_ID;
        this.customer_FName = customer_FName;
        this.customer_LName = customer_LName;
        this.customerAddress = customerAddress;
        this.customer_Tel = customer_Tel;
    }

    public String getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getCustomer_FName() {
        return customer_FName;
    }

    public void setCustomer_FName(String customer_FName) {
        this.customer_FName = customer_FName;
    }

    public String getCustomer_LName() {
        return customer_LName;
    }

    public void setCustomer_LName(String customer_LName) {
        this.customer_LName = customer_LName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomer_Tel() {
        return customer_Tel;
    }

    public void setCustomer_Tel(String customer_Tel) {
        this.customer_Tel = customer_Tel;
    }

    public CustomerDTO searItemDetails(String itemID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
