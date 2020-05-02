/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class CustomerReturnViewController implements Initializable {

    @FXML
    private AnchorPane paneCustomerReturnD;
    @FXML
    private TableView<?> tblReturnDetails;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnSelectedDelete;
    @FXML
    private ImageView close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mouseClickedSelected(MouseEvent event) {
    }

    @FXML
    private void btnBack(MouseEvent event) {
        Stage stage = (Stage) this.paneCustomerReturnD.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnSelectedDelete(MouseEvent event) {
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }
    
}
