package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import de.metalcon.domain.Muid;

public abstract class EntityUrlDataTest {

    private static JSONParser PARSER = new JSONParser();

    protected static Muid INVALID_MUID = new Muid(0);

    protected static final String VALID_NAME = "Testy";

    protected EntityUrlData sourceEntity;

    protected String serObject;

    protected JSONObject deserObject;

    protected EntityUrlData entity;

    abstract protected void serialize();

    abstract protected void deserialize();

    protected void process() {
        serialize();
        System.out.println(serObject);
        try {
            deserObject = (JSONObject) PARSER.parse(serObject);
        } catch (ParseException e) {
            e.printStackTrace();
            fail("serialized object malformed JSON");
        }
        deserialize();
    }

    protected void testEntitiesNotEqual() {
        serialize();
        System.out.println(serObject);
        assertNotNull(entity);
        assertFalse(sourceEntity.equals(entity));
    }

    @Test
    public void testEntitiesEqual() {
        process();
        assertEquals(sourceEntity, entity);
    }

    @Test
    public void testInvalidMuid() {
        sourceEntity.muid = INVALID_MUID;
        process();
        if (entity.getMuid() != null) {
            System.out.println("ok");
        }
        assertNull(entity.getMuid());
    }
}
