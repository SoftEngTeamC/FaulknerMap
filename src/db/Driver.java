package db;

import java.sql.*;

import db.dbHelpers.*;

/**
 * Created by Gina on 3/27/17.
 */
public class Driver {

    private static HospitalServicesHelper hospitalServicesHelper;
    private static HospitalProfessionalsHelper hospitalProfessionalsHelper;
    private static NodesHelper nodesHelper;
    private static EdgesHelper edgesHelper;

    public static void main(String[] args) {
        System.out.println("-------Embedded Java DB Connection Testing --------");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Java DB db.Driver not found. Add the classpath to your module.");
            System.out.println("For IntelliJ do the following:");
            System.out.println("File | Project Structure, Modules, Dependency tab");
            System.out.println("Add by clicking on the green plus icon on the right of the window");
            System.out.println("Select JARs or directories. Go to the folder where the Java JDK is installed");
            System.out.println("Select the folder java/jdk1.8.xxx/db/lib where xxx is the version.");
            System.out.println("Click OK, compile the code and run it.");
            e.printStackTrace();
            return;
        }

        System.out.println("Java DB db.Driver registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:derby:faulknerDatabase;create=true");

        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
            return;
        }
        System.out.println("Java DB connection established!");

   //     hospitalServicesHelper = HospitalServicesHelper.get(connection);
   //     hospitalProfessionalsHelper = HospitalProfessionalsHelper.get(connection);

        //Nodes must be created before edges since the edges table references the node table
        nodesHelper = NodesHelper.get(connection);
        edgesHelper = EdgesHelper.get(connection);

       // EdgesHelper edgesHelper1 = EdgesHelper.get(connection);

       // nodesHelper.printAllNodes();
       /// edgesHelper.printAllEdges();

    }

    //getter for all other classes to access the HospitalService table
    public static HospitalServicesHelper getHospitalServiceHelper() {
        return hospitalServicesHelper;
    }

    //getter for all other classes to access the HospitalProfessional table
    public static HospitalProfessionalsHelper getHospitalProfessionalHelper() {
        return hospitalProfessionalsHelper;
    }

    //getter for all other classes to access the Edges table
    public static EdgesHelper getEdgesHelper() {
        return edgesHelper;
    }

    //getter for all other classes to access the Nodes table
    public static NodesHelper getNodesHelper() {
        return nodesHelper;
    }

}

