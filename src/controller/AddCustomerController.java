package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable {

    public Label lblDAte;
    public Label lblDAte1;
    CustomerBO custBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    public JFXButton btnMakeOrd;
    public AnchorPane rootH;
    public JFXTextField txtCustID;
    public JFXButton btnAdCust;
    public JFXButton btnRemove;
    public JFXButton btnUpdate;
    public JFXButton btnView;
    public JFXTextField txtContact;
    public JFXTextField txtCustName;
    public JFXTextField txtCustAddress;
    public JFXTextField txtMail;


    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private TableColumn<CustomerDTO, String> clmContact;

    @FXML
    private TableColumn<CustomerDTO, String> clmID;

    @FXML
    private TableColumn<CustomerDTO, String> clmName;

    @FXML
    private TableColumn<CustomerDTO, String> clmAddress;

    @FXML
    private TableColumn<CustomerDTO, String> clmMail;





    private void setUi(String m) throws IOException {
        rootH.getChildren().clear();

        rootH.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + m + ".fxml")));


    }

    public void btnMakeOrdOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("CartForm");
    }

    public void btnAdCustOnAction(ActionEvent actionEvent) {
        CustomerDTO customer = new CustomerDTO(txtContact.getText(),txtCustID.getText(),
                txtCustName.getText(),txtCustAddress.getText(),txtMail.getText());

        try {
            boolean isAdded = custBO.add(customer);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Added Successfully",ButtonType.OK).show();
                resetTextField();
            }else {
                new Alert(Alert.AlertType.WARNING,"Customer not added",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnViewOnAction(ActionEvent actionEvent) {
        try {
            ObservableList<CustomerDTO> list = custBO.getAll();
            tblCustomer.getItems().clear();
            tblCustomer.setItems(list);

            clmContact.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("CustContact"));
            clmID.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("CustID"));
            clmName.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("CustName"));
            clmAddress.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("Address"));
            clmMail.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("Email"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setCustID();
        setDate();
    }

    public void resetTextField(){
        txtContact.setText(null);
        txtCustID.setText(null);
        txtCustName.setText(null);
        txtCustAddress.setText(null);
        txtMail.setText(null);
    }
    public void setCustID(){
        String temp = "";
        String CustID = "";

        try {
            temp = custBO.getLastCustID();

            if (temp == null)
                temp = "C000";
        } catch (Exception e) {
            e.printStackTrace();
        }

        char[] numArray = new char[temp.length()];

        String data = "";

        for (int i = 0; i < numArray.length; i++)
            numArray[i] = temp.charAt(i);

        for (int i = 1; i < numArray.length; i++)
            data += numArray[i];

        int changer = Integer.parseInt(data);

        if (changer < 9)
            CustID = "C00" + (changer + 1);

        else if (changer > 8 && changer < 99)
            CustID = "C0" + (changer + 1);

        else
            CustID = "C" + (changer + 1);


        txtCustID.setText(CustID);
    }


    public void txtContactOnAction(ActionEvent actionEvent) {

        try {
            CustomerDTO customer = custBO.search(txtContact.getText());

            if (customer!=null){
                txtCustID.setText(customer.getCustID());
                txtCustName.setText(customer.getCustName());
                txtCustAddress.setText(customer.getAddress());
                txtMail.setText(customer.getEmail());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void setDate() {

        Date date = Date.valueOf(LocalDate.now());
        lblDAte1.setText(String.valueOf(date));
    }

}

