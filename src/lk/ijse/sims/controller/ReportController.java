/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.sims.db.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class ReportController implements Initializable {

    @FXML
    private ImageView close;
    @FXML
    private JFXButton btnCustReport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnCustReportAC(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {

//            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/sims/report/Customer_A4.jasper");
//            Connection connection = DBConnection.getInstance().getConnection();
//            JasperPrint print = JasperFillManager.fillReport(is, null, connection);
//            JasperViewer.viewReport(print, false);
        InputStream is = this.getClass().getResourceAsStream("/lk/ijse/sims/reports/Customer_A4.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
    }

}
