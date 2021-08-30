package controller;

import bo.BOFactory;
import bo.custom.*;
import bo.custom.impl.ProductBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CartFormController implements Initializable {
    public JFXButton btnMorder;
    public AnchorPane rootH;
    public JFXComboBox cmbPcategory;
    public JFXComboBox cmbPname;
    public JFXTextField txtPdsecrip;
    public JFXTextField txtPunitp;
    public JFXButton btnAdCrt;
    public JFXButton btnRemove;
    public Label lblTotal;
    public JFXTextField txtQTYH;
    public Label lblTotal1;
    public Label lblOID1;
    public Label lblCart1;
    public Label lblCart2;
    public JFXTextField txtContact;
    public Label txtPID;
    public JFXTextField lblQTY1;
    //public TableColumn clmPID;
    //public TableColumn clmQtyOnhand;
    //public TableColumn clmOrderID;
    //public TableColumn clmCustCont;
    //public TableColumn clmOID1;

    @FXML
    private TableView<CustomDTO> tblCart;

    @FXML
    private TableColumn<CustomDTO, String> clmCategory;

    @FXML
    private TableColumn<CustomDTO, String> clmName;

    @FXML
    private TableColumn<CustomDTO, String> clmPID;

    @FXML
    private TableColumn<CustomDTO, String> clmDesc;

    @FXML
    private TableColumn<CustomDTO, Double> clmUprice;

    @FXML
    private TableColumn<CustomDTO, String> clmQTY;



    @FXML
    private TableColumn<CustomDTO, Integer> clmQtyOnhand;

    @FXML
    private TableColumn<CustomDTO, Integer> clmOrderID;

    @FXML
    private TableColumn<CustomDTO, Integer> clmCustCont;



    CartBO cartBO = (CartBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CART);
    OrderBO orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    ProductBO productBO = (ProductBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PRODUCT);
    CategeryBO categeryBO = (CategeryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CATEGERY);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setOID();
        loadcate();
        clmCategory.setCellValueFactory(new PropertyValueFactory<>("CatID"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        clmPID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        clmDesc.setCellValueFactory(new PropertyValueFactory<>("Material"));
        clmUprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        clmQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        clmQtyOnhand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        clmOrderID.setCellValueFactory(new  PropertyValueFactory<>("OrderID"));
        clmCustCont.setCellValueFactory(new  PropertyValueFactory<>("CustCont"));
    }


    private void setUi(String m) throws IOException {
        rootH.getChildren().clear();
        ;
        rootH.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + m + ".fxml")));
    }


    public void btnMorderOnAction(MouseEvent mouseEvent) throws IOException {
        //ObservableList<OrdersDTO> ordDetails = FXCollections.observableArrayList();
        //crt();
        crt();
        nextUi();

    }

        public void crt()throws IOException {
            CustomeeDTO o = new CustomeeDTO();

            ObservableList<OrdersDTO> orderDetailList = FXCollections.observableArrayList();
            ObservableList<ProductDTO> productList = FXCollections.observableArrayList();

            for (int i = 0; i < tblCart.getItems().size(); i++) {

                orderDetailList.add(new OrdersDTO(lblOID1.getText(),
                        txtContact.getText(), tblCart.getItems().get(i).getCatID(),
                        tblCart.getItems().get(i).getProductName(),
                        tblCart.getItems().get(i).getMaterial(),
                        Double.parseDouble(String.valueOf(tblCart.getItems().get(i).getUnitPrice())),
                        Integer.parseInt(String.valueOf(tblCart.getItems().get(i).getQty()))));

                productList.add(new ProductDTO(tblCart.getItems().get(i).getCatID(),
                        tblCart.getItems().get(i).getProductName(),
                        tblCart.getItems().get(i).getProductID(),
                        tblCart.getItems().get(i).getMaterial(),
                        Double.parseDouble(String.valueOf(tblCart.getItems().get(i).getUnitPrice())),
                        Integer.parseInt(String.valueOf(tblCart.getItems().get(i).getQtyOnHand()))));

                o.setOrderDetailListt(orderDetailList);
                o.setProductListt(productList);


                try {
                    boolean isAdded = cartBO.purchaseOrder(o);
                    if (isAdded) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Addedd!", ButtonType.OK).show();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Faild", ButtonType.OK).show();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }

        public void nextUi() throws IOException {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/OrderForm.fxml"));
            Parent root = loader.load();
            OrderFormController oc = loader.getController();
            oc.parseData(lblOID1.getText(), lblCart1.getText(), lblTotal1.getText(), txtContact.getText());
            setUi("OrderForm");
        }



    public void btnAdCrtOnAction(ActionEvent actionEvent) {
        qty();
        ArrayList<CustomDTO> arrayList=new ArrayList<>();
        CustomDTO customDTO = new CustomDTO(cmbPcategory.getSelectionModel().getSelectedItem().toString(),txtPID.getText(),cmbPname.getSelectionModel().getSelectedItem().toString(),txtPdsecrip.getText(),Double.parseDouble(txtPunitp.getText()),Integer.parseInt(txtQTYH.getText()),Integer.parseInt(lblQTY1.getText()),txtContact.getText(),lblOID1.getText());
        arrayList.add(customDTO);
        tblCart.getItems().add(customDTO);

        total();
        //qty();


    }
     private boolean checkduplicate(){
//        for (int i=0; i<tblCart.getItems().size();i++){
//            String rowCode = tblCart.getSelectionModel().getSelectedItem().toString();
//            if (rowCode.equals(clmPID.getCellData(i))){
//                int PQTY = clmPID.getCellData(i);
//                double oldprice = Double.parseDouble(lblTotal1.getText());
//                int updateQty = Integer.parseInt(PQTY + txtQTYH.getText());
//                //tblCart.getItems().set(updateQty ,i ,5);
//                //clmID.setCellValueFactory(new PropertyValueFactory<>("qty"));
//
//            }
//        }
        return false;
     }

    public void total(){
        //double stringSelected;
        double tot =Double.parseDouble(lblTotal1.getText());
        int qty =Integer.parseInt(txtQTYH.getText());
        double unitp =Double.parseDouble(txtPunitp.getText());
        tot= tot+(qty*unitp);
        lblTotal1.setText(String.valueOf(tot));
         //stringSelected = tblCart.getSelectionModel().getSelectedItems().get(0).getUnitPrice();
        //System.out.println(stringSelected);

    }

    public void qty(){
        int qtyy =Integer.parseInt(txtQTYH.getText());
        int quanty=Integer.parseInt(lblQTY1.getText());
        int ttqtyy = quanty-qtyy;
        if (ttqtyy<0){
            new Alert(Alert.AlertType.CONFIRMATION,"Out of stock",ButtonType.OK).show();
        }else {
            lblQTY1.setText(String.valueOf(ttqtyy));
        }
    }

    public void tbl(){
        /*Object selectedems = tblCart.getSelectionModel().getSelectedItems().get(1);
        System.out.println(selectedems);
        String column = selectedems.toString().split(",")[0].substring(1);
        System.out.println(column);*/

        ObservableList<CustomDTO> fetch = tblCart.getItems();

        System.out.println(fetch.get(0).getMaterial());
    }


    public void btnRemoveOnAction(ActionEvent actionEvent) {
        ObservableList<CustomDTO> allStrings;
        ObservableList<CustomDTO> stringSelected;
        allStrings = tblCart.getItems();
        //printElements(allStrings);
        System.out.println(tblCart.getSelectionModel().getSelectedItems());

        stringSelected = tblCart.getSelectionModel().getSelectedItems();
        System.out.println(stringSelected);
        stringSelected.forEach(allStrings::remove);

    }


    public void resetTextField() {
        cmbPcategory.getSelectionModel().clearSelection();
        cmbPname.getSelectionModel().clearSelection();
        txtPID.setText(null);
        txtPdsecrip.setText(null);
        txtPunitp.setText(null);
        lblQTY1.setText(null);
        txtQTYH.setText(null);
    }

    public void loadcate() {

        try {
            ArrayList<String> allRoom = null;
            allRoom = productBO.getAllc();
            cmbPcategory.setItems(FXCollections.observableArrayList(allRoom));
            //String value = (String) cmbPcategory.getValue();
            //ArrayList<String> allRooms = productBO.getAllp(value);
            //cmbPname.setItems(FXCollections.observableArrayList(allRooms));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void cmbPcategoryOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            // System.out.println("hhhhhh");

            String value = (String) cmbPcategory.getValue();
            //System.out.println(value);
            ArrayList<String> allRooms = productBO.getAllp(value);
            cmbPname.setItems(FXCollections.observableArrayList(allRooms));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void cmbPnameOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            String res = (String) cmbPname.getValue();
            ProductDTO room = productBO.search(res);
            txtPID.setText(room.getProductName());
            txtPdsecrip.setText(room.getMaterial());
            txtPunitp.setText(String.valueOf(room.getUnitPrice()));
            lblQTY1.setText(String.valueOf(room.getQtyOnHand()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setOID() {
        String temp = "";
        String OID = "";

        try {
            temp = orderBO.getLastOID();

            if (temp == null)
                temp = "R000";
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
            OID = "R00" + (changer + 1);

        else if (changer > 8 && changer < 99)
            OID = "R0" + (changer + 1);

        else
            OID = "R" + (changer + 1);


        lblOID1.setText(OID);
    }


    public void setPID() {
        String temp = "";
        String PID = "";

        try {
            temp = cartBO.getLastPID();

            if (temp == null)
                temp = "P000";
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
            PID = "P00" + (changer + 1);

        else if (changer > 8 && changer < 99)
            PID = "P0" + (changer + 1);

        else
            PID = "P" + (changer + 1);


        txtPID.setText(PID);
    }


}
