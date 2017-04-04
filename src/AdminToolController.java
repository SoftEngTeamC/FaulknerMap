import db.Driver.*;
import db.dbHelpers.*;
import db.dbClasses.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import java.util.Arrays;
import java.util.LinkedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;


public class AdminToolController {

    @FXML
    private Button abutton;
    @FXML
    private Button button2;
    @FXML
    private Button mapEditorBtn;

    /**
     * @author Paul
     *
     * When map editor button is pressed, it goes to the map editing screen.
     *
     */
    public void editMap() throws Exception{
            Stage stage = (Stage) mapEditorBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MapEditor.fxml"));
            stage.setTitle("Map Editor");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
    }
    @FXML
    public void editHours(){

        System.out.println("hours");
    }
    @FXML
    public void editDirectory() {

        System.out.println("Directory");

    }
    @FXML
    public void editPerson() {

        System.out.println("person");
    }
    @FXML
    public void logout(){

        System.out.println("logout");
    }

}
