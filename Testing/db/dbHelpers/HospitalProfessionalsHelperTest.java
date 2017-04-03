package db.dbHelpers;

import db.Driver;
import db.dbClasses.HospitalProfessional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by sam on 4/3/17.
 */
public class HospitalProfessionalsHelperTest {
    //Gets the Helper
    HospitalProfessionalsHelper hs = Driver.getHospitalProfessionalHelper();
    //Create instances of HosptitalProvider
    HospitalProfessional newProv1 = new HospitalProfessional("Gates, William", "CEO", "Room 404");
    HospitalProfessional newProv2 = new HospitalProfessional("Jobs, Steve", "CTO", "Room 303");
    HospitalProfessional newProv3 = new HospitalProfessional("Balboa, Rocky", "Secretary", "Front Desk");
    HospitalProfessional newProv4 = new HospitalProfessional("Eastwood, Clint", "Janitor", "Room 17");
    HospitalProfessional newProv5 = new HospitalProfessional("Skywalker, Luke", "Lunch Lady", "Cafeteria");
    HospitalProfessional compProv5 = new HospitalProfessional("B", "C", "A");
    HospitalProfessional newProv6 = new HospitalProfessional("Vader, Darth", "Lord", "Deathstar");

    //Init
    public HospitalProfessionalsHelperTest() {
        hs.addHospitalProfessional(newProv1);
        hs.addHospitalProfessional(newProv2);
        hs.addHospitalProfessional(newProv3);
        hs.addHospitalProfessional(newProv4);
        hs.addHospitalProfessional(newProv5);
        hs.addHospitalProfessional(compProv5);
        hs.addHospitalProfessional(newProv6);
    }

    //Tests
    @Test
    public void test1() {
        assertEquals(newProv1, hs.getHospitalProfessional(newProv1.getId()));
    }

    //Testing trying to access a Provider not in the DB
    @Test
    public void distanceTo() throws Exception {
        assertNull(hs.getHospitalProfessional(newProv2.getId()));
    }

    //Changed name of a Provider in the DB
    @Test
    public void test3() {
        newProv3.setName("Drago, Ivan");
        hs.updateHospitalProfessional(newProv1);
        assertEquals("Drago, Ivan", (hs.getHospitalProfessional(newProv3.getId())).getName());
    }

    //Changed name of a Provider but did not update the DB, should return name of original
    @Test
    public void test4() {
        newProv4.setName("Dirty Harry");
        assertEquals("Eastwood, Clint", (hs.getHospitalProfessional(newProv4.getId())).getName());
    }

    //Compares a Provider that has had it's fields changed to appear similar to another Provider
    @Test
    public void test5() {
        newProv5.setLocation("A");
        newProv5.setName("B");
        newProv5.setTitle("C");
        hs.updateHospitalProfessional(newProv5);
        assertNotEquals(compProv5, hs.getHospitalProfessional(newProv5.getId()));
    }

    //Add and remove a Provider from the DB and then check to see if still present
    @Test
    public void test6() {
        hs.deleteHospitalProfessional(newProv6);
        assertNull(hs.getHospitalProfessional(newProv6.getId()));
    }

    //Add a Provider and then check the size of the DB
    @Test
    public void test7() {
        ArrayList<HospitalProfessional> initlist = hs.getHospitalProfessionals(null);
        int initSize = initlist.size();
        HospitalProfessional newProv7 = new HospitalProfessional("Potter, Harry", "Student", "Cupboard");
        hs.addHospitalProfessional(newProv7);
        ArrayList<HospitalProfessional> addlist = hs.getHospitalProfessionals(null);
        int addSize = addlist.size();
        assertEquals(initSize+1, addSize);
    }

    //Add and remove a Provider from the DB and then check to see if still present
    @Test
    public void test8() {
        HospitalProfessional newProv8 = new HospitalProfessional("Potter, Harry", "Student", "Cupboard");
        hs.addHospitalProfessional(newProv8);
        ArrayList<HospitalProfessional> initlist = hs.getHospitalProfessionals(null);
        int initSize = initlist.size();
        hs.deleteHospitalProfessional(newProv8);
        ArrayList<HospitalProfessional> remlist = hs.getHospitalProfessionals(null);
        int remSize = remlist.size();
        assertEquals(initSize-1, remSize);
    }

}

