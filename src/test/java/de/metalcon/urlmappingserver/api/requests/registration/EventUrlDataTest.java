package de.metalcon.urlmappingserver.api.requests.registration;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import de.metalcon.domain.Muid;

public class EventUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(6);

    protected static Date VALID_DATE = new Date(System.currentTimeMillis());

    protected static CityUrlData VALID_CITY = new CityUrlData(
            CityUrlDataTest.VALID_MUID, VALID_NAME);

    protected static VenueUrlData VALID_VENUE = new VenueUrlData(
            VenueUrlDataTest.VALID_MUID, VALID_NAME,
            VenueUrlDataTest.VALID_CITY);

    protected EventUrlData event;

    @Before
    public void setUp() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, VALID_VENUE);
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
    public void testDifferentDate() {
        process();
        event.date = new Date(System.currentTimeMillis() + 1);
        testEntitiesNotEqual();
    }

    @Test
    public void testDifferentCity() {
        process();
        event.city =
                new CityUrlData(new Muid(VALID_CITY.getMuid().getValue() + 10),
                        VALID_CITY.getName());
        testEntitiesNotEqual();
    }

    @Test
    public void testDifferentVenue() {
        process();
        event.venue =
                new VenueUrlData(
                        new Muid(VALID_VENUE.getMuid().getValue() + 10),
                        VALID_VENUE.getName(), VALID_VENUE.getCity());
        testEntitiesNotEqual();
    }
}
