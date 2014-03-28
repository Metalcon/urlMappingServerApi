package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.MuidType;
import de.metalcon.testing.MuidFactory;

public class VenueUrlDataTest extends EntityUrlDataTest {

    protected static final CityUrlData VALID_CITY = new CityUrlData(
            MuidFactory.generateMuid(MuidType.CITY),
            CityUrlDataTest.VALID_CITY.getName());

    public static final VenueUrlData VALID_VENUE = new VenueUrlData(
            MuidFactory.generateMuid(MuidType.VENUE), VALID_NAME, VALID_CITY);

    protected VenueUrlData venue;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.VENUE;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity = new VenueUrlData(VALID_MUID, VALID_NAME, VALID_CITY);
        super.testEntityNotEmpty();
    }

    @Override
    public void testEntityFull() {
        venue = new VenueUrlData(VALID_MUID, VALID_NAME, VALID_CITY);
        testEntityValid(venue);
        assertEquals(VALID_CITY, venue.getCity());
    }

    @Override
    public void testMuidNull() {
        venue = new VenueUrlData(null, VALID_NAME, VALID_CITY);
    }

    @Override
    public void testMuidTypeInvalid() {
        venue = new VenueUrlData(INVALID_MUID, VALID_NAME, VALID_CITY);
    }

    @Override
    public void testNameNull() {
        venue = new VenueUrlData(VALID_MUID, null, VALID_CITY);
    }

    @Test
    public void testCityNull() {
        venue = new VenueUrlData(VALID_MUID, VALID_NAME, null);
        testEntityValid(venue);
        assertNull(venue.getCity());
    }

}
