package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.regex.Pattern;

public class MainNFormController {
    public JFXButton btnLogin;
    public JFXTextField txtUserName;
    public JFXPasswordField password;
    public AnchorPane rootH;



    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().length()>0 && password.getText().length()>0) {
            if (txtUserName.getText().equals("cashier") && password.getText().equals("1234")) {
                if (Pattern.compile("^(cashier)$").matcher(txtUserName.getText()).matches()){
                    if (Pattern.compile("^(1234)$").matcher(password.getText()).matches()){
                        Stage stage = new Stage();
                        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CashierDashBoard.fxml"))));
                        stage.show();

                        Stage primaryStage= (Stage) btnLogin.getScene().getWindow();
                        primaryStage.close();


                    }else {
                        password.setFocusColor(Paint.valueOf("red"));
                        password.requestFocus();
                    }
                }else {
                    txtUserName.setFocusColor(Paint.valueOf("red"));
                    txtUserName.requestFocus();
                }




                /*Stage mainStage = new Stage();
                mainStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForm.fxml"))));
                mainStage.close();*/
            } else if (txtUserName.getText().equals("admin") && password.getText().equals("1234")){
                if (Pattern.compile("^(admin)$").matcher(txtUserName.getText()).matches()){
                    if (Pattern.compile("^(1234)$").matcher(password.getText()).matches()){
                        Stage stage = new Stage();
                        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/AdminDashBoard.fxml"))));
                        stage.show();

                        Stage primaryStage= (Stage) btnLogin.getScene().getWindow();
                        primaryStage.close();

                    }else {
                        password.setFocusColor(Paint.valueOf("red"));
                        password.requestFocus();
                    }
                }else {
                    txtUserName.setFocusColor(Paint.valueOf("red"));
                    txtUserName.requestFocus();
                }

              //  new Alert(Alert.AlertType.WARNING, "", ButtonType.OK).show();

            }else {

                new Alert(Alert.AlertType.WARNING, "Please Check UserName or Password ", ButtonType.OK).show();

            }

        }else {

            new Alert(Alert.AlertType.WARNING, "Please Check UserName or Password ", ButtonType.OK).show();
        }

//        if(txtUserName.getText().length()>0 && password.getText().length()>0) {
//            if (txtUserName.getText().equals("admin") && password.getText().equals("1234")) {
//                Stage stage = new Stage();
//                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/AdminDashBoard.fxml"))));
//                stage.show();
//
//                Stage primaryStage= (Stage) btnLogin.getScene().getWindow();
//                primaryStage.close();
//
//            } else  {
//
//            }
//
//        }else {
//            new Alert(Alert.AlertType.WARNING, "Please Check UserName or Password ", ButtonType.OK).show();
//        }
//
   }

    public void userNameOnAction(ActionEvent actionEvent) {
        //validtionc();
        password.requestFocus();
    }

    public void validtionc(){
        if (Pattern.compile("^(cashier)$").matcher(txtUserName.getText()).matches()){
            password.requestFocus();
        }else {
            txtUserName.setFocusColor(Paint.valueOf("red"));
            txtUserName.requestFocus();
        }
    }
    public void validtap(){
        if (Pattern.compile("^(1234)$").matcher(txtUserName.getText()).matches()){
            password.requestFocus();
        }else {
            txtUserName.setFocusColor(Paint.valueOf("red"));
            txtUserName.requestFocus();
        }
    }

    public void passwordOnAction(ActionEvent actionEvent) {
            btnLogin.requestFocus();
    }
}
