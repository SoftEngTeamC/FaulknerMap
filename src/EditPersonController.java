import db.Driver.*;
import db.dbHelpers.*;
import db.dbClasses.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EditPersonController {
    @FXML
    private Button abutton;
    @FXML
    private Button button2;

        @FXML
        public void back(){}
        @FXML
        public void logout(){}
        @FXML
        public void update(){}
        @FXML
        private void handleButtonAction(ActionEvent event) throws IOException {
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


