/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingchallenge.GUI;

import codingchallenge.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author thodges
 */
public class DrawWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField tfOriginal = new TextField();
        tfOriginal.setMinHeight(250);
        tfOriginal.setScaleShape(true);// does this help?
        tfOriginal.setAlignment(Pos.TOP_LEFT);

        TextField tfTranslate = new TextField();
        tfTranslate.setMinHeight(250);
        tfTranslate.setEditable(false);
        //tfTranslate.setText("copy me");
        tfTranslate.setAlignment(Pos.TOP_LEFT);

        Button btTranslate = new Button("translate");
        btTranslate.setOnAction(e -> {
            tfTranslate.setText(ParseInput.parseInput(tfOriginal.getText()).toString());
        });

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);
        MenuItem mnuOpen = new MenuItem("Open");
        MenuItem mnuSave = new MenuItem("Save");
        menuFile.getItems().addAll(mnuOpen, mnuSave);
        try {
            mnuOpen.setOnAction(e -> tfOriginal.setText(loadFile(primaryStage)));
        } catch (Exception e) {};
        
        try {
            mnuSave.setOnAction(e -> saveFile(primaryStage, tfTranslate.getText()));
        } catch (Exception e) {};

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        pane.add(menuBar, 0, 0);

        pane.add(tfOriginal, 0, 1);

        pane.add(btTranslate, 1, 1);

        pane.add(tfTranslate, 2, 1);
        pane.add(new Label("original"), 0, 2);
        pane.add(new Label("translated"), 2, 2);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Merge zip code ranges.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String loadFile(Stage stage) {
        String inData = "";
        try {
            File thisFile = FileIO.getFile(stage);
            //FileInputStream inFile = new FileInputStream(thisFile);
            Scanner inFile = new Scanner(thisFile);
            inData = inFile.nextLine();

            System.out.println(inData + "");
            //tfOriginal.setText(inData+"");
        } catch (Exception ex) {
        };
        return inData;
    }
    
    private void saveFile(Stage stage, String textSave){
        try {
            File saveFile = FileIO.putFile(stage);
            PrintWriter output = new PrintWriter(saveFile);
            output.println(textSave);
            output.close();
            
        } catch (Exception e) {};
    }

    public static void launch(String[] args) {
        Application.launch(args);
    }

}
