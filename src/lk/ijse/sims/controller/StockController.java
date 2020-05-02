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
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import lk.ijse.sims.bo.custom.ItemBatchBO;
import lk.ijse.sims.bo.custom.StockBO;
import lk.ijse.sims.dto.Item_BatchDTO;
import lk.ijse.sims.dto.StockDTO;
import lk.ijse.sims.dto.VolumeDTO;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class StockController implements Initializable {

    static StockBO bo = (StockBO) BOFactory.getInstance().getBOType(BOFactory.BOType.STOCK);

    private static ArrayList<StockDTO> allStock() throws SQLException, Exception {
        return bo.getAllStock();
    }

    private static ObservableList<String> getstockID() throws SQLException, Exception {
        return bo.getStockID();
    }

    private static boolean addStock(StockDTO addStockDTO) throws ClassNotFoundException, Exception {
        return bo.addStock(addStockDTO);
    }

    private static boolean updateStock(StockDTO updateStockDTO) throws ClassNotFoundException, Exception {
        return bo.updateStock(updateStockDTO);
    }

    private static boolean deleteStock(String stock_ID) throws SQLException, Exception {
        return bo.deleteStock(stock_ID);
    }

    private static ArrayList<StockDTO> allStovk() throws SQLException, Exception {
        return bo.getAllStock();
    }
//-------------------------------------------------------------------ItemBatch Part---------------------------------------------------------------------------------------------------------
//    static ItemBatchBO ibo =  (ItemBatchBO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.ITEM_BATCH);
    static ItemBatchBO ibo = (ItemBatchBO) BOFactory.getInstance().getBOType(BOFactory.BOType.ITEM_BATCH);

    private static boolean addItemBatch(Item_BatchDTO additemBatch) throws ClassNotFoundException, Exception {
        return ibo.addItemBatch(additemBatch);
    }

    private static boolean updateItemBatch(Item_BatchDTO updateitemBatch) throws ClassNotFoundException, Exception {
        return ibo.updateItemBatch(updateitemBatch);
    }

    private static ArrayList<Item_BatchDTO> getItemBatch() throws SQLException, Exception {
        return ibo.getAllItem();
    }

    private static boolean deleteDelete(String Item_Batch) throws SQLException, Exception {
        return ibo.deleteItemBatch(Item_Batch);
    }

    private static StockDTO searchStockID(String stock_ID) throws SQLException, Exception {
        return bo.searchStock(stock_ID);
    }

    private static Item_BatchDTO searchBatchID(String Batch_ID) throws SQLException, Exception {
        return ibo.searchItemBatch(Batch_ID);
    }

    @FXML
    private JFXTextField txtStockID;
    @FXML
    private JFXTextField txtStockPrice;
    @FXML
    private JFXComboBox<String> cmbStockID;
    @FXML
    private JFXButton btnADD;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXDatePicker dtPickerStockDate;
    @FXML
    private TableView<StockDTO> tblStock;
    @FXML
    private ImageView close;
    @FXML
    private JFXTextField txtItemBatch;
    @FXML
    private JFXTextField txtBatchPrice;
    @FXML
    private JFXDatePicker dtIBatchMF;
    @FXML
    private JFXDatePicker dtBatchEX;
    @FXML
    private TableView<Item_BatchDTO> tblBatchView;
    @FXML
    private JFXButton btnBatchAdd;
    @FXML
    private JFXButton btnBatchUpdate;
    @FXML
    private JFXButton btnBatchDelete;
    @FXML
    private Button btnSearchItemBatch;
    @FXML
    private JFXTextField txtStockSearch;
    @FXML
    private Button btnSearchStocka;
    @FXML
    private JFXTextField txtSearchBatch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tblStock.getColumns().get(0).setStyle("-fx-alignment:center");
            tblStock.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("stock_ID"));
            tblStock.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("stock_Price"));
            tblStock.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("stock_Date"));
            try {
            tblStock.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StockDTO>() {
                @Override
                public void changed(ObservableValue<? extends StockDTO> observable, StockDTO oldValue, StockDTO newValue) {
                    StockDTO selectedStock = tblStock.getSelectionModel().getSelectedItem();
                    try {
                    selectedStock.getStock_ID();
                    selectedStock.getStock_Price();
                    selectedStock.getStock_Date();

                    txtStockID.setText(selectedStock.getStock_ID());
                    txtStockPrice.setText(selectedStock.getStock_Price() + "");
                    dtPickerStockDate.setValue(LocalDate.parse(selectedStock.getStock_Date()));
                    } catch (Exception e) {
                    }
                }
            });
             } catch (Exception e) {
            }
            loadAllStock();
