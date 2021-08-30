package controller;

import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;

public class ReportsController {
    public AnchorPane roota;
    public JFXButton btncustreport;
    public JFXButton btnorderreport;
    public JFXButton btnProductReport;

    public void btncustreportONAction(ActionEvent actionEvent) {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/Reports/Cherry.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint);
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnorderreportOnaction(ActionEvent actionEvent) {
    }

    public void btnpaymentreportOnaction(ActionEvent actionEvent) {
    }

    public void btnDeliveryReportOnaction(ActionEvent actionEvent) {
    }

    public void btnProductReportOnAction(ActionEvent actionEvent) {
    }
}
