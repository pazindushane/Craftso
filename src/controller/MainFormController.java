package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField password;
    public JFXButton btnCashier;
    public JFXButton btnAdmin;

    public void btnCashierOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().length()>0 && password.getText().length()>0) {
            if (txtUserName.getText().equals("pasindu") && password.getText().equals("1234")) {
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CashierForm.fxml"))));
                stage.show();

                Stage mainStage = new Stage();
                mainStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForm.fxml"))));
                mainStage.close();
            } else  {
                new Alert(Alert.AlertType.WARNING, "Please Check UserName or Password ", ButtonType.OK).show();

            }

        }else {
            new Alert(Alert.AlertType.WARNING, "Fields cannot be empty ", ButtonType.OK).show();
        }
    }

    public void btnAdminOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().length()>0 && password.getText().length()>0) {
            if (txtUserName.getText().equals("dilmin") && password.getText().equals("7399")) {
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/AdminDashBoard.fxml"))));
                stage.show();
            } else  {
                new Alert(Alert.AlertType.WARNING, "Please Check UserName or Password ", ButtonType.OK).show();

            }

        }else {
            new Alert(Alert.AlertType.WARNING, "Fields cannot be empty ", ButtonType.OK).show();
        }
    }
}
