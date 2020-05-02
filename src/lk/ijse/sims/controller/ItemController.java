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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.sims.bo.BOFactory;
import lk.ijse.sims.bo.custom.ItemBO;
import lk.ijse.sims.bo.custom.VolumeBO;
import lk.ijse.sims.dto.ItemDTO;
import lk.ijse.sims.dto.VolumeDTO;
import lk.ijse.sims.tablemodel.ItemTM;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class ItemController implements Initializable {

    static ItemBO bo = (ItemBO) BOFactory.getInstance().getBOType(BOFactory.BOType.ITEM);
    private static ObservableList<String> getBatchID;

//    private static ArrayList<ItemTM> getAllItem() throws SQLException, Exception {
//
//    }
    private static boolean addItem(ItemDTO itemDTO) throws ClassNotFoundException, Exception {
        return bo.addItem(itemDTO);
    }

    private static boolean deleteItem(String itemID) throws SQLException, Exception {
        return bo.deleteItem(itemID);
    }
    static VolumeBO vbo = (VolumeBO) BOFactory.getInstance().getBOType(BOFactory.BOType.VOLUME);

    private static boolean addVolume(VolumeDTO volumeDTO) throws ClassNotFoundException, Exception {
        return vbo.addVolume(volumeDTO);
    }

    private static ObservableList<String> getVolumeID() throws Exception {
        return bo.getVolumeID();
    }

    static boolean deleteVolume(String Volume_ID) throws SQLException, Exception {
        return vbo.deleteVolume(Volume_ID);
    }

    static boolean volumeUpdate(VolumeDTO volumeDTO) throws ClassNotFoundException, Exception {
        return vbo.updateVolume(volumeDTO);
    }

    private static ObservableList<String> getBatchID() throws Exception {
        return bo.getItemBatchID();
    }

    private static boolean updateItem(ItemDTO itemUpdate) throws ClassNotFoundException, Exception {
        return bo.updateItem(itemUpdate);
    }

    private static VolumeDTO searchVolume(String Volume_ID) throws SQLException, Exception {
        return vbo.searchVolume(Volume_ID);
    }

    private static ItemDTO searchItem(String Item_ID) throws SQLException, Exception {
        return bo.searchItem(Item_ID);
    }
    @FXML
    private JFXButton btnViewVol;
    @FXML
    private ImageView close;
    @FXML
    private AnchorPane paneItem;
    @FXML
    private JFXComboBox<String> cmdBatchID;
    @FXML
    private JFXTextField txtItemID;
    @FXML
    private JFXTextField txtItemName;
    @FXML
    private JFXComboBox<String> cmdVolumeID;
    @FXML
    private JFXDatePicker detpickerMFDate;
    @FXML
    private JFXDatePicker dtPickerEX;
    @FXML
    private TableView<ItemTM> tblItem;
    @FXML
    private JFXButton btnItemAdd;
    @FXML
    private JFXButton btnItemUpdate;
    @FXML
    private JFXButton btnItemDelete;
    @FXML
    private JFXTextField txtVolumeID;
    @FXML
    private JFXTextField txtVolumeSize;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtUnitePrice;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnVIewItemBatch;
    @FXML
    private Button btnSearchtem;
    @FXML
    private Button btnSearchItemVolume;
    @FXML
    private JFXTextField txtSearchItem;
    @FXML
    private JFXTextField txtSearchVolume;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tblItem.getColumns().get(0).setStyle("-fx-alignment:center");
            tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("BatchID"));
            tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ItemID"));
            tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("VolumeID"));
            tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            tblItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("ManufactureDate"));
            tblItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("EpiryDate"));

            tblItem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItemTM>() {
                @Override
                public void changed(ObservableValue<? extends ItemTM> observable, ItemTM oldValue, ItemTM newValue) {
                    try {
                        ItemTM selectedItem = observable.getValue();
                        selectedItem.getBatchID();
                        selectedItem.getVolumeID();
                        selectedItem.getItemID();
                        selectedItem.getItemName();
                        selectedItem.getManufactureDate();
                        selectedItem.getEpiryDate();

                        cmdBatchID.getSelectionModel().select(selectedItem.getBatchID());
                        cmdVolumeID.getSelectionModel().select(selectedItem.getVolumeID());
                        txtItemID.setText(selectedItem.getItemID());
                        txtItemName.setText(selectedItem.getItemName());
                        detpickerMFDate.setValue(LocalDate.parse(selectedItem.getManufactureDate()));
                        dtPickerEX.setValue(LocalDate.parse(selectedItem.getEpiryDate()));
                    } catch (Exception e) {
                    }
                }
            });

            loadAllItems();
            ObservableList<String> getBatchID = ItemController.getBatchID();
            cmdBatchID.setItems(getBatchID);
            ObservableList<String> getVolumeID = ItemController.getVolumeID();
            cmdVolumeID.setItems(getVolumeID);
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnViewVolAc(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Volume_View.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void cmdBatchIDAc(ActionEvent event) {
        cmdVolumeID.requestFocus();
    }

    @FXML
    private void txtItemIDAc(ActionEvent event) {
        txtItemName.requestFocus();

    }

    @FXML
    private void txtItemNameAc(ActionEvent event) {
        detpickerMFDate.requestFocus();
    }

    @FXML
    private void cmdVolumeIDAC(ActionEvent event) {
        txtItemID.requestFocus();
    }

    @FXML
    private void detpickerMFDateAc(ActionEvent event) {
        dtPickerEX.requestFocus();
    }

    @FXML
    private void dtPickerEX(ActionEvent event) {
        btnItemAdd.requestFocus();
    }

    @FXML
    private void btnItemAddAc(ActionEvent event) {
        try {

            if (dtPickerEX.getValue().toString().isEmpty() || detpickerMFDate.getValue().toString().isEmpty()
                    || txtItemID.getText().trim().isEmpty()
                    || txtItemName.getText().isEmpty() || cmdBatchID.getValue().isEmpty()
                    || cmdVolumeID.getValue().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Some Data");
                a.show();
            } else {
                String itemBatchID = cmdBatchID.getSelectionModel().getSelectedItem();
                String volumeID = cmdVolumeID.getSelectionModel().getSelectedItem();
                String itemID = txtItemID.getText();
                String ItemName = txtItemName.getText();
                String ManufactureDate = detpickerMFDate.getValue().format(DateTimeFormatter.ISO_DATE);
                String ExpiryDate = dtPickerEX.getValue().format(DateTimeFormatter.ISO_DATE);
                ItemDTO itemDTO = new ItemDTO(itemID, volumeID, itemBatchID, ManufactureDate, ExpiryDate, ItemName);
                boolean addItem;
                try {
                    addItem = ItemController.addItem(itemDTO);
                    if (addItem) {
                        infoBox("Done", null, "Done");
                        clearAllitemField();
                        loadAllItems();
                    } else {
                        errMessageBox("Not Done", null, "Error");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e) {
        }
    }

    @FXML
    private void btnItemUpdateAC(ActionEvent event) {
        if (dtPickerEX.getValue().toString().isEmpty() || detpickerMFDate.getValue().toString().isEmpty()
                || txtItemID.getText().trim().isEmpty()
                || txtItemName.getText().isEmpty() || cmdBatchID.getValue().isEmpty()
                || cmdVolumeID.getValue().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Some Data");
            a.show();
        } else {
            String itemBatchID = cmdBatchID.getSelectionModel().getSelectedItem();
            String volumeID = cmdVolumeID.getSelectionModel().getSelectedItem();
            String itemID = txtItemID.getText();
            String ItemName = txtItemName.getText();
            String ManufactureDate = detpickerMFDate.getValue().format(DateTimeFormatter.ISO_DATE);
            String ExpiryDate = dtPickerEX.getValue().format(DateTimeFormatter.ISO_DATE);

            ItemDTO itemUpdate = new ItemDTO(itemID, volumeID, itemBatchID, ManufactureDate, ExpiryDate, ItemName);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure to Update ?");
            alert.setHeaderText(null);
            alert.setTitle("Confirmation dialog");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                boolean update;
                try {
                    update = ItemController.updateItem(itemUpdate);
                    if (update) {
                        infoBox("Updated...!", null, "Done");
                        clearAllitemField();
                        loadAllItems();
                    } else {
                        errMessageBox("Not Updated...!", null, "Error");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @FXML
    private void btnItemDeleteAC(ActionEvent event) {
        String itemID = txtItemID.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure to Delete ?");
        alert.setHeaderText(null);
        alert.setTitle("Confirmation dialog");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            try {
                boolean deleteItem = ItemController.deleteItem(itemID);
                if (deleteItem) {
                    infoBox("Item Deleted...!", null, null);
                    clearAllitemField();
                    loadAllItems();
                } else {
                    warningMessageBox("Item Not Deleted...!", null,
                            "Warning");
                }
                loadAllItems();
            } catch (Exception ex) {
                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    private void clearAllitemField() {
        txtItemID.setText("");
        txtItemName.setText("");
        detpickerMFDate.setValue(null);
        dtPickerEX.setValue(null);
    }

    private void loadAllItems() throws Exception {
        ItemBO bo = (ItemBO) BOFactory.getInstance().getBOType(BOFactory.BOType.ITEM);
        ObservableList<ItemTM> lis = tblItem.getItems();
        lis.clear();

        ArrayList<ItemDTO> arList = bo.getAllItem();
        for (ItemDTO itemDTO : arList) {
            lis.add(new ItemTM(itemDTO.getItemBatchID(), itemDTO.getItemID(),
                    itemDTO.getVolumeID(), itemDTO.getItemName(),
                    itemDTO.getManufactureDate(), itemDTO.getExpiryDate()));
        }
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
        txtUnitePrice.requestFocus();
    }

    @FXML
    private void txtUnitePriceAC(ActionEvent event) {
        btnAdd.requestFocus();
    }

    @FXML
    private void btnAddAc(ActionEvent event) {
        try {
            String volume_ID = txtVolumeID.getText();
            String volume_Size = txtVolumeSize.getText();
            int volume_qty = Integer.parseInt(txtQty.getText());
            double price = Double.parseDouble(txtUnitePrice.getText());

            VolumeDTO volumeDTO = new VolumeDTO(volume_ID, volume_Size, volume_qty, price);

            boolean addVolume = ItemController.addVolume(volumeDTO);
            if (addVolume) {
                clearAllVolumeField();
                ObservableList<String> getVolumeID = ItemController.getVolumeID();
                cmdVolumeID.setItems(getVolumeID);
                infoBox("Done", null, "Done");

            } else {
                errMessageBox("Not Done", null, "Error");
            }
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearAllVolumeField() {
        txtVolumeID.setText("");
        txtVolumeSize.setText("");
        txtQty.setText("");
        txtUnitePrice.setText("");
        txtVolumeID.requestFocus();
    }

    @FXML
    private void btnVIewItemBatchAC(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Stock.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void btnSearchtemAC(ActionEvent event) {
        if (txtSearchItem.getText().trim().isEmpty()) {
            txtItemID.requestFocus();
        } else if (!(txtSearchItem.getText().trim().isEmpty())) {
            try {
                String Item_ID = txtSearchItem.getText();
                ItemDTO searchItem = ItemController.searchItem(Item_ID);
                clearAllVolumeField();
                txtItemID.setText(searchItem.getItemID());
                cmdBatchID.getSelectionModel().select(searchItem.getItemBatchID());
                cmdVolumeID.getSelectionModel().select(searchItem.getVolumeID());
                detpickerMFDate.setValue(LocalDate.parse(searchItem.getManufactureDate(), DateTimeFormatter.ISO_DATE));
                dtPickerEX.setValue(LocalDate.parse(searchItem.getExpiryDate(), DateTimeFormatter.ISO_DATE));
                txtItemName.setText(searchItem.getItemName());
                txtItemID.requestFocus();
            } catch (Exception ex) {
                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnSearchItemVolumeAC(ActionEvent event) {
        if (txtSearchVolume.getText().trim().isEmpty()) {
            txtVolumeSize.requestFocus();
        } else if (!(txtSearchVolume.getText().trim().isEmpty())) {
            try {
                String Volume_ID = txtSearchVolume.getText();
                VolumeDTO searchVolume = ItemController.searchVolume(Volume_ID);
                clearAllVolumeField();
                txtVolumeID.setText(searchVolume.getVolume_ID());
                txtVolumeSize.setText(searchVolume.getVolume_size());
                txtQty.setText(searchVolume.getVolume_qty() + "");
                txtUnitePrice.setText(searchVolume.getPrice() + "");
                txtVolumeID.requestFocus();
            } catch (Exception ex) {
                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    @FXML
    private void txtSearchVolume(ActionEvent event) {
        btnSearchItemVolume.requestFocus();
    }

    @FXML
    private void txtSearchItemAc(ActionEvent event) {
        btnSearchtem.requestFocus();
    }
}
