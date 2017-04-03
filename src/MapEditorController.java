
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

import db.dbClasses.Edge;
import db.dbClasses.Node;


/**
 * Created by jack on 3/30/17.
 */
public class MapEditorController implements AdminController {

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




    public void initialize(){}
    public void back(){}
    public void logout(){}

    public Node addNode(){return null;}
    public Edge addEdge(){return null;}
    public void removeNode(){}
    public void removeEdge(){}

}
