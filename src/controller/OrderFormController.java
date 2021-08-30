package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    public Label lblOID1;
    public Label lblDAte1;
    public Label lblTotal1;
    public Label lblOID11;
    CustomerBO custBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    public AnchorPane rootH;
    public JFXButton btnDelivery;
    public JFXButton btnEdit;
    public Label lblOID;
    public Label lblDate;
    public JFXTextField txtContact;
    public JFXTextField txtCustName;
    public JFXTextField txtCustAddress;
    public Label lblCart;
    public Label lblTotal;
    public TableView tblOrder;
    public TableColumn clmOID;
    public TableColumn clmODate;
    public TableColumn clmOItem;
    public JFXRadioButton rbCash;
    public JFXRadioButton rbCard;
    public JFXTextField txtCash;
    public JFXButton btnPay;
    public JFXTextField txtExchange;
    public JFXButton btnTKAWy;
    public JFXButton btnEditORD;

    private static String oId = null;
    private static String iC = null;
    private static String tot = null;
    private static String cust = null;


    private void setUi(String m) throws IOException {
        rootH.getChildren().clear();
        rootH.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + m + ".fxml")));
    }

    public void btnDeliveryOnAction(MouseEvent mouseEvent) throws IOException {


        nextUi ();
    }

    public void btnEditOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("CartForm");
    }

    public void txtContactOnAction(ActionEvent actionEvent) {
        try {
            CustomerDTO customer = custBO.search(txtContact.getText());

            if (customer != null) {

                txtCustName.setText(customer.getCustName());
                txtCustAddress.setText(customer.getAddress());

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnTKAWyOnAction(ActionEvent actionEvent) {
    }

    public void btnEditORDOnAction(ActionEvent actionEvent) {
    }

    public static void parseData(String orderId, String itemCount, String total,String customn) {
        oId = orderId;
        iC = itemCount;
        tot = total;
        cust=customn;


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(oId+" "+iC+" "+tot+""+cust);

        lblOID1.setText(oId);
        lblOID11.setText(iC);
        lblTotal1.setText(tot);
        txtContact.setText(cust);
        setDate();
    }

    public  void cash(){
        double tot =Double.parseDouble(lblTotal1.getText());
        double csh =Double.parseDouble(txtCash.getText());
        double exch;
        exch= csh-tot;
        txtExchange.setText(String.valueOf(exch));
    }

    public void btnPayOnAction(ActionEvent actionEvent) {
        cash();
    }
    public void setDate() {

        Date date = Date.valueOf(LocalDate.now());
        lblDAte1.setText(String.valueOf(date));
    }
    public void nextUi () throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/DeliverForm.fxml"));
        Parent root = loader.load();
        DeliverFormController oc = loader.getController();
        oc.parseData(lblOID1.getText(),lblOID11.getText(), lblTotal1.getText(), txtContact.getText(),txtCustName.getText(),txtCustAddress.getText(),lblDAte1.getText());
        setUi("DeliverForm");
    }
}
