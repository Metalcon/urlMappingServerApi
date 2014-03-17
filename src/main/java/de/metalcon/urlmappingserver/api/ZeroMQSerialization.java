package de.metalcon.urlmappingserver.api;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.requests.registration.BandUrlData;

/**
 * JSON fields for entity ZeroMQ serialization
 * 
 * @author sebschlicht
 * 
 */
public class ZeroMQSerialization {

    private static final SimpleDateFormat DATE_FORMATTER =
            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private static ObjectMapper MAPPER = new ObjectMapper();

    private static JsonSchemaGenerator SCHEMA_GENERATOR =
            new JsonSchemaGenerator(MAPPER);

    private static JsonSchemaFactory SCHEMA_FACTORY = JsonSchemaFactory
            .byDefault();

    private static HashMap<String, com.github.fge.jsonschema.main.JsonSchema> REGISTERED_SCHEMES =
            new HashMap<String, com.github.fge.jsonschema.main.JsonSchema>();

    public static JsonSchema generateScheme(
            final Class<? extends Object> serializationClass)
            throws JsonMappingException {
        return SCHEMA_GENERATOR.generateSchema(serializationClass);
    }

    public static void registerSchema(
            final Class<? extends Object> serializationClass,
            final JsonSchema schema) {
        try {
            final String schemaValue = MAPPER.writeValueAsString(schema);
            final JsonNode schemaNode = MAPPER.readTree(schemaValue);
            final com.github.fge.jsonschema.main.JsonSchema validationSchema =
                    SCHEMA_FACTORY.getJsonSchema(schemaNode);
            REGISTERED_SCHEMES.put(serializationClass.getName(),
                    validationSchema);
        } catch (final JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String serialize(Object object)
            throws JsonProcessingException {
        return MAPPER.writeValueAsString(object);
    }

    public static Object deserialize(
            String serializedObject,
            Class<? extends Object> serializationClass) {
        try {
            final JsonNode node = MAPPER.readTree(serializedObject);
            if (REGISTERED_SCHEMES.get(serializationClass.getName())
                    .validInstance(node)) {
                return MAPPER.readValue(serializedObject, serializationClass);
            }
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws JsonProcessingException {
        JsonSchema bandSchema = generateScheme(BandUrlData.class);
        System.out.println(MAPPER.writerWithDefaultPrettyPrinter()
                .writeValueAsString(bandSchema));
        System.out.println();
        BandUrlData band = new BandUrlData(new Muid(2), "myBand");
        String serializedBand = serialize(band);
        System.out.println(serializedBand);
        System.out.println();
        registerSchema(BandUrlData.class, bandSchema);
        BandUrlData band2 =
                (BandUrlData) deserialize(serializedBand, BandUrlData.class);
        System.out.println(serialize(band2));
    }

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

        public static String parseInteger(int value) {
            return String.valueOf(value);
        }

        public static Integer getInteger(String key, JSONObject object) {
            return Integer.valueOf(getString(key, object));
        }

        public static Long getLong(String key, JSONObject object) {
            return Long.valueOf(getString(key, object));
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
