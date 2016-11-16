package codingchallenge.GUI;

import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
/**
 *Handles Exceptions by displaying the system trace in an alert window.
 * Right now there is some conflict in that errors to not display properly when
 * using this program from the command line.  Previous attempts to fix this 
 * included creating two alert methods - one for GUI and one for Terminal,
 * however there don't appear to be any manners by which one can determine if 
 * JavaFX has been initialised.  Possible solutions include setting flags on 
 * the event of loading the window interface, however this would uncomfortably 
 * increase coupling.
 * 
 * @author Thomas Hodges
 */
public class Emergency {

    /**
     *receives an Exception object and displays a stack trace in an 
     * emergency dialog.  A workaround involving a StringWriter and a
     * PrintWriter are used to extract the stackTrace fromt he exception object.
     * 
     * @param ex an Exception object for alert to extract display data from
     */
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
