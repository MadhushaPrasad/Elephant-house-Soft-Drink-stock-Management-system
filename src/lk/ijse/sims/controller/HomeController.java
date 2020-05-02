/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class HomeController implements Initializable {

    @FXML
    private JFXButton btnLogout;
    @FXML
    private JFXButton btnDashBoard;
    @FXML
    private JFXButton btnCustomer;
    @FXML
    private JFXButton btnStock;
    @FXML
    private JFXButton btnItem;
    @FXML
    private JFXButton btnInvoice;
    @FXML
    private JFXButton btnReturn;
    @FXML
    private Label lblStoc_management;
    @FXML
    private AnchorPane main;
    @FXML
    private JFXButton btnReport;
    @FXML
    private AnchorPane bodyPane;
    @FXML
    private Label lblStoc_management2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Dashboard.fxml"));
            bodyPane.getChildren().setAll(pane);
            reflection();
            btnDashBoard.requestFocus();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnLogoutKeyPressed(KeyEvent event) {

    }

    @FXML
    private void btnLogoutAC(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Login.fxml"));
        Scene temp = new Scene(root);
        Stage stage = (Stage) this.main.getScene().getWindow();
        stage.setScene(temp);
        stage.centerOnScreen();
        stage.setResizable(false);
    }
//    void effict(){
//        DropShadow ds = new DropShadow();
//        ds.setOffsetY(5.0);
//        ds.setOffsetX(5.0);
//        ds.setColor(Color.GRAY);
//        
//        btnCustomer.setEffect(ds);
//        btnDashBoard.setEffect(ds);
//        btnInvoice.setEffect(ds);
//        btnItem.setEffect(ds);
//        btnReturn.setEffect(ds);
//        btnStock.setEffect(ds);
//    }

    private void reflection() {
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
        reflection.setTopOffset(-20);

        lblStoc_management.setEffect(reflection);
        lblStoc_management2.setEffect(reflection);

    }

    @FXML
    private void btnDashBoardKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
//            case ENTER:
//                btnCancle.setVisible(true);
//                break;
//            case RIGHT:
//                btnCustomer2.requestFocus();
//                break;
            case DOWN:
                btnCustomer.requestFocus();
                break;
            case SHIFT:
                break;
            default:
                break;
        }
    }

//    @FXML
//    private void btnCustomerKeyPressed(KeyEvent event) {
//        switch (event.getCode()) {
////            case ENTER:
////                btnCancle.setVisible(true);
////                break;
////            case RIGHT:
////                btnCustomer2.requestFocus();
////                break;
//            case UP:
//                btnDashBoard.requestFocus();
//                break;
//            case DOWN:
//                btnStock.requestFocus();
//                break;
//            case SHIFT:
//                btnDashBoard.requestFocus();
//                break;
//            default:
//                break;
//        }
//    }
//
//    @FXML
//    private void btnStockKeyPressed(KeyEvent event) {
//        switch (event.getCode()) {
////            case ENTER:
////                btnCancle.setVisible(true);
////                break;
////            case RIGHT:
////                btnCustomer2.requestFocus();
////                break;
//            case UP:
//                btnCustomer.requestFocus();
//                break;
//            case DOWN:
//                btnItem.requestFocus();
//                break;
//            case SHIFT:
//                btnDashBoard.requestFocus();
//                break;
//            default:
//                break;
//        }
//    }
//
//    @FXML
//    private void btnItemKeyPressed(KeyEvent event) {
//        switch (event.getCode()) {
////            case ENTER:
////                btnCancle.setVisible(true);
////                break;
////            case RIGHT:
////                btnCustomer2.requestFocus();
////                break;
//            case UP:
//                btnStock.requestFocus();
//                break;
//            case DOWN:
//                btnInvoice.requestFocus();
//                break;
//            case SHIFT:
//                btnDashBoard.requestFocus();
//                break;
//            default:
//                break;
//        }
//    }
//
//    @FXML
//    private void btnInvoiceKeyPressed(KeyEvent event) {
//        switch (event.getCode()) {
////            case ENTER:
////                btnCancle.setVisible(true);
////                break;
////            case RIGHT:
////                btnCustomer2.requestFocus();
////                break;
//            case UP:
//                btnItem.requestFocus();
//                break;
//            case DOWN:
//                btnReturn.requestFocus();
//                break;
//            case SHIFT:
//                btnDashBoard.requestFocus();
//                break;
//            default:
//                break;
//        }
//    }
//
//    @FXML
//    private void btnReturnKeyPressed(KeyEvent event) {
//        switch (event.getCode()) {
////            case ENTER:
////                btnCancle.setVisible(true);
////                break;
////            case RIGHT:
////                btnCustomer2.requestFocus();
////                break;
//            case UP:
//                btnInvoice.requestFocus();
//                break;
//            case DOWN:
//                btnReport.requestFocus();
//                break;
//            case SHIFT:
//                btnDashBoard.requestFocus();
//                break;
//            default:
//                break;
//        }
//    }
//
//    @FXML
//    private void btnReportKeyPressed(KeyEvent event) {
//        switch (event.getCode()) {
////            case ENTER:
////                btnCancle.setVisible(true);
////                break;
////            case RIGHT:
////                btnCustomer2.requestFocus();
////                break;
//            case UP:
//                btnReturn.requestFocus();
//                break;
//            case DOWN:
//                btnLogout.requestFocus();
//                break;
//            case SHIFT:
//                btnDashBoard.requestFocus();
//                break;
//            default:
//                break;
//        }
//    }

    @FXML
    private void btnDashBoardAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Dashboard.fxml"));
        bodyPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnCustomerAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/CustomerForm.fxml"));
        bodyPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnStockAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Stock.fxml"));
        bodyPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnItemAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Item.fxml"));
        bodyPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnInvoiceAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/InvoiceForm.fxml"));
        bodyPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnReturnAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/CutomerReturn.fxml"));
        bodyPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnReportAC(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Report.fxml"));
        bodyPane.getChildren().setAll(pane);
    }

//    @FXML
//    private void starttt(KeyEvent event) {
//         btnDashBoard.requestFocus();
//    }

}
