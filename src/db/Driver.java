package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.HospitalSchema.*;


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
            connection = DriverManager.getConnection("jdbc:derby:faulknerDatabase;create=true");
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
            String strS = "SELECT * FROM " + HospitalServicesSchema.HospitalServicesTable.NAME;
            ResultSet rsS = stmt.executeQuery(strS);
            printAllServicesRows(rsS);
            String strP = "SELECT * FROM " + HospitalProvidersSchema.HospitalProvidersTable.NAME;
            ResultSet rsP = stmt.executeQuery(strP);
            printAllProvidersRows(rsP);

            //Do not forget to double single quotes in order to escape them in SQL
            System.out.println("\nStoring new data...");
            addServiceRow("Arthritis Center", "4D", stmt);
            addServiceRow("Brigham and Women''s Primary Physicians", "4A/4S/5J", stmt);
            addServiceRow("Cardiology", "4G", stmt);
            addServiceRow("Doherty Conference Room", "4th Floor", stmt);
            addServiceRow("Endocrinology", "4G", stmt);
            addServiceRow("Gastroenterology", "4G", stmt);
            addServiceRow("Gastroenterology Associates", "4B", stmt);
            addServiceRow("Geriatrics/Senior Health", "4G", stmt);
            addServiceRow("Headache Center", "4H", stmt);
            addServiceRow("Hematology", "4G", stmt);
            addServiceRow("Infectious Diseases", "4F", stmt);
            addServiceRow("Interpreter Services", "4th Floor", stmt);
            addServiceRow("John R. Graham Headache Center", "4H", stmt);
            addServiceRow("Mary Ann Tynan Conference Rooms", "4th Floor", stmt);
            addServiceRow("Medical Library", "4th Floor", stmt);
            addServiceRow("Medical Records", "4th Floor", stmt);
            addServiceRow("Medical Specialties", "4G", stmt);
            addServiceRow("Men''s Health Center","4N", stmt);
            addServiceRow("Mohs and Dermatologic Surgery", "4J", stmt);
            addServiceRow("Neurology", "4H", stmt);
            addServiceRow("Neurology/Sleep Division", "4C", stmt);
            addServiceRow("Pulmonary", "4G", stmt);
            addServiceRow("Renal", "4G", stmt);
            addServiceRow("Rheumatology Center", "4D", stmt);
            addServiceRow("Sadowsky Conference Room", "4th Floor", stmt);
            addServiceRow("Saslow Conference Room", "4th Floor", stmt);
            addServiceRow("Social Work", "4th Floor", stmt);
            addServiceRow("Urology", "4N", stmt);


            // add all hospital provider data into table
            addProviderRow("Bachman, William", "MD", "4G", stmt);
            addProviderRow("Bernstein, Carolyn", "MD", "4H", stmt);
            addProviderRow("Bhasin, Shalender", "MD", "4N", stmt);
            addProviderRow("Bonaca, Marc", "MD", "4G", stmt);
            addProviderRow("Burch, Rebecca", "MD", "4H", stmt);
            addProviderRow("Caplan, Laura", "PA-C", "4A", stmt);
            addProviderRow("Cardet, Juan Carlos", "MD", "4G", stmt);
            addProviderRow("Cardin, Kristin", "NP", "4G", stmt);
            addProviderRow("Chan, Walter", "MD", "4G", stmt);
            addProviderRow("Clark, Roger", "DO", "4F", stmt);
            addProviderRow("Cochrane, Thomas", "MD", "4H", stmt);
            addProviderRow("Conant, Alene", "MD", "4B", stmt);
            addProviderRow("Connell, Nathan", "MD", "4G", stmt);
            addProviderRow("Copello, Maria", "MD", "4A", stmt);
            addProviderRow("Cua, Christopher", "MD", "4I", stmt);
            addProviderRow("D''Ambrosio, Carolyn", "MD", "4G", stmt);
            addProviderRow("Dave, Jatin", "MD", "4G", stmt);
            addProviderRow("Drewniak, Stephen", "MD", "4B", stmt);
            addProviderRow("Fanta, Christopher", "MD", "4G", stmt);
            addProviderRow("Friedman, Pamela", "PsyD, ABPP", "4H", stmt);
            addProviderRow("Goldman, Jill", "MD", "4S", stmt);
            addProviderRow("Healy, Barbara", "RN", "4A", stmt);
            addProviderRow("Hentschel, Dirk", "MD", "4G", stmt);
            addProviderRow("Homenko, Daria", "MD", "4B", stmt);
            addProviderRow("Hoover, Paul", "MD, PhD", "4D", stmt);
            addProviderRow("Hsu, Joyce", "MD", "4G", stmt);
            addProviderRow("Kathrins, Martin", "MD", "4N", stmt);
            addProviderRow("Lahive, Karen", "MD", "4I", stmt);
            addProviderRow("Lauretti, Linda", "MD", "4A", stmt);
            addProviderRow("Lilienfeld, Armin", "MD", "4S", stmt);
            addProviderRow("Lilly, Leonard Stuart", "MD", "4G", stmt);
            addProviderRow("Lo, Amy", "MD", "4B", stmt);
            addProviderRow("Loder, Elizabeth", "MD", "4H", stmt);
            addProviderRow("Malone, Michael", "MD", "4N", stmt);
            addProviderRow("Mathew, Paul", "MD", "4H", stmt);
            addProviderRow("Matloff, Daniel", "MD", "4B", stmt);
            addProviderRow("McDonald, Michael", "MD", "4N", stmt);
            addProviderRow("McGowan, Katherine", "MD", "4F", stmt);
            addProviderRow("McMahon, Gearoid", "MD", "4G", stmt);
            addProviderRow("McNabb-Balter, Julia", "MD", "4B", stmt);
            addProviderRow("Mullally, William", "MD", "4C", stmt);
            addProviderRow("Mutinga, Muthoka", "MD", "4B", stmt);
            addProviderRow("Novak, Peter", "MD", "4C", stmt);
            addProviderRow("O''Leary, Michael", "MD", "4N", stmt);
            addProviderRow("Oliver, Lynn", "RN", "4A", stmt);
            addProviderRow("Owens, Lisa Michelle", "MD", "4S", stmt);
            addProviderRow("Pariser, Kenneth", "MD", "4D", stmt);
            addProviderRow("Parnes, Aric", "MD", "4G", stmt);
            addProviderRow("Pilgrim, David", "MD", "4C", stmt);
            addProviderRow("Preneta, Ewa", "MD", "4B", stmt);
            addProviderRow("Ramirez, Alberto", "MD", "4G", stmt);
            addProviderRow("Rizzoli, Paul", "MD", "4H", stmt);
            addProviderRow("Romano, Keith", "MD", "4G", stmt);
            addProviderRow("Ruff, Christian", "MD", "4G", stmt);
            addProviderRow("Ruiz, Emily", "MD", "4J", stmt);
            addProviderRow("Saldana, Fidencio", "MD", "4G", stmt);
            addProviderRow("Schissel, Scott", "MD", "4G", stmt);
            addProviderRow("Schmults, Chrysalyne", "MD", "4J", stmt);
            addProviderRow("Shah, Amil", "MD", "4G", stmt);
            addProviderRow("Sheth, Samira", "NP", "4G", stmt);
            addProviderRow("Smith, Benjamin", "MD", "4B", stmt);
            addProviderRow("Steele, Graeme", "MD", "4N", stmt);
            addProviderRow("Sweeney, Michael", "MD", "4G", stmt);
            addProviderRow("Tarpy, Robert", "MD", "4I", stmt);
            addProviderRow("Todd, Derrick", "MD, PhD", "4D", stmt);
            addProviderRow("Tucker, Kevin", "MD", "4G", stmt);
            addProviderRow("Vardeh, Daniel", "MD", "4C", stmt);
            addProviderRow("Voiculescu, Adina", "MD", "4G", stmt);
            addProviderRow("Waldman, Abigail", "MD", "4J", stmt);
            addProviderRow("Walsh Samp, Kathy", "LICSW", "4A", stmt);
            addProviderRow("Weisholtz, Daniel", "MD", "4C", stmt);
            addProviderRow("Welker, Roy", "MD", "4A", stmt);
            addProviderRow("Whitman, Gregory", "MD", "4C", stmt);
            addProviderRow("Wickner, Paige", "MD", "4G", stmt);


            System.out.println("\nRetrieving new data...");
            rsS = stmt.executeQuery(strS);
            rsP = stmt.executeQuery(strP);
            printAllServicesRows(rsS);
            printAllProvidersRows(rsP);

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
                // Drop the Hospital Service table.
                String strS = "DROP TABLE " + HospitalServicesSchema.HospitalServicesTable.NAME;
                stmt.execute(strS); //check HospitalServices table
                System.out.println("HospitalServices table dropped.");

                // Drop the Hospital Provider table
                String strP = "DROP TABLE " + HospitalProvidersSchema.HospitalProvidersTable.NAME;
                stmt.execute(strP); //check HospitalProviders table
                System.out.println("HospitalProviders table dropped.");
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
            String str = "CREATE TABLE " + HospitalServicesSchema.HospitalServicesTable.NAME + "(" +
                    HospitalServicesSchema.HospitalServicesTable.Cols.NAME + " VARCHAR(50) NOT NULL PRIMARY KEY, " +
                    HospitalServicesSchema.HospitalServicesTable.Cols.LOCATION + " VARCHAR(20) )";
            stmt.execute(str);

            // Add row to table
            addServiceRow("Allergy ", "4G", stmt);

            System.out.println("HospitalServices table created and populated.");

            // Create HospitalProvider table.
            String strP = "CREATE TABLE " + HospitalProvidersSchema.HospitalProvidersTable.NAME + "(" +
                    HospitalProvidersSchema.HospitalProvidersTable.Cols.NAME + " VARCHAR(50) NOT NULL PRIMARY KEY, " +
                    HospitalProvidersSchema.HospitalProvidersTable.Cols.TITLE + " VARCHAR(50) NOT NULL, " +
                    HospitalProvidersSchema.HospitalProvidersTable.Cols.LOCATION + " VARCHAR(20) )";
            stmt.execute(strP);

            // Add row to table
            addProviderRow("Ash, Samuel", "MD", "4G", stmt);

            System.out.println("HospitalProviders table created and populated.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void addServiceRow(String name, String location, Statement stmt){
        String str = "INSERT INTO " + HospitalServicesSchema.HospitalServicesTable.NAME + " VALUES (" +
                "'" + name + "', '" + location + "')";
        try {
            stmt.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addProviderRow(String name, String title, String location, Statement stmt){
        String str = "INSERT INTO " + HospitalProvidersSchema.HospitalProvidersTable.NAME + " VALUES (" +
                "'" + name + "', '" + title + "','" + location + "')";
        try {
            stmt.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> printAllServicesRows(ResultSet rs){
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

    public static List<String> printAllProvidersRows(ResultSet rs){
        ArrayList<String> strArray = new ArrayList<String>();

        try {
            //iterate through result, printing out values of each row and storing each row in a list of Strings
            while (rs.next()) {
                String temp = "Name: " + rs.getString(HospitalProvidersSchema.HospitalProvidersTable.Cols.NAME) +
                        " --- Title: " + rs.getString(HospitalProvidersSchema.HospitalProvidersTable.Cols.TITLE) +
                        " --- Location: " + rs.getString(HospitalProvidersSchema.HospitalProvidersTable.Cols.LOCATION);
                System.out.println(temp);
                strArray.add(temp);
            }
        } catch (Exception e){

        }
        return strArray;
    }
}

