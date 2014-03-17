package de.metalcon.urlmappingserver.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class ZeroMQSerializationTest {

    private static final String FIELD_NAME_OBJECT = "object";

    private static final JSONObject FIELD_VALUE_OBJECT = new JSONObject();

    private static final String FIELD_NAME_STRING = "string";

    private static final String FIELD_VALUE_STRING = "myTestString";

    private JSONObject object;

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() {
        object = new JSONObject();
        FIELD_VALUE_OBJECT.put(FIELD_NAME_STRING, FIELD_VALUE_STRING);

        object.put(FIELD_NAME_OBJECT, FIELD_VALUE_OBJECT);
        object.put(FIELD_NAME_STRING, FIELD_VALUE_STRING);
    }

    @Test
    public void testObjectEquals() {
        assertTrue(FIELD_VALUE_OBJECT.equals(ZeroMQSerialization.Helper
                .getObject(FIELD_NAME_OBJECT, object)));
    }

    @Test
    public void testObjectMissing() {
        object.remove(FIELD_NAME_OBJECT);
        assertNull(ZeroMQSerialization.Helper.getObject(FIELD_NAME_OBJECT,
                object));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testObjectNull() {
        object.put(FIELD_NAME_OBJECT, null);
        assertNull(ZeroMQSerialization.Helper.getObject(FIELD_NAME_OBJECT,
                object));
    }

    @Test
    public void testStringEquals() {
        assertEquals(FIELD_VALUE_STRING,
                ZeroMQSerialization.Helper.getString(FIELD_NAME_STRING, object));
    }

    @Test
    public void testStringMissing() {
        object.remove(FIELD_NAME_STRING);
        assertNull(ZeroMQSerialization.Helper.getString(FIELD_NAME_STRING,
                object));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testStringNull() {
        object.put(FIELD_NAME_STRING, null);
        assertNull(ZeroMQSerialization.Helper.getString(FIELD_NAME_STRING,
                object));
    }

}
