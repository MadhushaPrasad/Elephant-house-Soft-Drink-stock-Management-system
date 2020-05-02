/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class DashboardController implements Initializable {

    @FXML
    private ImageView imgDash;
    @FXML
    private Button btnCustomer2;
    @FXML
    private Button btnInvoice2;
    @FXML
    private Button btnReport2;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btnStock;
    @FXML
    private ImageView close;
    @FXML
    private Button btnItem;
    @FXML
    private Button btnReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnCustomerMouseClick(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/CustomerForm.fxml"));
        if (!mainPane.getChildren().isEmpty()) ;
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnStock(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Stock.fxml"));
        if (!mainPane.getChildren().isEmpty()) ;
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnItem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Item.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnInvoiceAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/InvoiceForm.fxml"));
        if (!mainPane.getChildren().isEmpty()) ;
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnReturnAc(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/CutomerReturn.fxml"));
        if (!mainPane.getChildren().isEmpty()) ;
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnReportAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Report.fxml"));
        if (!mainPane.getChildren().isEmpty()) ;
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(pane);
    }

}
