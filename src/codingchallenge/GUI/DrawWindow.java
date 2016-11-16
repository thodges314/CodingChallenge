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
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author thodges
 */
public class DrawWindow extends Application {

    @Override
    public void start(Stage primaryStage) {

        //define TextArea original
        TextArea taOriginal = new TextArea();
        taOriginal.setPrefColumnCount(25);
        taOriginal.setPrefRowCount(8);
        taOriginal.setWrapText(true);

        //define TextArea translate
        TextArea taTranslate = new TextArea();
        taTranslate.setPrefColumnCount(25);
        taTranslate.setPrefRowCount(8);
        taTranslate.setWrapText(true);
        taTranslate.setEditable(false);

        //define and bind Translate button
        Button btTranslate = new Button("condense");
        btTranslate.setOnAction(e -> {
            taTranslate.setText(ParseInput.parseInput(taOriginal.getText()).toString());
        });

        //define and bind MenuBar behavior.
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);
        MenuItem mnuOpen = new MenuItem("Open");
        MenuItem mnuSave = new MenuItem("Save");
        menuFile.getItems().addAll(mnuOpen, mnuSave);
        try {
            mnuOpen.setOnAction(e -> taOriginal.setText(loadFile(primaryStage)));
        } catch (Exception e) {
            Emergency.alert(e);
        };

        try {
            mnuSave.setOnAction(e -> saveFile(primaryStage, taTranslate.getText()));
        } catch (Exception e) {
            Emergency.alert(e);
        };

        //define GridPane and add children
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.add(menuBar, 0, 0);
        pane.add(taOriginal, 0, 1);
        pane.add(btTranslate, 1, 1);
        pane.add(taTranslate, 2, 1);
        pane.add(new Label("original"), 0, 2);
        pane.add(new Label("condensed"), 2, 2);

        //define Scene, Stage, attach scene to stage and make visible
        Scene scene = new Scene(pane);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Merge zip code ranges.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String loadFile(Stage stage) {
        String inData = "";
        try {
            File thisFile = FileIO.getFile(stage);
            Scanner inFile = new Scanner(thisFile);
            inData = inFile.nextLine();

            System.out.println(inData + "");
        } catch (Exception ex) {
        };
        return inData;
    }

    private void saveFile(Stage stage, String textSave) {
        try {
            File saveFile = FileIO.putFile(stage);
            PrintWriter output = new PrintWriter(saveFile);
            output.println(textSave);
            output.close();

        } catch (Exception e) {
        };
    }

    public static void launch(String[] args) {
        Application.launch(args);
    }

}
