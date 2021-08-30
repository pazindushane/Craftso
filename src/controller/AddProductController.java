package controller;

import bo.BOFactory;
import bo.custom.ProductBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CatagoryDTO;
import dto.CustomerDTO;
import dto.ProductDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {
    public JFXComboBox cmbPcategory;


    public JFXTextField txtPdsecrip;
    public JFXTextField txtPunitp;
    public JFXButton btnAdCrt;
    public JFXButton btnRemove;
    public JFXTextField txtProductID;
    public JFXTextField txtPname;
    //public TableView ;
   // public TableColumn clmCategory;
    //public TableColumn clmName;
    //public TableColumn clmID;
    //public TableColumn clmDesc;
    //public TableColumn clmUprice;
    //public TableColumn clmQTY;
    public JFXTextField txtQty;
    public JFXButton btnView;
    public JFXTextField txtCatID;

    @FXML
    private TableView<ProductDTO> tblCart;

    @FXML
    private TableColumn<ProductDTO, String> clmCategory;

    @FXML
    private TableColumn<ProductDTO, String> clmName;

    @FXML
    private TableColumn<ProductDTO, String> clmID;

    @FXML
    private TableColumn<ProductDTO, String> clmDesc;

    @FXML
    private TableColumn<ProductDTO, Double> clmUprice;

    @FXML
    private TableColumn<ProductDTO, Integer> clmQTY;

    ProductBO productBO = (ProductBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PRODUCT);
    //CategoryBO categoryBO = (CategoryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setProductID();
        //setCatID();
        //setCatID();
        //LoadComboUpdate();
        //addValuesToCmbCategory();
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }

    public void btnAdCrtOnAction(ActionEvent actionEvent) {
        ProductDTO product = new ProductDTO(txtCatID.getText(),txtPname.getText(),txtProductID.getText(),txtPdsecrip.getText(),Double.parseDouble(txtPunitp.getText()),Integer.parseInt(txtQty.getText()));

        try {
            boolean isAdded = productBO.add(product);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Product Added Successfully", ButtonType.OK).show();
                //resetTextField();
            }else {
                new Alert(Alert.AlertType.WARNING,"Product not added",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public void cmbPcategoryOnAction(ActionEvent actionEvent) {
    }

    public void setProductID(){
        String temp = "";
        String ProductID = "";

        try {
            temp = productBO.getLastCustID();

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
            ProductID = "P00" + (changer + 1);

        else if (changer > 8 && changer < 99)
            ProductID = "P0" + (changer + 1);

        else
            ProductID = "P" + (changer + 1);


        txtProductID.setText(ProductID);
    }
    public void resetTextField(){
        txtProductID.setText(null);
        txtPname.setText(null);
        txtPdsecrip.setText(null);
        txtPunitp.setText(null);
        txtQty.setText(null);
    }


    public void btnViewOnAction(ActionEvent actionEvent) {
        try {
            ObservableList<ProductDTO> list = productBO.getAll();
            tblCart.getItems().clear();
            tblCart.setItems(list);

            clmCategory.setCellValueFactory(new PropertyValueFactory<ProductDTO,String>("CatID"));
            clmName.setCellValueFactory(new PropertyValueFactory<ProductDTO,String>("ProductName"));
            clmID.setCellValueFactory(new PropertyValueFactory<ProductDTO,String>("ProductID"));
            clmDesc.setCellValueFactory(new PropertyValueFactory<ProductDTO,String>("Material"));
            clmUprice.setCellValueFactory(new PropertyValueFactory<ProductDTO,Double>("UnitPrice"));
            clmQTY.setCellValueFactory(new PropertyValueFactory<ProductDTO,Integer>("qtyOnHand"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void LoadComboUpdate(){
        cmbPcategory.getItems().add("Beds");
        cmbPcategory.getItems().add("chairs");
        cmbPcategory.getItems().add("Tables");
        cmbPcategory.getItems().add("Wardrobes");
    }

    public void setCatID(){
        String temp = "";
        String CatID = "";

        try {
            temp = productBO.getLastCatID();

            if (temp == null)
                temp = "CAT";
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
            CatID = "CAT" + (changer + 1);

        else if (changer > 8 && changer < 99)
            CatID = "CAT" + (changer + 1);

        else
            CatID = "CAT" + (changer + 1);


        txtCatID.setText(CatID);
    }




}
