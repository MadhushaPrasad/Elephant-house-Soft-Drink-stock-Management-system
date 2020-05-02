/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import lk.ijse.sims.bo.BOFactory;
import lk.ijse.sims.bo.custom.CustomerBO;
import lk.ijse.sims.dto.CustomerDTO;
/**
 * FXML Controller class
 *
 * @author acer
 */
public class CustomerFormController implements Initializable {

    static CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBOType(BOFactory.BOType.CUSTOMER);

    private static boolean addCustomer(CustomerDTO customer) throws NumberFormatException, ClassNotFoundException, Exception {
        return bo.addCustomer(customer);
    }

    private static ArrayList<CustomerDTO> getAllCustomers() throws SQLException, Exception {
        return bo.getAllCustomers();
    }

    private static boolean updateCustomer(CustomerDTO tempCustomer) throws ClassNotFoundException, Exception {
        return bo.updateCustomer(tempCustomer);
    }

    private static boolean deleteCustomer(String customerID) throws SQLException, Exception {
        return bo.deleteCustomer(customerID);
    }

    public static CustomerDTO searchCustomer(String customerID) throws SQLException, Exception {
        return bo.searchCustomer(customerID);
    }

    @FXML
    private JFXTextField txtCustomerID;
    @FXML
    private JFXTextField txtFName;
    @FXML
    private JFXTextField txtLastName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtTel;
    @FXML
    private JFXButton btnCustDelete;
    @FXML
    private JFXButton btnCustUpdate;
    @FXML
    private JFXButton btnCustRegister;
    @FXML
    private TableView<CustomerDTO> tblCustomer;
    @FXML
    private ImageView close;
    @FXML
    private JFXTextField txtSearchCustomer;
    @FXML
    private Button btnSearchCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            txtFName.requestFocus();
            tblCustomer.getColumns().get(0).setStyle("-fx-alignment:center");
            tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customer_ID"));
            tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customer_FName"));
            tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customer_LName"));
            tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
            tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("customer_Tel"));

            tblCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerDTO>() {
                @Override
                public void changed(ObservableValue<? extends CustomerDTO> observable, CustomerDTO oldValue, CustomerDTO newValue) {
                    try {
                        CustomerDTO selectedCustomer = observable.getValue();
                        selectedCustomer.getCustomer_ID();
                        selectedCustomer.getCustomer_FName();
                        selectedCustomer.getCustomer_LName();
                        selectedCustomer.getCustomerAddress();
                        selectedCustomer.getCustomer_Tel();

                        txtCustomerID.setText(selectedCustomer.getCustomer_ID());
                        txtFName.setText(selectedCustomer.getCustomer_FName());
                        txtLastName.setText(selectedCustomer.getCustomer_LName());
                        txtAddress.setText(selectedCustomer.getCustomerAddress());
                        txtTel.setText(selectedCustomer.getCustomer_Tel());
                    } catch (Exception e) {

                    }
                }

            });

