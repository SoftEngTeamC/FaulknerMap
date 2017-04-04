
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;

import java.awt.*;
import java.util.*;


import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class MainController{
    @FXML
    private Button AdminToolButton;
    @FXML
    private ImageView FourthFloor;
    @FXML
    private AnchorPane MapAnchor;
    @FXML
    private TextField SearchBar;
    @FXML
    private ListView SearchResults;

    public void initialize() {
        //the bind function locks an element property to another elements property
        FourthFloor.fitWidthProperty().bind(MapAnchor.widthProperty());

        //test List of Strings
        LinkedList<String> names = new LinkedList<String>();
        names.add("Jon");
        names.add("Jon is cool");
        names.add("Jon is the best");
        names.add("Jon sure is good looking");
        UpdateSearchResults(names);

    }


    //NEED TO INTEGRATE COORDINATE CLASS I was using 'point' class when I made it
    //DisplayMap function takes a list of points(X,Y) and creates circles at all their positions and lines between them
    //public void DisplayMap(LinkedList<point> nodes){
    //    for(int i=0;i<nodes.size();i++){
    //        MakeCircle(nodes.get(i).getX(),nodes.get(i).getY());
    //        if(i>0){
    //            MakeLine(nodes.get(i-1).getX(),nodes.get(i-1).getY(),nodes.get(i).getX(),nodes.get(i).getY());
    //        }
    //    }
    //}

    //MakeCircle creates a circle centered at the given X,Y relative to the initial size of the image
    //It locks the points to their position on the image,
    //Resizing the image does not effect the relative position of the nodes and the image
    public void MakeCircle(int x, int y) {
        // initial size of image and the image ratior
        double ImgW = FourthFloor.getImage().getWidth();
        double ImgH = FourthFloor.getImage().getHeight();
        double ImgR = ImgH / ImgW;

        Circle circle = new Circle();
        //These bind the center positions relative to the width property of the image
        //the new center is calculated using the initial ratios
        circle.centerXProperty().bind(FourthFloor.fitWidthProperty().multiply(x / ImgW));
        circle.centerYProperty().bind(FourthFloor.fitWidthProperty().multiply(ImgR).multiply(y / ImgH));
        circle.setRadius(3);
        circle.fillProperty().setValue(Paint.valueOf("#ff2d1f"));
        MapAnchor.getChildren().add(circle);
    }

    //MakeLine take 2 points (effectively) and draws a line from point to point
    //this line is bounded to the image such that resizing does not effect the relative position of the line and image
    public void MakeLine(int x1, int y1, int x2, int y2) {
        double ImgW = FourthFloor.getImage().getWidth();
        double ImgH = FourthFloor.getImage().getHeight();
        double ImgR = ImgH / ImgW;

        Line edge = new Line();
        //the points are bound to the fit width property of the image and scaled by the initial image ratio
        edge.startXProperty().bind(FourthFloor.fitWidthProperty().multiply((x1 / ImgW)));
        edge.startYProperty().bind(FourthFloor.fitWidthProperty().multiply(ImgR).multiply((y1 / ImgH)));
        edge.endXProperty().bind(FourthFloor.fitWidthProperty().multiply((x2 / ImgW)));
        edge.endYProperty().bind(FourthFloor.fitWidthProperty().multiply(ImgR).multiply((y2 / ImgH)));
        MapAnchor.getChildren().add(edge);
    }

    //This function takes a list of strings and updates the SearchResult ListView to contain those strings
    public void UpdateSearchResults(LinkedList<String> results){
        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll(results);
        SearchResults.setItems(data);
    }

    //This function is called when the user clicks on a Search Result.
    //Information unique to the ListView Item can be accessed
    //aka, we should be able to associate this click to a database object to pullup Info on the object and Display its Map Directions
    public void handleClickedOnSearchResult() {
        System.out.println("clicked on " + SearchResults.getSelectionModel().getSelectedItem());
    }
    public void Search() {
        System.out.println("Searching");
        System.out.println(SearchBar.getText().toString());
    }


    //SCREEN CHANGING FUNCTIONS
    @FXML
    public void OpenAdminTool() throws Exception {
        // goto genres screen
        Stage stage = (Stage) AdminToolButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AdminToolMenu.fxml"));
        stage.setTitle("AdminToolMenu");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}


