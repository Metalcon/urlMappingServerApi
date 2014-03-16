package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import de.metalcon.domain.Muid;

public class VenueUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(5);

    public static CityUrlData VALID_CITY = new CityUrlData(
            CityUrlDataTest.VALID_MUID, VALID_NAME);

    protected VenueUrlData venue;

    @Before
    public void setUp() {
        venue = new VenueUrlData(VALID_MUID, VALID_NAME, VALID_CITY);
        sourceEntity = venue;
    }

    @Override
    public void serialize() {
        serObject = VenueUrlData.serialize((VenueUrlData) sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = VenueUrlData.deserialize(deserObject);
    }

    @Test
    public void testDifferentCity() {
        process();
        venue.city =
                new CityUrlData(new Muid(VALID_CITY.getMuid().getValue() + 10),
                        VALID_CITY.getName());
        assertNotNull(entity);
        assertFalse(sourceEntity.equals(entity));
    }
}
