/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.sims.bo.BOFactory;
import lk.ijse.sims.bo.custom.UserBO;
import lk.ijse.sims.dto.UserDTO;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class UserRegistrationController implements Initializable {

    static UserBO bo = (UserBO) BOFactory.getInstance().getBOType(BOFactory.BOType.USER);

    private static boolean registrationUser(UserDTO userRegistration) throws ClassNotFoundException, SQLException, Exception {
        return bo.userRegister(userRegistration);
    }

    @FXML
    private AnchorPane registrationPane;
    @FXML
    private ImageView close;
    @FXML
    private ImageView backWindow;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private JFXButton btnCancle;
    @FXML
    private Label lblconfirmPassword;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXPasswordField txtConfirmPassword;

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
    private void backMouseClick(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/sims/view/Login.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.registrationPane.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();

        FadeTransition trans = new FadeTransition(Duration.millis(2000), parent);
        trans.setFromValue(0);
        trans.setToValue(1.0);
        trans.play();
    }

    @FXML
    private void txtUserNameKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER:
                txtEmail.requestFocus();
                break;
            case DOWN:
                txtEmail.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void txtEmailKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER:
                txtPassword.requestFocus();
                break;
            case DOWN:
                txtPassword.requestFocus();
                break;
            case UP:
                txtUserName.requestFocus();
            default:
                break;
        }
    }

    @FXML
    private void txtPasswordKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER:
                txtConfirmPassword.requestFocus();
                break;
            case DOWN:
                txtConfirmPassword.requestFocus();
                break;
            case UP:
                txtEmail.requestFocus();
            default:
                break;
        }
    }

    @FXML
    private void txtConfirmPasswordKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER:
                btnRegister.requestFocus();
                break;
            case DOWN:
                btnRegister.requestFocus();
                break;
            case UP:
                txtPassword.requestFocus();
            default:
                break;
        }
    }

    @FXML
    private void btnUserRegisterKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
//            case ENTER:
//                btnRegister.setVisible(true);
//                break;
            case LEFT:
                btnCancle.requestFocus();
            default:
                break;
        }
    }

    @FXML
    private void btnUserRegister(ActionEvent event) throws SQLException, Exception {
        String userName = txtUserName.getText();
        String userEmail = txtEmail.getText();
        String userPassword = txtPassword.getText();
        UserDTO userRegistration = new UserDTO(userName, userEmail, userPassword);
        boolean registration = UserRegistrationController.registrationUser(userRegistration);
        if (registration) {
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage = (Stage) this.registrationPane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/sims/view/Login.fxml"));
            stage.close();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
            stage.setResizable(false);

            FadeTransition trans = new FadeTransition(Duration.millis(2000), root);
            trans.setFromValue(0);
            trans.setToValue(1.0);
            trans.play();

            Alert a = new Alert(Alert.AlertType.ERROR, "Please Login to your Account for Manage this System", ButtonType.OK);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "You Are Not Register.,Please try again", ButtonType.OK);
        }
    }

    @FXML
    private void btnCancleReKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
//            case ENTER:
//                btnCancle.setVisible(true);
//                break;
            case RIGHT:
                btnRegister.requestFocus();
                break;
            case UP:
                txtConfirmPassword.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void btnCancleRe(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/sims/view/Login.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.registrationPane.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();

        FadeTransition trans = new FadeTransition(Duration.millis(2000), parent);
        trans.setFromValue(0);
        trans.setToValue(1.0);
        trans.play();
    }

    @FXML
    private void txtUserNameAC(ActionEvent event) {
        if (Pattern.compile("^[A-Z]{1}[a-z]+\\s[A-Z]{1}[a-z]+$").matcher(txtUserName.getText()).matches()) {
            btnRegister.setDisable(true);
            txtEmail.requestFocus();

        } else {
            txtUserName.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input User Name format is Invalid...\nYou need to use format Like this \"Madhusha Prasad\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void txtEmailAC(ActionEvent event) {
        if (Pattern.compile("^[a-z0-9.]{1,}[@]{1}[a-z]{1,}[.]{1}(com)$").matcher(txtEmail.getText()).matches()) {
            txtPassword.requestFocus();

        } else {
            txtEmail.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Email Address format is Invalid...\nYou need to use format Like this \"madushaprasad21@gmail.com\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void txtPasswordAC(ActionEvent event) {
        if (Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,10}$").matcher(txtPassword.getText()).matches()) {
            txtConfirmPassword.requestFocus();
        } else {
            txtPassword.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Password format is Invalid...\nYou need to use format Like this \"Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void txtConfirmPasswordAC(ActionEvent event) {
        btnRegister.setDisable(false);
        if (Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,10}$").matcher(txtPassword.getText()).matches()) {
            if (!(txtPassword.getText() == txtConfirmPassword.getText())) {
                btnRegister.requestFocus();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Input Confirm Password is Incorrect.. Please ReInput Correct Password");
                a.show();
            }
        } else {
            txtPassword.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Password format is Invalid...\nYou need to use format Like this \"Minimum six characters, at least one uppercase letter, one lowercase letter and one number:\"", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void txtEmailMouseClick(MouseEvent event) {
        if (txtUserName.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your User Name");
            a.show();
        }
    }

    @FXML
    private void txtPasswordMouseClick(MouseEvent event) {
        if (txtEmail.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Email");
            a.show();
        }
    }

    @FXML
    private void txtConfirmPasswordMouseClick(MouseEvent event) {
        if (txtPassword.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "You can't continue this task because you didn't enter your Password");
            a.show();
        } else {

        }
    }

}
