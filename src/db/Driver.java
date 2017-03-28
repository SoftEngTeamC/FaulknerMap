package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.HospitalServicesSchema.*;

import javax.swing.plaf.nimbus.State;

/**
 * Created by Gina on 3/27/17.
 */
public class Driver {
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
            connection = DriverManager.getConnection("jdbc:derby:faulknerDatabase");
            dropDB(connection); // checks there isn't already a db

            buildTables(connection); //build all tables

        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
            return;
        }
        System.out.println("Java DB connection established!");

        System.out.println("\nStaring testing...");
        try {
            System.out.println("\nPrinting out database: ");
            Statement stmt = connection.createStatement();
            String str = "SELECT * FROM " + HospitalServicesSchema.HospitalServicesTable.NAME;
            ResultSet rs = stmt.executeQuery(str);
            printAllRows(rs);

            //Dont forget to double single quotes in order to escape them in SQL
            System.out.println("\nStoring new data...");
            addRow("Allergy ", "4G", stmt);
            addRow("Arthritis Center", "4D", stmt);
            addRow("Brigham and Women''s Primary Physicians", "4A/4S/5J", stmt);
            addRow("Cardiology", "4G", stmt);
            addRow("Doherty Conference Room", "4th Floor", stmt);
            addRow("Endocrinology", "4G", stmt);
            addRow("Gastroenterology", "4G", stmt);
            addRow("Gastroenterology Associates", "4B", stmt);
            addRow("Geriatrics/Senior Health", "4G", stmt);
            addRow("Headache Center", "4H", stmt);
            addRow("Hematology", "4G", stmt);
            addRow("Infectious Diseases", "4F", stmt);
            addRow("Interpreter Services", "4th Floor", stmt);
            addRow("John R. Graham Headache Center", "4H", stmt);
            addRow("Mary Ann Tynan Conference Rooms", "4th Floor", stmt);
            addRow("Medical Library", "4th Floor", stmt);
            addRow("Medical Records", "4th Floor", stmt);
            addRow("Medical Specialties", "4G", stmt);
            addRow("Men''s Health Center","4N", stmt);
            addRow("Mohs and Dermatologic Surgery", "4J", stmt);
            addRow("Neurology", "4H", stmt);
            addRow("Neurology/Sleep Division", "4C", stmt);
            addRow("Pulmonary", "4G", stmt);
            addRow("Renal", "4G", stmt);
            addRow("Rheumatology Center", "4D", stmt);
            addRow("Sadowsky Conference Room", "4th Floor", stmt);
            addRow("Saslow Conference Room", "4th Floor", stmt);
            addRow("Social Work", "4th Floor", stmt);
            addRow("Urology", "4N", stmt);


            System.out.println("\nRetrieving new data...");
            rs = stmt.executeQuery(str);
            printAllRows(rs);

            connection.close();

        } catch (Exception e){
            System.out.println("\nCould not test database");
            e.printStackTrace();
        }
    }


    /**
     * dropDB checks that the db doesn't already exist, and if so drops all tables
     */
    public static void dropDB(Connection connection) {
        System.out.println("Checking for existing tables.");
        try {
            Statement stmt = connection.createStatement(); //Statement object
            try {
                // Drop the UnpaidOrder table.
                String str = "DROP TABLE " + HospitalServicesTable.NAME;
                stmt.execute(str); //check HospitalServices table
                System.out.println("HospitalServices table dropped.");
            } catch (SQLException ex) {
                //Table did not exist
            }

            //will create try/catchs for all tables we create

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    /**
     * This is the function that will create all tables in our database
     */
    public static void buildTables(Connection conn) {
        try {
            Statement stmt = conn.createStatement(); // Get a Statement object

            // Create HospitalService table.
            String str = "CREATE TABLE " + HospitalServicesTable.NAME + "(" +
                    HospitalServicesTable.Cols.NAME + " VARCHAR(50) NOT NULL PRIMARY KEY, " +
                    HospitalServicesTable.Cols.LOCATION + " VARCHAR(20) )";
            stmt.execute(str);

            // Add row to table
            addRow("Help Desk", "Ground Location", stmt);

            System.out.println("HospitalServices table created and populated.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void addRow(String name, String location, Statement stmt){
        String str = "INSERT INTO " + HospitalServicesTable.NAME + " VALUES (" +
                "'" + name + "', '" + location + "')";
        try {
            stmt.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> printAllRows(ResultSet rs){
        ArrayList<String> strArray = new ArrayList<String>();

        try {
            //iterate through result, printing out values of each row and storing each row in a list of Strings
            while (rs.next()) {
                String temp = "Name: " + rs.getString(HospitalServicesSchema.HospitalServicesTable.Cols.NAME) +
                        " --- Location: " + rs.getString(HospitalServicesSchema.HospitalServicesTable.Cols.LOCATION);
                System.out.println(temp);
                strArray.add(temp);
            }
        } catch (Exception e){

        }
        return strArray;
    }
}

