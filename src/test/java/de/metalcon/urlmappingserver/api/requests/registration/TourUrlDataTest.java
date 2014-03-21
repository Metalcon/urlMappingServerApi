package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.MuidType;

public class TourUrlDataTest extends EntityUrlDataTest {

    protected static final int VALID_YEAR = Calendar.getInstance().get(
            Calendar.YEAR);

    protected TourUrlData tour;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.TOUR;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testMuidValid() {
        tour = new TourUrlData(VALID_MUID, VALID_NAME, VALID_YEAR);
        testEntityValid(tour);
        assertEquals(VALID_YEAR, tour.getYear());
    }

    @Override
    public void testMuidNull() {
        tour = new TourUrlData(null, VALID_NAME, VALID_YEAR);
    }

    @Override
    public void testMuidTypeInvalid() {
        tour = new TourUrlData(INVALID_MUID, VALID_NAME, VALID_YEAR);
    }

    @Override
    public void testNameNull() {
        tour = new TourUrlData(VALID_MUID, null, VALID_YEAR);
    }

    @Test
    public void testYearZero() {
        tour = new TourUrlData(VALID_MUID, VALID_NAME, 0);
        testEntityValid(tour);
        assertEquals(0, tour.getYear());
    }

}
