package db;

/**
 * Created by Gina on 3/27/17.
 */
/*
    This class holds all the database column names of the table HospitalServices
    Using this class helps prevent typos/mistakes when calling the database
 */
class HospitalServicesSchema {
    static final class HospitalServicesTable {
        static final String NAME = "hospitalServices";

        static final class Cols {
            static final String NAME = "name";
            static final String LOCATION = "location";
        }
    }
}
