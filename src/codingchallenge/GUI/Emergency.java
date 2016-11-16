/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingchallenge.GUI;

import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author thodges
 */
public class Emergency {

    public static void alert(Exception ex) {
        Alert redAlert = new Alert(AlertType.ERROR);
        redAlert.setTitle("Exception!");
        redAlert.setHeaderText("Exception!");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        TextArea taAlert = new TextArea();
        taAlert.setWrapText(true);
        taAlert.setEditable(false);
        taAlert.setPrefColumnCount(80);
        taAlert.setText(exceptionText);

        redAlert.getDialogPane().setContent(taAlert);
        redAlert.showAndWait();
    }

}
