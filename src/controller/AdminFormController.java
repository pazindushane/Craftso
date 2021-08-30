package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminFormController {
    public AnchorPane root;

    public void initialize() throws IOException {
        defalt();
        //setUi("MainForm");
    }

    private void setUi(String m) throws IOException {
        root.getChildren().clear();;
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+ m + ".fxml")));


    }
    public  void defalt() throws IOException {
        setUi("SupplyForm");
    }

    public void btnSupplyOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("SupplyForm");
    }

    public void btnEmployeeOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("EmployeeForm");
    }

    public void btnCustomerOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("CustomerForm");
    }

    public void btnProductOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ProductForm");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
