/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.sims.bo.BOFactory;
import lk.ijse.sims.bo.custom.VolumeBO;
import lk.ijse.sims.dto.VolumeDTO;
import lk.ijse.sims.tablemodel.VolumeTM;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class Volume_ViewController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private JFXButton btnBackVolume;
    @FXML
    private TableView<VolumeTM> tblVolumeView;
    @FXML
    private JFXTextField txtVolumeID;
    @FXML
    private JFXTextField txtVolumeSize;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtUnitePriceAc;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private Label lblV;
    @FXML
    private Label lblS;
    @FXML
    private Label lblQTY;
    @FXML
    private Label lblU;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tblVolumeView.getColumns().get(0).setStyle("-fx-alignment:center");
            tblVolumeView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("volume_ID"));
            tblVolumeView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Volume_Size"));
            tblVolumeView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("QTY"));
            tblVolumeView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Unit_price"));
            getAllVolume();
        } catch (Exception ex) {
            Logger.getLogger(Volume_ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tblVolumeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<VolumeTM>() {
            @Override
            public void changed(ObservableValue<? extends VolumeTM> observable, VolumeTM oldValue, VolumeTM newValue) {
                try {
                    VolumeTM selectedVolume = tblVolumeView.getSelectionModel().getSelectedItem();
                    selectedVolume.getVolume_ID();
                    selectedVolume.getVolume_Size();
                    selectedVolume.getQTY();
                    selectedVolume.getUnit_price();
                    txtVolumeID.setText(selectedVolume.getVolume_ID());
                    txtVolumeSize.setText(selectedVolume.getVolume_Size());
                    txtQty.setText(selectedVolume.getQTY() + "");
                    txtUnitePriceAc.setText(selectedVolume.getUnit_price() + "");

                    lblQTY.setText("QTY");
                    lblS.setText("Volume Size");
                    lblU.setText("Unit Price");
                    lblV.setText("Volume ID");

                } catch (Exception e) {
                }
            }
        });

        if (txtVolumeID.getText().isEmpty() && txtVolumeSize.getText().isEmpty() && txtQty.getText().isEmpty() && txtUnitePriceAc.getText().isEmpty()) {
            lblQTY.setText("");
            lblS.setText("");
            lblU.setText("");
            lblV.setText("");
        }

    }

    @FXML
    private void btnBackVolume(MouseEvent event) {
        Stage stage = (Stage) this.mainAnchor.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void txtVolumeIDAc(ActionEvent event) {
        txtVolumeSize.requestFocus();
    }

    @FXML
    private void txtVolumeSizeAc(ActionEvent event) {
        txtQty.requestFocus();
    }

    @FXML
    private void txtQtyAc(ActionEvent event) {
        btnUpdate.requestFocus();
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
        String volume_ID = txtVolumeID.getText();
        String volume_size = txtVolumeSize.getText();
        int volume_qty = Integer.parseInt(txtQty.getText());
        double volume_Price = Double.parseDouble(txtUnitePriceAc.getText());

        VolumeDTO volumeDTO = new VolumeDTO(volume_ID, volume_size, volume_qty, volume_Price);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure to Update Volume ?");
        alert.setHeaderText(null);
        alert.setTitle("Confirmation dialog");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {

            try {
                boolean volumeUpdate = ItemController.volumeUpdate(volumeDTO);

                if (volumeUpdate) {
                    clearAllVolumeField();
                    loadAllVolume();
                    infoBox("Item Volume Updated...!", null, "updated");
                } else {
                    warningMessageBox("Item Volume Not Updated...!", null,
                            "Warning");
                }
            } catch (Exception ex) {
                Logger.getLogger(Volume_ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void btnDeleteAc(ActionEvent event) throws Exception {
        String Volume_ID = txtVolumeID.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure to Delete ?");
        alert.setHeaderText(null);
        alert.setTitle("Confirmation dialog");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            boolean deleteItemBatch = ItemController.deleteVolume(Volume_ID);
            if (deleteItemBatch) {
                clearAllVolumeField();
                loadAllVolume();
                infoBox("Item Volume Deleted...!", null, null);
            } else {
                warningMessageBox("Item Volume Not Deleted...!", null,
                        "Warning");
            }
        }
    }

    private void getAllVolume() throws SQLException, Exception {
        VolumeBO bo = (VolumeBO) BOFactory.getInstance().getBOType(BOFactory.BOType.VOLUME);
        ObservableList<VolumeTM> lis = tblVolumeView.getItems();
        lis.clear();

        ArrayList<VolumeDTO> arList = bo.getAllVolume();
        for (VolumeDTO volumeDTO : arList) {
            lis.add(new VolumeTM(volumeDTO.getVolume_ID(), volumeDTO.getVolume_size(), volumeDTO.getVolume_qty(), volumeDTO.getPrice()));

        }
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

    private void clearAllVolumeField() {
        txtVolumeID.setText("");
        txtVolumeSize.setText("");
        txtQty.setText("");
        txtUnitePriceAc.setText("");
        txtVolumeID.requestFocus();
    }

    private void loadAllVolume() {

        try {
            VolumeBO bo = (VolumeBO) BOFactory.getInstance().getBOType(BOFactory.BOType.VOLUME);
            ObservableList<VolumeTM> lis = tblVolumeView.getItems();
            lis.clear();

            ArrayList<VolumeDTO> arList = bo.getAllVolume();
            for (VolumeDTO itemDTO : arList) {
                lis.add(new VolumeTM(itemDTO.getVolume_ID(), itemDTO.getVolume_size(), itemDTO.getVolume_qty(), itemDTO.getPrice()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Volume_ViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Volume_ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
