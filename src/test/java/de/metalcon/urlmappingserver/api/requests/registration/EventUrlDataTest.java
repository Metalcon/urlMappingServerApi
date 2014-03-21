package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

public class EventUrlDataTest extends EntityUrlDataTest {

    protected static final Date VALID_DATE = new Date(
            System.currentTimeMillis());

    protected static final CityUrlData VALID_CITY = CityUrlDataTest.VALID_CITY;

    protected static final VenueUrlData VALID_VENUE =
            VenueUrlDataTest.VALID_VENUE;

    protected EventUrlData event;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.EVENT;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testMuidValid() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, VALID_VENUE);
        testEntityValid(event);
        assertNotNull(event.getDate());
        assertNotNull(event.getCity());
        assertNotNull(event.getVenue());
    }

    @Override
    public void testMuidNull() {
        event =
                new EventUrlData(null, VALID_NAME, VALID_DATE, VALID_CITY,
                        VALID_VENUE);
    }

    @Override
    public void testMuidTypeInvalid() {
        event =
                new EventUrlData(INVALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, VALID_VENUE);
    }

    @Override
    public void testNameNull() {
        event =
                new EventUrlData(VALID_MUID, null, VALID_DATE, VALID_CITY,
                        VALID_VENUE);
    }

    @Test
    public void testDateNull() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, null, VALID_CITY,
                        VALID_VENUE);
        testEntityValid(event);
        assertNull(event.getDate());
        assertNotNull(event.getCity());
        assertNotNull(event.getVenue());
    }

    @Test
    public void testCityNull() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE, null,
                        VALID_VENUE);
        testEntityValid(event);
        assertNotNull(event.getDate());
        assertNotNull(event.getCity());
        assertNotNull(event.getVenue());
    }

    @Test
    public void testCityNullVenueNull() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE, null, null);
        testEntityValid(event);
        assertNotNull(event.getDate());
        assertNull(event.getCity());
        assertNull(event.getVenue());
    }

    @Test
    public void testCityNullVenueWithoutCity() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE, null,
                        new VenueUrlData(Muid.create(MuidType.VENUE),
                                VALID_NAME, null));
        testEntityValid(event);
        assertNotNull(event.getDate());
        assertNull(event.getCity());
        assertNotNull(event.getVenue());
    }

    @Test
    public void testVenueNull() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, null);
        testEntityValid(event);
        assertNotNull(event.getDate());
        assertNotNull(event.getCity());
        assertNull(event.getVenue());
    }

    @Test
    public void testVenueWithoutCity() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, new VenueUrlData(
                                Muid.create(MuidType.VENUE), VALID_NAME, null));
        testEntityValid(event);
        assertNotNull(event.getDate());
        assertNotNull(event.getCity());
        assertNotNull(event.getVenue());
    }

}
