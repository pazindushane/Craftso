package controller;

import bo.BOFactory;
import bo.custom.CartBO;
import bo.custom.DeliverBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DeliverFormController implements Initializable {
    private static String oId = null;
    private static String iC = null;
    private static String tot = null;
    private static String cust = null;
    private static String name = null;
    private static String add = null;
    private static String dte = null;
    public Label lblTotal1;
    public Label lblOID1;
    public Label lblOID11;
    public Label lblOID111;
    public Label lblOID1111;
    public JFXTextField txtContact;
    public JFXTextField txtCustName;
    public JFXTextField txtCustAddress;
    public JFXTextField txtDeliverFee;
    public JFXTextField txtAmount;
    public JFXComboBox cmbArea;

    DeliverBO deliverBO = (DeliverBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.DELIVER);


    public static void parseData(String orderId, String itemCount, String total,String customn,String namee,String addd,String dtee) {
        oId = orderId;
        iC = itemCount;
        tot = total;
        cust=customn;
        name =namee;
        add=addd;
        dte=dtee;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblOID1.setText(oId);
        lblOID11.setText(iC);
        lblTotal1.setText(tot);
        txtContact.setText(cust);
        txtCustName.setText(name);
        txtCustAddress.setText(add);
        lblOID111.setText(dte);

        setDID();
        loadcombo();
        //setfee();
    }

    public void total(){
        //double stringSelected;
        double tot =Double.parseDouble(lblTotal1.getText());
        double qty =Double.parseDouble(txtDeliverFee.getText());
        double unitp ;
        unitp =qty + tot  ;
        //tot= tot+(qty*unitp);
        lblTotal1.setText(String.valueOf(unitp));
        //stringSelected = tblCart.getSelectionModel().getSelectedItems().get(0).getUnitPrice();
        //System.out.println(stringSelected);

    }

    public void setDID() {
        String temp = "";
        String DID = "";

        try {
            temp = deliverBO.getLastDID();

            if (temp == null)
                temp = "D000";
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
            DID = "D00" + (changer + 1);

        else if (changer > 8 && changer < 99)
            DID = "D0" + (changer + 1);

        else
            DID = "D" + (changer + 1);


        lblOID11.setText(DID);
    }

    public void cmbAreaOnAction(ActionEvent actionEvent) {
        //total();
        setfee();
        //total();
    }
    private void loadcombo(){
        cmbArea.getItems().add("Colombo");
        cmbArea.getItems().add("Panadura");
        cmbArea.getItems().add("Galle");
        cmbArea.getItems().add("Other");
    }

    private void setfee(){

        if (cmbArea.getSelectionModel().getSelectedIndex() == 0){
            txtDeliverFee.setText(Double.toString(1000.0));


        }else if (cmbArea.getSelectionModel().getSelectedIndex() == 1){
            txtDeliverFee.setText(Double.toString(2000.0));

        }else if (cmbArea.getSelectionModel().getSelectedIndex() == 2){
            txtDeliverFee.setText(Double.toString(3000.0));

        }else if (cmbArea.getSelectionModel().getSelectedIndex() == 3) {
            txtDeliverFee.setText(Double.toString(5000.0));
       
        }else {
            txtDeliverFee.setText("Select");
        }
    }

    public void txtDeliverFeeOnAction(ActionEvent actionEvent) {
//        total();
    }
}
