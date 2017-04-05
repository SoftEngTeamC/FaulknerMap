import db.dbHelpers.NodesHelper;
import javafx.collections.ObservableList;
import db.Driver;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import db.Driver.*;
import db.dbHelpers.*;
import db.dbClasses.*;
import db.dbClasses.Edge;
import db.dbClasses.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



/**
 * Created by jack on 3/30/17.
 */
public class MapEditorController implements AdminController {

    // Currently selected node and edge
    private Node selectedNode;
    private Edge selectedEdge;

    // Back and logout buttons
    @FXML
    private Button backBtn;
    @FXML
    private Button logoutBtn;

    // Remove Node objects
    @FXML
    private TextField removeNode_searchField;
    @FXML
    private ListView<String> removeNode_searchList;
    @FXML
    private Button removeNode_searchBtn;
    @FXML
    private Button removeNode_removeBtn;


    // Add node objects
    @FXML
    private TextField addNode_nameField;
    @FXML
    private TextField addNode_xPos;
    @FXML
    private TextField addNode_yPos;
    @FXML
    private ListView<String> addNode_connectedNodesList;
    @FXML
    private Button addNode_createNodeBtn;
    @FXML
    private ListView<String> addNode_unconnectedNodesList;
    @FXML
    private Button addNode_connectToNodeBtn;

    // Edit node objects
    @FXML
    private TextField editNode_searchField;
    @FXML
    private Button editNode_searchBtn;
    @FXML
    private ListView<String> editNode_searchResultsList;
    @FXML
    private ListView<String> editNode_neighborsList;
    @FXML
    private Button editNode_removeNeighborBtn;
    @FXML
    private TextField editNode_addField;
    @FXML
    private Button editNode_addBtn;



    // Map imageview and anchorpane
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane anchorPane;

    // Images
    Image floor4Image;

    // database helper
    NodesHelper nodesHelper;


    public void initialize(){

        // Set the image view to populate the image
        System.out.println("we're in this");
        floor4Image = new Image("file:../Resources/floor4.png");
        imageView = new ImageView(floor4Image);

        //mouse clicked handler, send x,y data to function
        anchorPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // get the coordinates
                double x = event.getX();
                double y = event.getY();
                // send to function
                mouseClicked(x,y);
            }});

        // Make database helpers
        nodesHelper = Driver.getNodesHelper();



    }

    /**
     * @author Paul
     *
     * Back button action event handler. Opens the Admin page
     *
     */
    public void back(){
        try {
            Stage stage = (Stage) backBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("AdminToolMenu.fxml"));
            stage.setTitle("Directory Editor");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception E){
            System.out.println("Couldn't switch scenes");
        }
    }

    /**
     * @author Paul
     *
     * Action event handler for logout button being pressed. Goes to main screen.
     *
     */
    public void logout(){
        try {
            Stage stage = (Stage) logoutBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage.setTitle("Main");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception E){
            System.out.println("Couldn't switch scenes");
        }
    }

    // Methods for the remove node tab

    /**
     * @author Feng
     *
     * remove node tab: search button event handler
     *
     */
    public void removeNode_searchBtnPressed(){
        String searchField = String.valueOf(removeNode_searchField);
        String selectedName = NodesHelper.getNodeByName(searchField).getName();
        ArrayList<String> nodeName = new ArrayList<>();
        nodeName.add(selectedName);
        removeNode_searchList.setItems((ObservableList<String>) nodeName);
    }

    /**
     * @author Feng
     *
     * remove node tab: remove button event handler
     *
     */
    public void removeNode_removeBtnPressed(){
        String selectedItem = removeNode_searchList.getSelectionModel().getSelectedItem();
        Node selectNode = NodesHelper.getNodeByName(selectedItem);
        NodesHelper.deleteNode(selectNode);
        ArrayList<String> emptyList = new ArrayList<String>();
        removeNode_searchList.setItems((ObservableList<String>) emptyList);
    }

    // Methods for the add node tab

//    /**
//     * @author Paul
//     *
//     * add node tab: remove button event handler
//     *
//     */
//    public void addNode_connectToNodeBtnPressed(){
//
//    }

    /**
     * @author Feng
     *
     * add node tab: create node button event handler
     *
     */
    public void addNode_createNodeBtnPressed(){

        float x = Float.parseFloat(addNode_xPos.getText());
        float y = Float.parseFloat(addNode_yPos.getText());
        Node newNode = new Node(null, new Coordinate(x, y, 4), addNode_nameField.getText());
        nodesHelper.addNode(newNode);
    }

    // methods for the edit node tab

    /**
     * @author Paul
     *
     * edit node tab: search button event handler
     *
     */
    public void editNode_searchBtnPressed(){

    }

    /**
     * @author Paul
     *
     * edit node tab: remove neighbor button event handler
     *
     */
    public void editNode_removeNeighborBtnPressed(){
    }

    /**
     * @author Paul
     *
     * edit node tab: Add node button event handler
     *
     */
    public void editNode_addBtnPressed(){

    }



    // methods for the image and anchor pane

    /**
     * @author Paul
     *
     * Mouse click on image event handler.
     *
     */
    public void imageClicked(){

    }

    /**
     * @author Paul
     *
     * Handles what happens when mouse is clicked
     *
     * @param x value
     * @param y value
     *
     */
    private void mouseClicked(double x, double y){

    }




    public Node addNode(){return null;}
    public Edge addEdge(){return null;}
    public void removeNode(){}
    public void removeEdge(){}

}
