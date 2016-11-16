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
 *Draws a window for the graphical interface amd manages interaction
 * with buttons and menus.  Also loads and saves files, exporting the task
 * of getting a File object to the FileIO class.
 * 
 * @author Thomas Hodges
 */
public class DrawWindow extends Application {

    /**
     *Draws the only window used in this application aside from file
     * load and save windows.  Uses lambda expressions to manage behavior.
     * 
     * @param primaryStage the javafx 'stage' element.
     */
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
        }

        try {
            mnuSave.setOnAction(e -> saveFile(primaryStage, taTranslate.getText()));
        } catch (Exception e) {
            Emergency.alert(e);
        }

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

    //uses the FileIO.getFile method to grab a file, then reads the data into
    //a String which is passed back to the calling expression to populate the 
    //'original' TextArea.  This data is not parsed into RangeObjects at this
    //stage
    private String loadFile(Stage stage) {
        String inData = "";
        try {
            File thisFile = FileIO.getFile(stage);
            Scanner inFile = new Scanner(thisFile);
            while (inFile.hasNext())
                inData += inFile.nextLine();

            System.out.println(inData + "");
        } catch (Exception ex) {
            Emergency.alert(ex);
        }
        return inData;
    }

    //calls FileIO.putFile to get a filename, and then saves the string passed
    //from the 'translated' (later renames condensed in the interface) TextArea
    private void saveFile(Stage stage, String textSave) {
        try {
            File saveFile = FileIO.putFile(stage);
            try (PrintWriter output = new PrintWriter(saveFile)) {
                output.println(textSave);
            }

        } catch (Exception ex) {
            Emergency.alert(ex);
        }
    }

    /**
     *Launches the GUI.
     * 
     * @param args args are passed in that may have appeared on the command
     * line out of convention.
     */
    public static void launch(String[] args) {
        Application.launch(args);
    }

}
