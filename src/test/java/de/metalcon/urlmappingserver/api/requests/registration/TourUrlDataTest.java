package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import de.metalcon.domain.Muid;

public class TourUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(0);

    protected static final int VALID_YEAR = 2014;

    protected TourUrlData tour;

    @Before
    public void setUp() {
        INVALID_MUID = new Muid(1);
        tour = new TourUrlData(VALID_MUID, VALID_NAME, VALID_YEAR);
        sourceEntity = tour;
    }

    @Override
    public void serialize() {
        serObject = TourUrlData.serialize((TourUrlData) sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = TourUrlData.deserialize(deserObject);
    }

    @Test
    public void testDifferentYear() {
        process();
        tour.year = VALID_YEAR - 1;
        assertNotNull(entity);
        assertFalse(sourceEntity.equals(entity));
    }
}
