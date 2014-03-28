package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.MuidType;
import de.metalcon.testing.MuidFactory;

public class EventUrlDataTest extends EntityUrlDataTest {

    private static final long CURRENT_MS = System.currentTimeMillis();

    protected static final Date VALID_DATE = new Date(CURRENT_MS - CURRENT_MS
            % 1000);

    protected static final CityUrlData VALID_CITY = CityUrlDataTest.VALID_CITY;

    protected static final VenueUrlData VALID_VENUE =
            VenueUrlDataTest.VALID_VENUE;

    protected static final VenueUrlData VALID_VENUE_WITHOUR_CITY =
            new VenueUrlData(MuidFactory.generateMuid(MuidType.VENUE),
                    VALID_VENUE.getName(), null);

    protected EventUrlData event;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.EVENT;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, VALID_VENUE);
        super.testEntityNotEmpty();
    }

    @Override
    public void testEntityFull() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, VALID_VENUE);
        testEntityValid(event);
        assertEquals(VALID_DATE, event.getDate());
        assertEquals(VALID_CITY, event.getCity());
        assertEquals(VALID_VENUE, event.getVenue());
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
        assertEquals(VALID_CITY, event.getCity());
        assertEquals(VALID_VENUE, event.getVenue());
    }

    @Test
    public void testCityNull() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE, null,
                        VALID_VENUE);
        testEntityValid(event);
        assertEquals(VALID_DATE, event.getDate());
        assertEquals(VALID_VENUE.getCity(), event.getCity());
        assertEquals(VALID_VENUE, event.getVenue());
    }

    @Test
    public void testCityNullVenueNull() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE, null, null);
        testEntityValid(event);
        assertEquals(VALID_DATE, event.getDate());
        assertNull(event.getCity());
        assertNull(event.getVenue());
    }

    @Test
    public void testCityNullVenueWithoutCity() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE, null,
                        VALID_VENUE_WITHOUR_CITY);
        testEntityValid(event);
        assertEquals(VALID_DATE, event.getDate());
        assertNull(event.getCity());
        assertEquals(VALID_VENUE_WITHOUR_CITY, event.getVenue());
    }

    @Test
    public void testVenueNull() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, null);
        testEntityValid(event);
        assertEquals(VALID_DATE, event.getDate());
        assertEquals(VALID_CITY, event.getCity());
        assertNull(event.getVenue());
    }

    @Test
    public void testVenueWithoutCity() {
        event =
                new EventUrlData(VALID_MUID, VALID_NAME, VALID_DATE,
                        VALID_CITY, VALID_VENUE_WITHOUR_CITY);
        testEntityValid(event);
        assertEquals(VALID_DATE, event.getDate());
        assertEquals(VALID_CITY, event.getCity());
        assertEquals(VALID_VENUE_WITHOUR_CITY, event.getVenue());
    }

}
