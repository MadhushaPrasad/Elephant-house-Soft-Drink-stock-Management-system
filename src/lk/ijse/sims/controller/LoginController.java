/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.sims.bo.BOFactory;
import lk.ijse.sims.bo.custom.LoginBO;
import lk.ijse.sims.dto.LoginDTO;

/**
 *
 * @author acer
 */
public class LoginController implements Initializable {

    static LoginBO bo = (LoginBO) BOFactory.getInstance().getBOType(BOFactory.BOType.LOGIN);

    private static boolean checkUser(LoginDTO check) throws NullPointerException, ClassNotFoundException, Exception {
        return bo.checkUser(check);
    }

    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane mainAncorPane;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private Hyperlink hyplForgotPassword;
    @FXML
    private Hyperlink hyplSignup;
    @FXML
    private ImageView close;
    private Label lblEmail;
    private Label lblPassword;
    @FXML
    private Label lblEmailError;
    @FXML
    private Label lblPasswordError;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        try {
            if (txtEmail.getText().trim().isEmpty() && txtPassword.getText().trim().isEmpty()) {
                lblEmailError.setText("Email is Empty");
                lblPasswordError.setText("Password is Empty");
            } else if (txtEmail.getText().trim().isEmpty()) {
                lblEmailError.setText("Email is Empty");
            } else if (txtPassword.getText().trim().isEmpty()) {
                lblPasswordError.setText("Password is Empty");
            }

            String userEmail = txtEmail.getText();
            String userPassword = txtPassword.getText();
            LoginDTO check = new LoginDTO(userEmail, userPassword);
            boolean checkUser;

            checkUser = LoginController.checkUser(check);
            if (checkUser) {
                Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sims/view/Home.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = (Stage) this.mainAncorPane.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setResizable(false);
            } else {
                infoBox("Please enter correct Email and Password", null, "Failed");
                clearAll();
                txtEmail.requestFocus();
            }
        } catch (NullPointerException nl) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, nl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void forgotPassword(ActionEvent event) {
        showDialog();
    }

    public void showDialog() {
        Text title = new Text("Help With Forgotten Credentials");
        title.setFont(Font.font("arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 13));
        String content = "It looks like you forgot your email or password,\nthen you don't want to "
                + "worry. Simply please get in \ntouch with or knock on my office door and it will be \nhappy to help.\n\n"
                + "Thanks\nA.D. MADHUSHA PRASAD, Your Manager";
        JFXDialogLayout dialogContent = new JFXDialogLayout();
        dialogContent.setHeading(title);
        dialogContent.setPrefWidth(280);
        dialogContent.setBody(new Text(content));
        JFXButton close = new JFXButton("Close");
        close.setButtonType(JFXButton.ButtonType.RAISED);
        close.setStyle("-fx-background-color: #FF9A00; -fx-text-fill: white");
        dialogContent.setActions(close);
        JFXDialog dialog = new JFXDialog(stackPane, dialogContent, JFXDialog.DialogTransition.TOP);
        dialog.setOverlayClose(false);
        close.setOnAction(event -> {
            dialog.close();
        });
        dialog.show();
        dialog.setOnDialogOpened(event -> mainAncorPane.setEffect(new GaussianBlur(5d)));
        dialog.setOnDialogClosed(event -> mainAncorPane.setEffect(new GaussianBlur(0d)));

    }

    @FXML
    private void signUp(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/sims/view/UserRegistration.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.mainAncorPane.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

        FadeTransition trans = new FadeTransition(Duration.millis(2000), parent);
        trans.setFromValue(0);
        trans.setToValue(1.0);
        trans.play();
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void emailMouseClick(MouseEvent event) {
        lblEmailError.setText("");
    }

    @FXML
    private void passwordMouseClick(MouseEvent event) {
        if (txtEmail.getText().trim().isEmpty()) {
            lblEmailError.setText("Email is Empty");
            lblPasswordError.setText("");
        } else {
            lblEmailError.setText("");
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();

    }

    @FXML
    private void txtEmailAction(ActionEvent event) {
//        txtPassword.requestFocus();
        if (Pattern.compile("[a-z0-9.]{1,}[@]{1}[a-z]{1,}[.]{1}(com)$").matcher(txtEmail.getText()).matches()) {

            txtPassword.requestFocus();
            lblPasswordError.setText("");

        } else {
            txtEmail.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Email Address format is Invalid", ButtonType.OK);
            a.show();
            txtEmail.requestFocus();
            lblPasswordError.setText("");
        }
    }

    @FXML
    private void txtPasswordAction(ActionEvent event) {
        btnLogin.requestFocus();
    }

    private void clearAll() {
        txtEmail.setText("");
        txtPassword.setText("");
    }
}
