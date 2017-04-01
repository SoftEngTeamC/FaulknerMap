package db.dbHelper;

import db.HospitalProvider;
import db.HospitalSchema.HospitalProviderSchema.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Gina on 3/31/17.
 */
public class HospitalProvidersHelper {

    private static HospitalProvidersHelper hospitalProvidersHelper;

    private Connection connection;
    private Statement statement;
    private ArrayList<HospitalProvider> originalList;

    /**
     * Initialize HospitalProvidersHelper if not already created
     * It is static since there is only one table
     *
     * @param connection
     * @return
     */
    public static HospitalProvidersHelper get(Connection connection) {

        if (hospitalProvidersHelper == null) {
            hospitalProvidersHelper = new HospitalProvidersHelper(connection);
        }
        return hospitalProvidersHelper;
    }

    /**
     * Constructor for HospitalProvidersHelper
     * Populates database if first time calling
     *
     * @param connection
     */
    private HospitalProvidersHelper(Connection connection) {
        this.connection = connection;

        try {
            statement = connection.createStatement();

            //check if table is empty
            if (getHospitalProviders(null) == null) {
                originalList = new ArrayList<>(); //initialize empty array and populate
                //populate table
                populateArray();
            }
        } catch (SQLException e) {
            System.out.println("Constructor error");
            e.printStackTrace();
        }
    }

