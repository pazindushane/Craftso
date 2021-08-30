package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CashierDashBoardController {
    public AnchorPane root;
    public JFXButton btnHome;
    public JFXButton btnAddPrdct;
    public JFXButton btnLogout;
    public AnchorPane root1;
    public JFXButton btnManageOrd;
    public JFXButton btnReport;


    public void initialize() throws IOException {
        defalt();
        //setUi("MainForm");
    }

    private void setUi(String m) throws IOException {
        root.getChildren().clear();;
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+ m + ".fxml")));


    }
    public  void defalt() throws IOException {
        setUi("HomeForm");
    }


    public void btnAddPrdctOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("AddProduct");
    }

    public void btnHomeOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("HomeForm");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainNForm.fxml"))));
        stage.show();

        Stage primaryStage= (Stage) btnLogout.getScene().getWindow();
        primaryStage.close();

    }

    public void btnManageOrdOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ViewOrder");
    }

    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Reports");
    }
}
