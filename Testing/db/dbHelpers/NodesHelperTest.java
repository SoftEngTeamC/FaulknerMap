package db.dbHelpers;

import db.dbClasses.Coordinate;
import db.dbClasses.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sam on 4/3/17.
 */
public class NodesHelperTest {
    NodesHelper nh = db.Driver.getNodesHelper();
    //(x,y)
    Coordinate coord1 = new Coordinate(10, 20, 30);
    Coordinate coord2 = new Coordinate(12, 22, 32);
    Coordinate coord3 = new Coordinate(14, 24, 34);
    Coordinate coord4 = new Coordinate(16, 26, 36);
    //Nodes
    Node node1 = new Node(null, coord1, "Node 1");
    Node node2 = new Node(null, coord2, "Node 2");
    Node node3 = new Node(null, coord3, "Node 3");
    Node node4 = new Node(null, coord4, "Node 4");


    @Test
    public void get() throws Exception {
    }

    @Test
    public void addNode() throws Exception {
    }

    @Test
    public void updateNode() throws Exception {
    }

    @Test
    public void deleteNode() throws Exception {
    }

    @Test
    public void getNodeByID() throws Exception {
    }

    @Test
    public void getNodeByName() throws Exception {
    }

    @Test
    public void getNodes() throws Exception {
    }

    @Test
    public void printAllNodes() throws Exception {
    }

    @Test
    public void populateTable() throws Exception {
    }

}