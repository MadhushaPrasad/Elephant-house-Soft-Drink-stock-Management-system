/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.sims.dao.CrudUtil;
import lk.ijse.sims.dao.custom.CustomerDAO;
import lk.ijse.sims.entity.Customer;

/**
 *
 * @author acer
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer c) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("INSERT INTO customer VALUES(?,?,?,?,?)", c.getCustID(), c.getFName(), c.getLName(), c.getAddress(), c.getTelNumber());
    }

    @Override
    public boolean update(Customer c) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("UPDATE customer SET FName=?,LName=?,Address=?,TelNumber=? WHERE CustID=?", c.getFName(), c.getLName(), c.getAddress(), c.getTelNumber(), c.getCustID());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("DELETE FROM Customer WHERE CustID=?", id);
    }

    @Override
    public Customer search(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer WHERE CustID=?", id);
        Customer customer = null;
        while (rst.next()) {
            customer = new Customer();
            customer.setCustID(rst.getString(1));
            customer.setFName(rst.getString(2));
            customer.setLName(rst.getString(3));
            customer.setAddress(rst.getString(4));
            customer.setTelNumber(rst.getString(5));
        }
        return customer;
    }

    @Override
    public ArrayList<Customer> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer");
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            Customer customer = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public ObservableList<String> getCustomerID() throws Exception {
        String sql = "SELECT CustID FROM Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> customerID = FXCollections.observableArrayList();
        while (rst.next()) {;
            customerID.add(rst.getString("CustID"));
        }
        return customerID;
    }

}