    /**
     * Add a HospitalProvider to the database
     *
     * @param provider
     * @return success
     */
    public boolean addHospitalProvider(HospitalProvider provider) {
        //insert HospitalProvider into table
        String str = "INSERT INTO " + HospitalProviderTable.NAME + " VALUES (" +
                "'" + provider.getId().toString() + "', '" + provider.getName() + "', '" +
                provider.getTitle() + "', '" + provider.getLocation() + "')";
        try {
            statement.executeUpdate(str);
            return true;
        } catch (SQLException e) {
            System.out.println("Could not add HospitalProvider: " + provider.getName());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Function takes in edited HospitalProvider and updates it
     * @param provider HospitalProvider being updated
     * @return success
     */
    public boolean updateHospitalProvider(HospitalProvider provider) {
        //check table to make sure provider is already there
        HospitalProvider temp = getHospitalProvider(provider.getId());
        if (temp == null) { //could not find HospitalProvider to edit
            System.out.println("Could not find HospitalProvider " + provider.getName() + " to update");
            return false;
        } else {
            //updating
            String str = "UPDATE " + HospitalProviderTable.NAME + " SET " + HospitalProviderTable.Cols.NAME +
                    " = '" + provider.getName() + "', " + HospitalProviderTable.Cols.TITLE +
                    " = '" + provider.getTitle() + "', " + HospitalProviderTable.Cols.LOCATION +
                    " = '" + provider.getLocation() + "' WHERE " + HospitalProviderTable.Cols.ID + " = '" +
                    provider.getId().toString() + "'";
            try {
                //update was successful
                statement.executeUpdate(str);
                return true;
            } catch (SQLException e) {
                System.out.println("Could not update HospitalProvider: " + provider.getName());
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * Function that takes in a provider and deletes it from the database
     * @param provider HospitalProvider
     * @return success
     */
    public boolean deleteHospitalProvider(HospitalProvider provider) {
        //check table to make sure HospitalProvider is already there
        HospitalProvider temp = getHospitalProvider(provider.getId());
        if (temp == null) { //could not find HospitalProvider to edit
            System.out.println("Could not find HospitalProvider " + provider.getName() + " to delete");
            return false;
        } else {
            String str = "DELETE FROM " + HospitalProviderTable.NAME + " WHERE " +
                    HospitalProviderTable.Cols.ID + " = '" + provider.getId().toString() + "'";
            try {
                statement.execute(str);
                return true;
            } catch (SQLException e) {
                System.out.println("Could not delete HospitalProvider: " + provider.getName());
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * Function finds a HospitalProvider by id
     *
     * @param id ID of HospitalProvider
     * @return the HospitalProvider found or null if could not be found
     */
    public HospitalProvider getHospitalProvider(UUID id) {
        //query table for specific HospitalProvider
        String str = "SELECT * FROM " + HospitalProviderTable.NAME + " WHERE " +
                HospitalProviderTable.Cols.ID + " = '" + id.toString() + "'";
        try {
            ResultSet resultSet = statement.executeQuery(str);
            HospitalProvider tempProvider = null;
            while(resultSet.next()){
                tempProvider = new HospitalProvider(resultSet.getString(HospitalProviderTable.Cols.NAME),
                        resultSet.getString(HospitalProviderTable.Cols.TITLE),
                        resultSet.getString(HospitalProviderTable.Cols.LOCATION));
            }
            return tempProvider;
        } catch (SQLException e) {
            System.out.println("Could not select Hospital Provider with id: " + id.toString());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function takes in a order by clause and generates list of all HospitalProvider
     * if no order is needed, order gets set to null when called
     * Default sort if of name alphabetical order
     *
     * @param order
     * @return list of HospitalProviders
     */
    public ArrayList<HospitalProvider> getHospitalProviders(String order) {
        ArrayList<HospitalProvider> temp = new ArrayList<>();
        try {
            String str;
            if (order == null) {
                //query all HospitalProviders in table without order
                str = "SELECT * FROM " + HospitalProviderTable.NAME;
            } else {
                //query all HospitalProviders in table with order
                str = "SELECT * FROM " + HospitalProviderTable.NAME
                        + " ORDER BY " + order + " ASC";
            }
            ResultSet resultSet = statement.executeQuery(str);

            //iterate through result, printing out values of each row
            while (resultSet.next()) {
                //get HospitalProvider from resultSet
                HospitalProvider tempProvider = new HospitalProvider(resultSet.getString(HospitalProviderTable.Cols.NAME),
                        resultSet.getString(HospitalProviderTable.Cols.TITLE),
                        resultSet.getString(HospitalProviderTable.Cols.LOCATION));
                temp.add(tempProvider); //add to array
            }
        } catch (Exception e) {
            System.out.println("Could not get all HospitalProviders");
            e.printStackTrace();
        }

        return temp;
    }

    /**
     * Print entire table, used for testing
     */
    public void printAllProviderRows() {
        ArrayList<HospitalProvider> temp = getHospitalProviders(null);
        for (HospitalProvider provider : temp) {
            System.out.println("Name: " + provider.getName() +
                    ", " + provider.getTitle() +
                    " --- Location: " + provider.getLocation());
        }
    }

    /**
     * This function populates the originalList array of all providers from the Excel sheet on the 4th floor
     */
    private void populateArray() {
        //populate with originalList of providers
        System.out.println("\nStoring initial Hospital Providers");

        originalList.add(new HospitalProvider("Bachman, William", "MD", "4G"));
        originalList.add(new HospitalProvider("Bernstein, Carolyn", "MD", "4H"));
        originalList.add(new HospitalProvider("Bhasin, Shalender", "MD", "4N"));
        originalList.add(new HospitalProvider("Bonaca, Marc", "MD", "4G"));
        originalList.add(new HospitalProvider("Burch, Rebecca", "MD", "4H"));
        originalList.add(new HospitalProvider("Caplan, Laura", "PA-C", "4A"));
        originalList.add(new HospitalProvider("Cardet, Juan Carlos", "MD", "4G"));
        originalList.add(new HospitalProvider("Cardin, Kristin", "NP", "4G"));
        originalList.add(new HospitalProvider("Chan, Walter", "MD", "4G"));
        originalList.add(new HospitalProvider("Clark, Roger", "DO", "4F"));
        originalList.add(new HospitalProvider("Cochrane, Thomas", "MD", "4H"));
        originalList.add(new HospitalProvider("Conant, Alene", "MD", "4B"));
        originalList.add(new HospitalProvider("Connell, Nathan", "MD", "4G"));
        originalList.add(new HospitalProvider("Copello, Maria", "MD", "4A"));
        originalList.add(new HospitalProvider("Cua, Christopher", "MD", "4I"));
        originalList.add(new HospitalProvider("D''Ambrosio, Carolyn", "MD", "4G"));
        originalList.add(new HospitalProvider("Dave, Jatin", "MD", "4G"));
        originalList.add(new HospitalProvider("Drewniak, Stephen", "MD", "4B"));
        originalList.add(new HospitalProvider("Fanta, Christopher", "MD", "4G"));
        originalList.add(new HospitalProvider("Friedman, Pamela", "PsyD, ABPP", "4H"));
        originalList.add(new HospitalProvider("Goldman, Jill", "MD", "4S"));
        originalList.add(new HospitalProvider("Healy, Barbara", "RN", "4A"));
        originalList.add(new HospitalProvider("Hentschel, Dirk", "MD", "4G"));
        originalList.add(new HospitalProvider("Homenko, Daria", "MD", "4B"));
        originalList.add(new HospitalProvider("Hoover, Paul", "MD, PhD", "4D"));
        originalList.add(new HospitalProvider("Hsu, Joyce", "MD", "4G"));
        originalList.add(new HospitalProvider("Kathrins, Martin", "MD", "4N"));
        originalList.add(new HospitalProvider("Lahive, Karen", "MD", "4I"));
        originalList.add(new HospitalProvider("Lauretti, Linda", "MD", "4A"));
        originalList.add(new HospitalProvider("Lilienfeld, Armin", "MD", "4S"));
        originalList.add(new HospitalProvider("Lilly, Leonard Stuart", "MD", "4G"));
        originalList.add(new HospitalProvider("Lo, Amy", "MD", "4B"));
        originalList.add(new HospitalProvider("Loder, Elizabeth", "MD", "4H"));
        originalList.add(new HospitalProvider("Malone, Michael", "MD", "4N"));
        originalList.add(new HospitalProvider("Mathew, Paul", "MD", "4H"));
        originalList.add(new HospitalProvider("Matloff, Daniel", "MD", "4B"));
        originalList.add(new HospitalProvider("McDonald, Michael", "MD", "4N"));
        originalList.add(new HospitalProvider("McGowan, Katherine", "MD", "4F"));
        originalList.add(new HospitalProvider("McMahon, Gearoid", "MD", "4G"));
        originalList.add(new HospitalProvider("McNabb-Balter, Julia", "MD", "4B"));
        originalList.add(new HospitalProvider("Mullally, William", "MD", "4C"));
        originalList.add(new HospitalProvider("Mutinga, Muthoka", "MD", "4B"));
        originalList.add(new HospitalProvider("Novak, Peter", "MD", "4C"));
        originalList.add(new HospitalProvider("O''Leary, Michael", "MD", "4N"));
        originalList.add(new HospitalProvider("Oliver, Lynn", "RN", "4A"));
        originalList.add(new HospitalProvider("Owens, Lisa Michelle", "MD", "4S"));
        originalList.add(new HospitalProvider("Pariser, Kenneth", "MD", "4D"));
        originalList.add(new HospitalProvider("Parnes, Aric", "MD", "4G"));
        originalList.add(new HospitalProvider("Pilgrim, David", "MD", "4C"));
        originalList.add(new HospitalProvider("Preneta, Ewa", "MD", "4B"));
        originalList.add(new HospitalProvider("Ramirez, Alberto", "MD", "4G"));
        originalList.add(new HospitalProvider("Rizzoli, Paul", "MD", "4H"));
        originalList.add(new HospitalProvider("Romano, Keith", "MD", "4G"));
        originalList.add(new HospitalProvider("Ruff, Christian", "MD", "4G"));
        originalList.add(new HospitalProvider("Ruiz, Emily", "MD", "4J"));
        originalList.add(new HospitalProvider("Saldana, Fidencio", "MD", "4G"));
        originalList.add(new HospitalProvider("Schissel, Scott", "MD", "4G"));
        originalList.add(new HospitalProvider("Schmults, Chrysalyne", "MD", "4J"));
        originalList.add(new HospitalProvider("Shah, Amil", "MD", "4G"));
        originalList.add(new HospitalProvider("Sheth, Samira", "NP", "4G"));
        originalList.add(new HospitalProvider("Smith, Benjamin", "MD", "4B"));
        originalList.add(new HospitalProvider("Steele, Graeme", "MD", "4N"));
        originalList.add(new HospitalProvider("Sweeney, Michael", "MD", "4G"));
        originalList.add(new HospitalProvider("Tarpy, Robert", "MD", "4I"));
        originalList.add(new HospitalProvider("Todd, Derrick", "MD, PhD", "4D"));
        originalList.add(new HospitalProvider("Tucker, Kevin", "MD", "4G"));
        originalList.add(new HospitalProvider("Vardeh, Daniel", "MD", "4C"));
        originalList.add(new HospitalProvider("Voiculescu, Adina", "MD", "4G"));
        originalList.add(new HospitalProvider("Waldman, Abigail", "MD", "4J"));
        originalList.add(new HospitalProvider("Walsh Samp, Kathy", "LICSW", "4A"));
        originalList.add(new HospitalProvider("Weisholtz, Daniel", "MD", "4C"));
        originalList.add(new HospitalProvider("Welker, Roy", "MD", "4A"));
        originalList.add(new HospitalProvider("Whitman, Gregory", "MD", "4C"));
        originalList.add(new HospitalProvider("Wickner, Paige", "MD", "4G"));

        populateTable(originalList); //put array in database now
    }

    /**
     * This function populates the database table from the array
     * @param list
     */
    public void populateTable(ArrayList<HospitalProvider> list) {
        dropTable();
        buildTable();

        for (HospitalProvider provider : list) {
            addHospitalProvider(provider);
        }
    }

    /**
     * dropTable checks that the db doesn't already exist, and if so drops all tables
     */
    private void dropTable() {
        System.out.println("Checking for existing tables.");
        try {
            statement = connection.createStatement(); //Statement object
            try {
                // Drop the HospitalProvider table.
                String str = "DROP TABLE " + HospitalProviderTable.NAME;
                statement.execute(str); //check HospitalProviders table
                System.out.println("HospitalProviders table dropped.");
            } catch (SQLException ex) {
                //Table did not exist
            }
        } catch (SQLException e) {
            System.out.println("Could not drop HospitalProviders table");
            e.printStackTrace();
        }
    }

    /**
     * This is the function that will create all tables in our database
     */
    private void buildTable() {
        try {
            statement = connection.createStatement(); //Statement object

            // Create HospitalProvider table.
            String str = "CREATE TABLE " + HospitalProviderTable.NAME + "(" +
                    HospitalProviderTable.Cols.ID + " CHAR(100) NOT NULL PRIMARY KEY, " +
                    HospitalProviderTable.Cols.NAME + " VARCHAR(50) NOT NULL PRIMARY KEY, " +
                    HospitalProviderTable.Cols.TITLE + " VARCHAR(50) NOT NULL, " +
                    HospitalProviderTable.Cols.LOCATION + " VARCHAR(20) )";

            statement.execute(str);

            System.out.println("HospitalProvider table created.");
        } catch (SQLException e) {
            System.out.println("Could not build HospitalProvider table");
            e.printStackTrace();
        }
    }
}