//            setCid();
            clearAll();
            loadAllCustomer();
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void txtCustomerIDKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case DOWN:
                txtFName.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void txtCustomerIDAC(ActionEvent event) {
        txtFName.requestFocus();
    }

    @FXML
    private void txtFNameKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case DOWN:
                txtLastName.requestFocus();
                break;
            case UP:
                txtCustomerID.requestFocus();
            default:
                break;
        }
    }

    @FXML
    private void txtFNameAC(ActionEvent event) {
        if (Pattern.compile("^[A-Z]{1}[a-z]{1,9}$").matcher(txtFName.getText()).matches()) {
            txtLastName.requestFocus();
        } else {
            txtFName.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Name format is Invalid...\nYou need to use first letter CAPITAL and other letters are SIMPLE like this \"Prasad\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void txtLastNameKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case DOWN:
                txtAddress.requestFocus();
                break;
            case UP:
                txtFName.requestFocus();
            default:
                break;
        }
    }

    @FXML
    private void txtLastNameAC(ActionEvent event) {
        if (Pattern.compile("^[A-Z]{1}[a-z]{1,9}$").matcher(txtLastName.getText()).matches()) {
            txtAddress.requestFocus();
        } else {
            txtLastName.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Name format is Invalid...\nYou need to use first letter CAPITAL and other letters are SIMPLE like this \"Prasad\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void txtAddressKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case DOWN:
                txtTel.requestFocus();
                break;
            case UP:
                txtLastName.requestFocus();
            default:
                break;
        }
    }

    @FXML
    private void txtAddressAC(ActionEvent event) {
        txtTel.requestFocus();
    }

    @FXML
    private void txtTelKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                txtAddress.requestFocus();
            default:
                break;
        }
    }

    @FXML
    private void txtTelAC(ActionEvent event) {
        if (Pattern.compile("[0]{1}[0-9]{9}").matcher(txtTel.getText()).matches()) {
            btnCustRegister.requestFocus();
        } else {
            txtTel.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Telephone number format is Invalid...\nYou need to use 10 numbers and first number is nessesary to be \"0\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void btnCustDelete(ActionEvent event) {
        String customerID = txtCustomerID.getText();

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure to Delete ?");
            alert.setHeaderText(null);
            alert.setTitle("Confirmation dialog");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                boolean deleteCustomer = CustomerFormController.deleteCustomer(customerID);
                if (deleteCustomer) {
                    clearAll();
                    loadAllCustomer();
                    infoBox("Customer Deleted...!", null, null);
                } else {
                    warningMessageBox("Customer Not Deleted...!", null,
                            "Warning");
                }
                loadAllCustomer();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "You Cannot Input :" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnCustUpdate(ActionEvent event) {
        if (txtCustomerID.getText().trim().isEmpty() || txtFName.getText().trim().isEmpty() || txtLastName.getText().trim().isEmpty() || txtAddress.getText().trim().isEmpty() || txtTel.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Some Data");
            a.show();
        } else {
            String customerID = txtCustomerID.getText();
            String customerFirstName = txtFName.getText();
            String customerLastName = txtLastName.getText();
            String customerAddress = txtAddress.getText();
            String telephone = txtTel.getText();
            CustomerDTO tempCustomer = new CustomerDTO(customerID, customerFirstName, customerLastName, customerAddress, telephone);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure to Update ?");
            alert.setHeaderText(null);
            alert.setTitle("Confirmation dialog");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                try {
                    boolean updateCustomer = CustomerFormController.updateCustomer(tempCustomer);
                    if (updateCustomer) {
                        infoBox("Customer Updated...!", null, "updated");
                        loadAllCustomer();
                        clearAll();
                    } else {
                        errMessageBox("Customer Not Updated...!", null, "Warning");
                    }
                } catch (SQLException | NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @FXML
    private void btnCustRegister(ActionEvent event
    ) {
        if (txtCustomerID.getText().trim().isEmpty() || txtFName.getText().trim().isEmpty() || txtLastName.getText().trim().isEmpty() || txtAddress.getText().trim().isEmpty() || txtTel.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Some Data");
            a.show();
        } else {
            String customerID = txtCustomerID.getText();
            String customerFirstName = txtFName.getText();
            String customerLastName = txtLastName.getText();
            String customerAddress = txtAddress.getText();
            String telephone = txtTel.getText();
            CustomerDTO customer = new CustomerDTO(customerID, customerFirstName, customerLastName, customerAddress, telephone);
            boolean addCustomer;
            try {
                addCustomer = CustomerFormController.addCustomer(customer);
                if (addCustomer) {
                    loadAllCustomer();
                    clearAll();
                    infoBox("Done", null, "Done");
                } else {
                    errMessageBox("Not Done", null, "Error");
                }

            } catch (SQLException | NullPointerException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You Cannot Input :" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void clearAll() {
        txtCustomerID.setText("");
        txtFName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
        txtCustomerID.requestFocus();
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void errMessageBox(String errorMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(errorMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void warningMessageBox(String errorMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(errorMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();

    }

    public static void confirmationBox(String errorMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(errorMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    @FXML
    private void tblCustomerMouseClick(MouseEvent event) {
//        tblClick();
    }

    private void loadAllCustomer() {

        try {
            ArrayList<CustomerDTO> list = CustomerFormController.getAllCustomers();
//            ObservableList<CustomerTM> newList = tblCustomer.getItems();
//            list.forEach((customerDTO) -> {
//                newList.add(new CustomerTM(customerDTO.getCustomerID(), customerDTO.getCustomerFirstName(), customerDTO.getCustomerLastName(), customerDTO.getCustomerAddress(), customerDTO.getTelephone()));
//            });
//            if (newList.size() > 0) {
//                tblCustomer.getSelectionModel().clearAndSelect(0);
//            }
            tblCustomer.setItems(FXCollections.observableArrayList(list));
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    public void setCid() throws ClassNotFoundException, SQLException, IOException {
//
//        String newId = null;
//
//        newId = IDGenarator.getNewID("customer", "CustID", "c0");
//        txtCustomerID.setText(newId);
//    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnSearchCustomerAc(ActionEvent event) {
         if (txtSearchCustomer.getText().trim().isEmpty()) {
            txtFName.requestFocus();
        } else if (!(txtSearchCustomer.getText().trim().isEmpty())) {
            try {
                String customerID = txtSearchCustomer.getText();
                CustomerDTO searchCustomer = CustomerFormController.searchCustomer(customerID);
                clearAll();
                txtCustomerID.setText(searchCustomer.getCustomer_ID());
                txtFName.setText(searchCustomer.getCustomer_FName());
                txtLastName.setText(searchCustomer.getCustomer_LName());
                txtAddress.setText(searchCustomer.getCustomerAddress());
                txtTel.setText(searchCustomer.getCustomer_Tel());
                txtCustomerID.requestFocus();
            } catch (Exception ex) {
                Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
