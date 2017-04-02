/**
 * Created by Sam Coache on 4/2/17.
 */

import db.Driver;
import db.HospitalProvider;
import db.dbHelper.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.ArrayList;

public class dbtesting {
    //Create an instance of HospitalServicesHelper
    HospitalProvidersHelper hs = Driver.getHospitalProviderHelper();

    //Create instances of HosptitalProvider
    HospitalProvider newProv1 = new HospitalProvider("Gates, William", "CEO", "Room 404");
    HospitalProvider newProv2 = new HospitalProvider("Jobs, Steve", "CTO", "Room 303");
    HospitalProvider newProv3 = new HospitalProvider("Balboa, Rocky", "Secretary", "Front Desk");
    HospitalProvider newProv4 = new HospitalProvider("Eastwood, Clint", "Janitor", "Room 17");
    HospitalProvider newProv5 = new HospitalProvider("Skywalker, Luke", "Lunch Lady", "Cafeteria");
    HospitalProvider compProv5 = new HospitalProvider("B", "C", "A");
    HospitalProvider newProv6 = new HospitalProvider("Vader, Darth", "Lord", "Deathstar");

    //Class to edit the DB
    public dbtesting(){
        //Test 1
        hs.addHospitalProvider(newProv1);
        //Test 2
        hs.addHospitalProvider(newProv2);
        //Test 3
        hs.addHospitalProvider(newProv3);
        newProv3.setName("Drago, Ivan");
        hs.updateHospitalProvider(newProv1);
        //Test 4
        hs.addHospitalProvider(newProv4);
        newProv4.setName("Dirty Harry");
        //Test 5
        hs.addHospitalProvider(newProv5);
        hs.addHospitalProvider(compProv5);
        newProv5.setLocation("A");
        newProv5.setName("B");
        newProv5.setTitle("C");
        hs.updateHospitalProvider(newProv5);
        //Test 6
        hs.addHospitalProvider(newProv6);
        hs.deleteHospitalProvider(newProv6);
        //Test 7
        //Test 8
    }

    //Testing adding a new provider
    @Test
    public void test1() {
        assertEquals(newProv1, hs.getHospitalProvider(newProv1.getId()));
    }

    //Testing trying to access a Provider not in the DB
    @Test
    public void test2() {
        assertEquals(null, hs.getHospitalProvider(newProv2.getId()));
    }

    //Changed name of a Provider in the DB
    @Test
    public void test3() {
        assertEquals("Drago, Ivan", (hs.getHospitalProvider(newProv3.getId())).getName());
    }

    //Changed name of a Provider but did not update the DB, should return name of original
    @Test
    public void test4() {
        assertEquals("Eastwood, Clint", (hs.getHospitalProvider(newProv4.getId())).getName());
    }

    //Compares a Provider that has had it's fields changed to appear similar to another Provider
    @Test
    public void test5() {
        assertNotEquals(compProv5, hs.getHospitalProvider(newProv5.getId()));
    }

    //Add and remove a Provider from the DB and then check to see if still present
    @Test
    public void test6() {
        assertEquals(null, hs.getHospitalProvider(newProv6.getId()));
    }

    //Add a Provider and then check the size of the DB
    @Test
    public void test7() {
        ArrayList<HospitalProvider> initlist = hs.getHospitalProviders(null);
        int initSize = initlist.size();
        HospitalProvider newProv7 = new HospitalProvider("Potter, Harry", "Student", "Cupboard");
        hs.addHospitalProvider(newProv7);
        ArrayList<HospitalProvider> addlist = hs.getHospitalProviders(null);
        int addSize = addlist.size();
        assertEquals(initSize+1, addSize);
    }

    //Add and remove a Provider from the DB and then check to see if still present
    @Test
    public void test8() {
        HospitalProvider newProv8 = new HospitalProvider("Potter, Harry", "Student", "Cupboard");
        hs.addHospitalProvider(newProv8);
        ArrayList<HospitalProvider> initlist = hs.getHospitalProviders(null);
        int initSize = initlist.size();
        hs.deleteHospitalProvider(newProv8)
        ArrayList<HospitalProvider> remlist = hs.getHospitalProviders(null);
        int remSize = remlist.size();
        assertEquals(initSize-1, remSize);
    }

}

