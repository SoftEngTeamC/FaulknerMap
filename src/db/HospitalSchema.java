package db;

/**
 * Created by Gina on 3/27/17.
 */
/*
    This class holds all the database column names of the tables in hospital
    Using this class helps prevent typos/mistakes when calling the database
 */

class HospitalSchema {

    // Hospital service
    class HospitalServicesSchema {
        final class HospitalServicesTable {
            static final String NAME = "hospitalServices";

            final class Cols {
                static final String NAME = "name";
                static final String LOCATION = "location";
            }
        }
    }

    // Providers == professionals
    class HospitalProvidersSchema {
        final class HospitalProvidersTable {
            static final String NAME = "hospitalProviders";

            final class Cols {
                static final String NAME = "name";
                static final String TITLE = "title";
                static final String LOCATION = "location";
            }
        }
    }
}