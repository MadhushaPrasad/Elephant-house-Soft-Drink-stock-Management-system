/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.sims.bo.BOFactory;
import lk.ijse.sims.bo.custom.PurchaseBO;
import lk.ijse.sims.dto.CustomDTO;
import lk.ijse.sims.dto.CustomerDTO;
import lk.ijse.sims.tablemodel.InvoiceTM;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class InvoiceFormController implements Initializable {

    static PurchaseBO bo = (PurchaseBO) BOFactory.getInstance().getBOType(BOFactory.BOType.PURCHASE);

    private static ObservableList<String> getCustomerType() throws SQLException, Exception {
        return bo.orderType();
    }

    private static ObservableList<String> getCustomerID() throws SQLException, Exception {
        return bo.getCustomerAll();
    }

    private static CustomDTO searItemDetails(String itemID) throws SQLException, Exception {
        return bo.searchItem(itemID);
    }
    private static ObservableList<String> getItemType() throws SQLException, Exception {
        return bo.getItemIDAll();
    }

    @FXML
    private AnchorPane invoiceAnchore;
    @FXML
    private JFXButton btnCustomerForm;
    @FXML
    private ImageView close;
    @FXML
    private JFXButton btnItemForm;
    @FXML
    private JFXComboBox<String> cmbCustomerID;
    @FXML
    private JFXTextField txtCustomerFirstName;
    @FXML
    private JFXTextField txtCustomerSearchID;
    @FXML
    private JFXTextField txtCustomerAdddress;
    @FXML
    private JFXTextField txtLastName;
    @FXML
    private JFXComboBox<String> cmdCustomerType;
    @FXML
    private JFXTextField txtOrderID;
    @FXML
    private JFXDatePicker dtPickerOrder;
    @FXML
    private JFXComboBox<String> cmbItemID;
    @FXML
    private JFXTextField txtItemName;
    @FXML
    private JFXTextField txtMFdate;
    @FXML
    private JFXTextField txtQTYAvaila;
    @FXML
    private JFXTextField txtExdate;
    @FXML
    private JFXTextField txttUnitPrice;
    @FXML
    private JFXTextField txtQTY;
    @FXML
    private JFXTextField txtItemID;
    @FXML
    private TableView<InvoiceTM> tblInvoice;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<String> getCustomerType = InvoiceFormController.getCustomerType();
            cmdCustomerType.setItems(getCustomerType);
            
            ObservableList<String> getCustomerID = InvoiceFormController.getCustomerID();
            cmbCustomerID.setItems(getCustomerID);
            
            ObservableList<String> getItemID = InvoiceFormController.getItemType();
            cmbItemID.setItems(getItemID);
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(InvoiceFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnItemForm(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Item.fxml"));
        if (!invoiceAnchore.getChildren().isEmpty()) ;
        invoiceAnchore.getChildren().clear();
        invoiceAnchore.getChildren().setAll(pane);
    }

    @FXML
    private void btnCustomerFormAc(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/CustomerForm.fxml"));
        if (!invoiceAnchore.getChildren().isEmpty()) ;
        invoiceAnchore.getChildren().clear();
        invoiceAnchore.getChildren().setAll(pane);
    }

    @FXML
    private void txtOrderIDActionPerformed(ActionEvent event) throws SQLException, Exception {
        dtPickerOrder.requestFocus();
//        String customerID = null;
//
//        CustomerDTO searcCustomer = CustomerFormController.bo.searchCustomer(customerID);
//        txtCustomerSearchID.setText(searcCustomer.getCustomer_ID());
//        txtCustomerFirstName.setText(searcCustomer.getCustomer_FName());
//        txtLastName.setText(searcCustomer.getCustomer_LName());
//        txtCustomerAdddress.setText(searcCustomer.getCustomerAddress());

    }

    @FXML
    private void cmbCustomerID(ActionEvent event) throws Exception {
        customerDetails();
        cmdCustomerType.requestFocus();
    }

    @FXML
    private void txtCustomerSearchID(ActionEvent event) throws Exception{
        String custID = txtCustomerSearchID.getText();
        cmbCustomerID.getSelectionModel().select(custID);
        CustomerDTO searchCustomer = CustomerFormController.searchCustomer(custID);
        txtCustomerFirstName.setText(searchCustomer.getCustomer_FName());
        txtLastName.setText(searchCustomer.getCustomer_LName());
        txtCustomerAdddress.setText(searchCustomer.getCustomerAddress());
        cmdCustomerType.requestFocus();
    }
//
//    void setCmbCustomerType() {
//        ObservableList<String> ol = FXCollections.observableArrayList("Credit", "Cash");
//        cmdCustomerType.setItems(ol);
//    }
    
    void customerDetails() throws Exception{
        String custID = cmbCustomerID.getSelectionModel().getSelectedItem();
        CustomerDTO searchCustomer = CustomerFormController.searchCustomer(custID);
        txtCustomerFirstName.setText(searchCustomer.getCustomer_FName());
        txtLastName.setText(searchCustomer.getCustomer_LName());
        txtCustomerAdddress.setText(searchCustomer.getCustomerAddress());
    }

    @FXML
    private void cmbItemIDAc(ActionEvent event) throws Exception {
        itemDetails();
    }
    
    void itemDetails() throws Exception{
        String itemID = cmbItemID.getSelectionModel().getSelectedItem();
        CustomDTO searchItem = InvoiceFormController.searItemDetails(itemID);
        txtItemName.setText(searchItem.getItemName());
        txtMFdate.setText(searchItem.getMFDate());
        txtExdate.setText(searchItem.getEXDate());
        txttUnitPrice.setText(searchItem.getUnitPrice()+"");
        txtQTYAvaila.setText(searchItem.getQty()+"");
    }

    @FXML
    private void cmdCustomerType(ActionEvent event) {
        cmbItemID.requestFocus();
    }

    @FXML
    private void txtItemNameAc(ActionEvent event) {
    }

    @FXML
    private void txtMFdateAc(ActionEvent event) {
    }

    @FXML
    private void txtQTYAvailaAc(ActionEvent event) {
    }

    @FXML
    private void txtExdateAc(ActionEvent event) {
    }

    @FXML
    private void txttUnitPriceAc(ActionEvent event) {
    }

    @FXML
    private void txtQTYAc(ActionEvent event) {
    }

    @FXML
    private void txtItemIDAC(ActionEvent event) throws Exception {
        String itemID = txtCustomerSearchID.getText();
        CustomDTO searchItem = InvoiceFormController.searItemDetails(itemID);
        txtItemName.setText(searchItem.getItemName());
        txtMFdate.setText(searchItem.getMFDate());
        txtExdate.setText(searchItem.getEXDate());
        txttUnitPrice.setText(searchItem.getUnitPrice()+"");
        txtQTYAvaila.setText(searchItem.getQty()+"");
    }
    
    void calculateTotal(){
        double temptotal = 0;
//         ArrayList<InvoiceTM> getTblRow = new ArrayList<>();
//         for (InvoiceTM invoiceTM : getTblRow) {
//            getTblRow.add(new InvoiceTM(invoiceTM.getItem_ID(),invoiceTM.getItem_Name(),invoiceTM.getUnite_Price(),invoiceTM.getQTY(),invoiceTM.getTotal()));
//        }
        for (int i = 0; i < tblInvoice.getSelectionModel().getTableView().getItems().size(); i++) {
//s            double total = Double.parseDouble(tblInvoice.getSelectionModel().select(i,4))
//            temptotal = temptotal + total;
        }
        
//           public void calculateTotal() {
//
//        double temptotal = 0;
//        for (int i = 0; i < dtm.getRowCount(); i++) {
//            double total = Double.parseDouble(dtm.getValueAt(i, 4).toString());
//            temptotal = temptotal + total;
//        }
//        lblTotal.setText(temptotal + "");
//
//        double discount = Double.parseDouble(txtDiscount.getText());
//        double fixTotal = Double.parseDouble(lblTotal.getText());
//
////        calculation
//        double total = ((100 - discount) * fixTotal) / 100;
//        lblSubTotal.setText(total + "");
//
//    }

    }
}
