package db.dbHelpers;
import db.Driver;
import db.Driver.*;
import db.dbHelpers.*;
import db.dbClasses.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sam on 4/3/17.
 */
public class EdgesHelperTest {
    //Helper
    EdgesHelper eh = Driver.getEdgesHelper();
    //Nodes and Edges to Use
    Coordinate coord1 = new Coordinate(10, 20, 30);
    Coordinate coord2 = new Coordinate(12, 22, 32);
    Coordinate coord3 = new Coordinate(14, 24, 34);
    Coordinate coord4 = new Coordinate(16, 26, 36);
    Coordinate coord5 = new Coordinate(18, 28, 38);
    Node node1 = new Node(null, coord1, "Node 1");
    Node node2 = new Node(null, coord2, "Node 2");
    Node node3 = new Node(null, coord3, "Node 3");
    Node node4 = new Node(null, coord4, "Node 4");
    Node node5 = new Node(null, coord5, "Node 5"); //unused
    //Edges
    Edge e1 = new Edge(node1, node2,10); //1 to 2
    Edge e2 = new Edge(node2, node3,10); //2 to 3
    Edge e3 = new Edge(node3, node4,15); //3 to 4


    @Test
    public void get() throws Exception {
    }

    @Test
    public void addEdge() throws Exception {
    }

    @Test
    public void updateEdge() throws Exception {
    }

    @Test
    public void deleteEdge() throws Exception {
    }

    @Test
    public void getEdgeByID() throws Exception {
    }

    @Test
    public void getNeighbors() throws Exception {
    }

    @Test
    public void getEdges() throws Exception {
    }

    @Test
    public void printAllEdges() throws Exception {
    }

    @Test
    public void populateTable() throws Exception {
    }

    @Test
    public void dropTable() throws Exception {
    }

    @Test
    public void buildTable() throws Exception {
    }

}