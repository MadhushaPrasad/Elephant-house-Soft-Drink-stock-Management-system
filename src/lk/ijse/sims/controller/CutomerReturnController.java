/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class CutomerReturnController implements Initializable {

    @FXML
    private JFXButton btnCreate;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnReturnView;
    @FXML
    private ImageView close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void btnCreate(ActionEvent event) {
        
    }

    @FXML
    private void btnUpdate(MouseEvent event) {
    }

    @FXML
    private void btnReturnView(MouseEvent event) {
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }
    
}
