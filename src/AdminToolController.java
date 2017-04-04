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
    public void editMap(){

        System.out.println("map");
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

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        if(event.getSource()==abutton){
            //get reference to the button's stage
            stage=(Stage) abutton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("DirectoryEditor.fxml"));
        }
        else {
            stage=(Stage) button2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("EditPersonScreen.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
