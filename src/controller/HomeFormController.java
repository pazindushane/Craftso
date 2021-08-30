package controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeFormController {
    public JFXButton btnMakeOrd;
    public JFXButton btnCustReg;
    public AnchorPane rootH;

    private void setUi(String m) throws IOException {
        rootH.getChildren().clear();;
        rootH.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+ m + ".fxml")));


    }
    public void btnCustRegOnAction(MouseEvent actionEvent) throws IOException {
        setUi("AddCustomer");

    }

    public void btnMakeOrdOnAction(MouseEvent actionEvent) throws IOException {
        setUi("CartForm");

    }


}
