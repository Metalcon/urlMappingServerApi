package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.UidType;

public class TourUrlDataTest extends EntityUrlDataTest {

    protected TourUrlData tour;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = UidType.TOUR;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity = new TourUrlData(VALID_MUID);
        super.testEntityNotEmpty();
    }

    @Override
    public void testEntityFull() {
        tour = new TourUrlData(VALID_MUID);
        testEntityValid(tour);
    }

    @Override
    public void testMuidNull() {
        tour = new TourUrlData(null);
    }

    @Override
    public void testUidTypeInvalid() {
        tour = new TourUrlData(INVALID_MUID);
    }

    @Test
    @Override
    public void testNameNull() {
        // allowed
    }

    @Override
    protected void testEntityValid(EntityUrlData entity) {
        assertNotNull(entity.getMuid());
    }

}
