import db.Driver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import db.Driver.*;
import db.dbHelpers.*;
import db.dbClasses.*;
import javafx.stage.Stage;

/**
 * Created by Paul on 4/2/2017.
 */
public class AddPersonController {

    @FXML
    private Button backBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button addPersonBtn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField idField;

    private HospitalProfessionalsHelper professionalHelper;

    @FXML
    public void initialize(){
        professionalHelper = Driver.getHospitalProfessionalHelper();
    }

    public void backBtnPressed(){
        // switch screens to directory editor
            // goto genres screen
        try {
            Stage stage = (Stage) backBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("DirectoryEditor.fxml"));
            stage.setTitle("Directory Editor");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception E){
            System.out.println("Couldn't switch scenes");
        }
    }

    public void logoutBtnPressed(){
        // switch screens to main
        try {
            Stage stage = (Stage) backBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage.setTitle("Main");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception E){
            System.out.println("Couldn't switch scenes");
        }
    }

    public void setAddPersonBtnPressed(){
        // check if fields are entered

        // check if not already in existence

        // add to database

    }





}
