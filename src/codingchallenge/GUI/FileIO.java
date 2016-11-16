package codingchallenge.GUI;

import java.io.*;
import javafx.stage.*;

/**
 *Handles the dialogs for opening and saving files.  Presently there is 
 * no restriction on type of file that can be opened, as it wold be better for 
 * the user to try to foolishly open a jpeg or mp3 then to be unable to open
 * a legitamate file with a strange file extension.
 * 
 * @author Thomas Hodges
 */
public class FileIO {

    /**
     *controls the open dialog box.
     * 
     * @param stage environment obect needed to host this dialog box
     * @return File object for the file to be opened
     */
    public static File getFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            return file;
        }
        return null;
    }

    /**
     *controls the save dialog box
     * 
     * @param stage environment obect needed to host this dialog box
     * @return File object for the file to be saved
     */
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