//-------------------------------------------------------------------ItemBatch Part------------------------------------------------------------------------------------------------------
            tblBatchView.getColumns().get(0).setStyle("-fx-alignment:center");
            tblBatchView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
            tblBatchView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("batchID"));
            tblBatchView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("mfDate"));
            tblBatchView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Price"));
            tblBatchView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("exDate"));
            loadAllItemBatches();

            tblBatchView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item_BatchDTO>() {
                @Override
                public void changed(ObservableValue<? extends Item_BatchDTO> observable, Item_BatchDTO oldValue, Item_BatchDTO newValue) {
                    try {

                        Item_BatchDTO selectedItemBatch = tblBatchView.getSelectionModel().getSelectedItem();
                        selectedItemBatch.getSid();
                        selectedItemBatch.getBatchID();
                        selectedItemBatch.getMfDate();
                        selectedItemBatch.getExDate();
                        selectedItemBatch.getPrice();

                        cmbStockID.getSelectionModel().select(selectedItemBatch.getSid());
                        txtItemBatch.setText(selectedItemBatch.getBatchID());
                        dtIBatchMF.setValue(LocalDate.parse(selectedItemBatch.getMfDate()));
                        dtBatchEX.setValue(LocalDate.parse(selectedItemBatch.getExDate()));
                        txtBatchPrice.setText(selectedItemBatch.getPrice() + "");
                    } catch (Exception e) {
                    }
                }
            });
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        } catch (Exception ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void txtStockPriceAC(ActionEvent event) {
        if (txtStockPrice.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Stock Price");
            a.show();
            txtStockPrice.requestFocus();
        } else {
            dtPickerStockDate.requestFocus();
        }
    }

    @FXML
    private void cmbStockID(ActionEvent event) {
    }

    private void loadAllStock() throws Exception, Exception {
        ArrayList<StockDTO> list = StockController.allStock();
        tblStock.setItems(FXCollections.observableArrayList(list));
        ObservableList<String> getStockID = StockController.getstockID();
        cmbStockID.setItems(getStockID);
    }

    private void clearAll() {
        txtStockID.setText("");
        txtStockPrice.setText("");
        dtPickerStockDate.setValue(null);
    }
//
//    @FXML
//    private void dtPickerStockDate(ActionEvent event) {
//        if (dtPickerStockDate.getValue().format(DateTimeFormatter.ISO_DATE).isEmpty()) {
//            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Stock Date");
//            a.show();
//        } else {
//            btnADD.requestFocus();
//        }
//    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void txtStockIDKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case DOWN:
                txtStockPrice.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void txtStockIDAC(ActionEvent event) {
        if (Pattern.compile("[st]{2}[0]{1}[0-9]{1,}").matcher(txtStockID.getText()).matches()) {
            txtStockPrice.requestFocus();
        } else {
            txtStockID.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Stock ID number format is Invalid...\nYou need to use \"st0\" and 0-9 any numbers \"st01\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void btnADDAc(ActionEvent event) {
        try {
            if (dtPickerStockDate.getValue().toString().isEmpty()
                    || txtStockID.getText().trim().isEmpty()
                    || txtStockPrice.getText().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Some Data");
                a.show();
            } else {
                String stock_ID = txtStockID.getText();
                double stock_Price = Double.parseDouble(txtStockPrice.getText());
                String Stock_Date = dtPickerStockDate.getValue().format(DateTimeFormatter.ISO_DATE);

                StockDTO addStockDTO = new StockDTO(stock_ID, Stock_Date, stock_Price);

                boolean addStock = StockController.addStock(addStockDTO);
                if (addStock) {
                    infoBox("Done", null, "Done");
                    clearAll();
                    loadAllStock();
                    ObservableList<String> getStockID = StockController.getstockID();
                    cmbStockID.setItems(getStockID);
                } else {
                    errMessageBox("Not Done", null, "Error");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "You can not add stock without any Data", "Exeption", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            Logger.getLogger(StockController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnUpdateAc(ActionEvent event) {
        if (dtPickerStockDate.getValue().toString().isEmpty()
                || txtStockID.getText().trim().isEmpty()
                || txtStockPrice.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Some Data");
            a.show();
        } else {
            try {
                String stock_ID = txtStockID.getText();
                double stock_Price = Double.parseDouble(txtStockPrice.getText());
                String Stock_Date = dtPickerStockDate.getValue().format(DateTimeFormatter.ISO_DATE);

                StockDTO updateStockDTO = new StockDTO(stock_ID, Stock_Date, stock_Price);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Are you sure to Update ?");
                alert.setHeaderText(null);
                alert.setTitle("Confirmation dialog");
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    boolean addStock = StockController.updateStock(updateStockDTO);
                    if (addStock) {
                        infoBox("Stock Updated...!", null, "Done");
                        clearAll();
                        loadAllStock();
                        ObservableList<String> getStockID = StockController.getstockID();
                        cmbStockID.setItems(getStockID);
                    } else {
                        errMessageBox("Stock Not Updated...!", null, "Error");
                    }
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "You can not Update stock without any Data", "Exeption", JOptionPane.ERROR_MESSAGE);

            } catch (Exception ex) {
                Logger.getLogger(StockController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnDeleteAc(ActionEvent event) {
        String stock_ID = txtStockID.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure to Delete ?");
        alert.setHeaderText(null);
        alert.setTitle("Confirmation dialog");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            try {
                boolean deleteStock = StockController.deleteStock(stock_ID);
                if (deleteStock) {
                    infoBox("Stock Deleted...!", null, "Deleted");
                    clearAll();
                    loadAllStock();
                } else {
                    errMessageBox("Stock Not Deleted...!", null, "Warning");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "You can not Delete stock without Stock ID", "Exeption", JOptionPane.ERROR_MESSAGE);

            } catch (Exception ex) {
                Logger.getLogger(StockController.class
                        .getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    private void stPriceKey(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                txtStockID.requestFocus();
                break;
            case DOWN:
                dtPickerStockDate.requestFocus();
                break;
            default:
                break;
        }
    }
    //-------------------------------------------------------------------ItemBatch Part------------------------------------------------------------------------------------------------------

    @FXML
    private void txtItemBatchAc(ActionEvent event) {
        if (Pattern.compile("[iB]{2}[0]{1}[0-9]{1,}").matcher(txtItemBatch.getText()).matches()) {
            txtBatchPrice.requestFocus();
        } else {
            txtItemBatch.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Batch ID number format is Invalid...\nYou need to use \"iB0\" and 0-9 any numbers \"iB01\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void txtBatchPriceAC(ActionEvent event) {

    }

    @FXML
    private void dtIBatchMFAc(ActionEvent event) {
    }

    @FXML
    private void dtBatchEXAc(ActionEvent event) {
    }

    @FXML
    private void btnBatchAddAc(ActionEvent event) {
        if (cmbStockID.getSelectionModel().getSelectedItem().isEmpty()
                || txtItemBatch.getText().trim().isEmpty() || txtBatchPrice.getText().isEmpty()
                || dtIBatchMF.getValue().toString().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Some Data");
            a.show();
        } else {
            try {
                String stockID = cmbStockID.getSelectionModel().getSelectedItem();
                String itemBatchID = txtItemBatch.getText();
                double Item_Batch_Price = Double.parseDouble(txtBatchPrice.getText());
                String ManufactureDate = dtIBatchMF.getValue().format(DateTimeFormatter.ISO_DATE);
                String ExpiryDate = dtBatchEX.getValue().format(DateTimeFormatter.ISO_DATE);

                Item_BatchDTO additemBatch = new Item_BatchDTO(stockID, itemBatchID, ManufactureDate, ExpiryDate, Item_Batch_Price);
                boolean addItemBAtch = StockController.addItemBatch(additemBatch);
                if (addItemBAtch) {

                    infoBox("Done", null, "Done");
                    clearItemBatchField();
                    loadAllItemBatches();

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "You can not add Batch without any Data", "Exeption", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnBatchUpdateAc(ActionEvent event) {
        if (cmbStockID.getSelectionModel().getSelectedItem().isEmpty()
                || txtItemBatch.getText().trim().isEmpty() || txtBatchPrice.getText().isEmpty()
                || dtIBatchMF.getValue().toString().isEmpty() || dtBatchEX.getValue().toString().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Some Data");
            a.show();
        } else {
            try {
                String stockID = cmbStockID.getSelectionModel().getSelectedItem().toString();
                String itemBatchID = txtItemBatch.getText();
                double Item_Batch_Price = Double.parseDouble(txtBatchPrice.getText());
                String ManufactureDate = dtIBatchMF.getValue().format(DateTimeFormatter.ISO_DATE);
                String ExpiryDate = dtBatchEX.getValue().format(DateTimeFormatter.ISO_DATE);

                Item_BatchDTO updateitemBatch = new Item_BatchDTO(stockID, itemBatchID, ManufactureDate, ExpiryDate, Item_Batch_Price);
                boolean addItemBAtch = StockController.updateItemBatch(updateitemBatch);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Are you sure to Update ?");
                alert.setHeaderText(null);
                alert.setTitle("Confirmation dialog");
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    if (addItemBAtch) {
                        infoBox("Stock Updated...!", null, "Done");
                        clearItemBatchField();
                        loadAllItemBatches();
                    } else {
                        errMessageBox("Stock Not Updated...!", null, "Error");
                    }
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "You can not Update Batch without any Data", "Exeption", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnBatchDeleteAc(ActionEvent event) {
        String Item_Batch = txtItemBatch.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure to Delete ?");
        alert.setHeaderText(null);
        alert.setTitle("Confirmation dialog");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            try {
                boolean deleteItemBatch = StockController.deleteDelete(Item_Batch);
                if (deleteItemBatch) {
                    try {
                        infoBox("Item Batch Deleted...!", null, "updated");
                        clearItemBatchField();
                        loadAllItemBatches();
                    } catch (Exception ex) {
                        Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    errMessageBox("Item Batch Not Deleted...!", null, "Warning");
                }
            } catch (Exception ex) {
                Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void clearItemBatchField() {
        txtItemBatch.setText("");
        txtBatchPrice.setText("");
        dtIBatchMF.setValue(null);
        dtBatchEX.setValue(null);
    }

    private void loadAllItemBatches() throws Exception {
        ArrayList<Item_BatchDTO> list = StockController.getItemBatch();
        tblBatchView.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    private void btnSearchItemBatchAC(ActionEvent event) {
         if (txtSearchBatch.getText().trim().isEmpty()) {
            cmbStockID.requestFocus();
        } else if (!(txtSearchBatch.getText().trim().isEmpty())) {
            try {
                String Batch_ID = txtSearchBatch.getText();
                Item_BatchDTO searchBatch = StockController.searchBatchID(Batch_ID);
                clearAll();
                cmbStockID.getSelectionModel().select(searchBatch.getSid());
                txtItemBatch.setText(searchBatch.getBatchID() + "");
                dtIBatchMF.setValue(LocalDate.parse(searchBatch.getMfDate(), DateTimeFormatter.ISO_DATE));
                dtBatchEX.setValue(LocalDate.parse(searchBatch.getExDate(), DateTimeFormatter.ISO_DATE));
                txtBatchPrice.setText(searchBatch.getPrice()+"");
                cmbStockID.requestFocus();
            } catch (Exception ex) {
                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    @FXML
    private void txtStockSearchAc(ActionEvent event) {
        btnSearchStocka.requestFocus();
    }

    @FXML
    private void btnSearchStockaAc(ActionEvent event) {
        if (txtStockSearch.getText().trim().isEmpty()) {
            txtStockID.requestFocus();
        } else if (!(txtStockSearch.getText().trim().isEmpty())) {
            try {
                String stock_ID = txtStockSearch.getText();
                StockDTO searchStock = StockController.searchStockID(stock_ID);
                clearAll();
                txtStockID.setText(searchStock.getStock_ID());
                txtStockPrice.setText(searchStock.getStock_Price() + "");
                dtPickerStockDate.setValue(LocalDate.parse(searchStock.getStock_Date(), DateTimeFormatter.ISO_DATE));

                txtStockPrice.requestFocus();
            } catch (Exception ex) {
                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }

    @FXML
    private void txtSearchBatchAc(ActionEvent event) {
        btnSearchItemBatch.requestFocus();
    }

}
