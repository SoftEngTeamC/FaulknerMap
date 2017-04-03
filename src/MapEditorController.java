
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

import db.dbClasses.Edge;
import db.dbClasses.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;


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

    // Edit Node objects
    @FXML
    private ListView<String> editNode_routesConnected;
    @FXML
    private ListView<String> editNode_disconnectedRoutes;
    @FXML
    private Button editNode_updateBtn;
    @FXML
    private Button editNode_removeBtn;
    @FXML
    private Button editNode_connectBtn;
    @FXML
    private Button editNode_undoBtn;
    @FXML
    private TextField editNode_nameField;

    // Edit Route objects
    @FXML
    private TextField editRoute_nameField;
    @FXML
    private Button editRoute_updateBtn;
    @FXML
    private ListView<String> editRoute_startingNodes;
    @FXML
    private ListView<String> editRoute_endingNodes;
    @FXML
    private ListView<String> editRoute_availableNodes;
    @FXML
    private Button editRoute_switchBtn;

    // Map imageview and anchorpane
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane anchorPane;




    public void initialize(){

        // set image width and height to that of the anchorpane that it is on
        imageView.setSize((float)anchorPane.getWidth(), (float)anchorPane.getHeight());

        //mouse clicked handler, send x,y data to function
        anchorPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // get the coordinates
                double x = event.getX();
                double y = event.getY();
                // send to function
                mouseClicked(x,y);

            }
        });

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

    /**
     * @author Paul
     *
     * event handler for update name button in edit node tab
     *
     */
    public void editNode_updateBtnPressed(){

    }

    /**
     * @author Paul
     *
     * event handler for remove  button in edit node tab
     *
     */
    public void editNode_removeBtnPressed(){

    }

    /**
     * @author Paul
     *
     * event handler for connect button in edit node tab
     *
     */
    public void editNode_connectBtnPressed(){

    }

    /**
     * @author Paul
     *
     * event handler for update name button in edit node tab
     *
     */
    public void editNode_undoBtnPressed(){

    }

    /**
     * @author Paul
     *
     * event handler for update button in edit route tab
     *
     */
    public void editRoute_updateBtnPressed(){

    }

    /**
     * @author Paul
     *
     * event handler for switch button in edit route tab
     *
     */
    public void editRoute_switchBtnPressed(){

    }

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
