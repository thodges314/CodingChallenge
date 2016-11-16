/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingchallenge.GUI;

import java.io.*;
import javafx.stage.*;

/**
 *
 * @author thodges
 */
public class FileIO {

    public static File getFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            return file;
        }
        return null;
    }

    public static File putFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("save");
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            return file;
        }
        return null;
    }
}
