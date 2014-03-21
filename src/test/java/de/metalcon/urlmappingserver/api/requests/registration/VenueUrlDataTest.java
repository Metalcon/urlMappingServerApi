package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

public class VenueUrlDataTest extends EntityUrlDataTest {

    protected static final CityUrlData VALID_CITY = CityUrlDataTest.VALID_CITY;

    public static final VenueUrlData VALID_VENUE = new VenueUrlData(
            Muid.create(MuidType.VENUE), VALID_NAME, VALID_CITY);

    protected VenueUrlData venue;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.VENUE;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testMuidValid() {
        venue = new VenueUrlData(VALID_MUID, VALID_NAME, VALID_CITY);
        testEntityValid(venue);
        assertNotNull(venue.getCity());
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
