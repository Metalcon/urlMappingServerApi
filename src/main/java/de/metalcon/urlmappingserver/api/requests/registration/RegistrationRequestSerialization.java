package de.metalcon.urlmappingserver.api.requests.registration;

public class RegistrationRequestSerialization {

    /**
     * name of the entity
     */
    public static final String NAME = "name";

    /**
     * entity MUID
     */
    public static final String MUID = "muid";

    /**
     * entity MUID fields
     * 
     * @author sebschlicht
     * 
     */
    public class Muid {

        /**
         * unique identifier
         */
        public static final String VALUE = "value";
    }

    public class Event {

        public static final String CITY = "city";

        public static final String VENUE = "venue";

        public static final String DATE = "date";
    }

    public class Venue {

        public static final String CITY = "city";
    }

    public class Record {

        public static final String BAND = "band";

        public static final String RELEASE_YEAR = "releaseYear";
    }

    public class Tour {

        public static final String YEAR = "year";
    }

    public class Track {

        public static final String BAND = "band";

        public static final String RECORD = "record";

        public static final String TRACK_NUMBER = "trackNumber";
    }

    public class User {

        public static final String FIRST_NAME = "firstName";

        public static final String LAST_NAME = "lastName";
    }
}
