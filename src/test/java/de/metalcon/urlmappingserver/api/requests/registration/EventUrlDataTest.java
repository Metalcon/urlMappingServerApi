package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import de.metalcon.domain.Muid;

public class EventUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(6);

    protected static CityUrlData VALID_CITY = new CityUrlData(
            CityUrlDataTest.VALID_MUID, VALID_NAME);

    protected static VenueUrlData VALID_VENUE = new VenueUrlData(
            VenueUrlDataTest.VALID_MUID, VALID_NAME,
            VenueUrlDataTest.VALID_CITY);

    protected EventUrlData event;

    @Before
    public void setUp() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_CITY,
                        VALID_VENUE);
        sourceEntity = event;
    }

    @Override
    public void serialize() {
        serObject = EventUrlData.serialize((EventUrlData) sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = EventUrlData.deserialize(deserObject);
    }

    @Test
    public void testDifferentCity() {
        process();
        event.city =
                new CityUrlData(new Muid(VALID_CITY.getMuid().getValue() + 10),
                        VALID_CITY.getName());
        serialize();
        System.out.println(serObject);
        assertNotNull(entity);
        assertFalse(sourceEntity.equals(entity));
    }

    @Test
    public void testDifferentVenue() {
        process();
        event.venue =
                new VenueUrlData(
                        new Muid(VALID_VENUE.getMuid().getValue() + 10),
                        VALID_VENUE.getName(), VALID_VENUE.getCity());
        serialize();
        System.out.println(serObject);
        assertNotNull(entity);
        assertFalse(sourceEntity.equals(entity));
    }
}
