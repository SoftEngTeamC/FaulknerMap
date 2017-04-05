import db.dbClasses.*;


import db.Driver;
import db.dbHelpers.*;
import db.dbClasses.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class DirectoryEditorController {
    HospitalProfessionalsHelper hs = Driver.getHospitalProfessionalHelper();
    @FXML
    private Button logoutBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button editPrsnBtn;
    @FXML
    private Button addPrsnBtn;
    @FXML
    private TextField searchtext;
    @FXML
    private List tablelist;

    String usertext;
    String personname;

    @FXML
    public void initialize(){}

    @FXML
    public void back() throws Exception{
        Stage stage = (Stage) backBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AdminToolMenu.fxml"));
        stage.setTitle("Admin Tool");
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
    public void editPerson()throws Exception {
        Stage stage = (Stage) editPrsnBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("EditPersonScreen.fxml"));
        stage.setTitle("Edit Person");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    public void addPerson()throws Exception{
        Stage stage = (Stage) addPrsnBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AddPerson.fxml"));
        stage.setTitle("Add Person");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }



    @FXML
    public void search(){
    //hs.getHospitalProfessionalByName(null);
        usertext=searchtext.getText();
        personname=hs.getHospitalProfessionalByName(usertext).getName();
        System.out.print(personname);

    }

}
