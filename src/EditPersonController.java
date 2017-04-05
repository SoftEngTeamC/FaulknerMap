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
    private Button logoutBtn;
    @FXML
    private Button backBtn;

    @FXML
    public void back() throws Exception{
        Stage stage = (Stage) backBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DirectoryEditor.fxml"));
        stage.setTitle("Directory Editor");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    public void logout()throws Exception {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
        stage.setTitle("Main");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
        @FXML
        public void update(){}

    }


