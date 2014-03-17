package de.metalcon.urlmappingserver.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

/**
 * JSON fields for entity ZeroMQ serialization
 * 
 * @author sebschlicht
 * 
 */
public class ZeroMQSerialization {

    private static final SimpleDateFormat DATE_FORMATTER =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class Helper {

        private static Object getFieldValue(String key, JSONObject object) {
            return object.get(key);
        }

        /**
         * get JSON object
         * 
         * @param key
         *            JSON field name
         * @param object
         *            parental JSON object
         * @return JSON object with field name specified<br>
         *         <b>null</b> if field missing or null
         */
        public static JSONObject getObject(String key, JSONObject object) {
            return (JSONObject) getFieldValue(key, object);
        }

        /**
         * get String
         * 
         * @param key
         *            JSON field name
         * @param object
         *            parental JSON object
         * @return String with field name specified<br>
         *         <b>null</b> if field missing or null
         */
        public static String getString(String key, JSONObject object) {
            return (String) getFieldValue(key, object);
        }

        public static Integer getInteger(String key, JSONObject object) {
            return (int) (long) getLong(key, object);
        }

        public static Long getLong(String key, JSONObject object) {
            return (Long) getFieldValue(key, object);
        }

        public static String parseDate(Date date) {
            return DATE_FORMATTER.format(date);
        }

        public static Date getDate(String key, JSONObject object) {
            try {
                return DATE_FORMATTER.parse(getString(key, object));
            } catch (ParseException e) {
                return null;
            }
        }

    }

}
