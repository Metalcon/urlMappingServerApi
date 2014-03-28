package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.MuidType;
import de.metalcon.testing.MuidFactory;

public class BandUrlDataTest extends EntityUrlDataTest {

    public static final BandUrlData VALID_BAND = new BandUrlData(
            MuidFactory.generateMuid(MuidType.BAND), VALID_NAME);

    protected static final BandUrlData EMPTY_BAND = new BandUrlData();

    protected BandUrlData band;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.BAND;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity = VALID_BAND;
        super.testEntityNotEmpty();
    }

    @Test
    public void testEntityEmpty() {
        entity = EMPTY_BAND;
        assertTrue(entity.hasEmptyMuid());
        assertNull(entity.getName());
    }

    @Override
    public void testEntityFull() {
        band = new BandUrlData(VALID_MUID, VALID_NAME);
        testEntityValid(band);
    }

    @Test
    @Override
    public void testMuidNull() {
        band = new BandUrlData(null, VALID_NAME);
    }

    @Override
    public void testMuidTypeInvalid() {
        band = new BandUrlData(INVALID_MUID, VALID_NAME);
    }

    @Override
    public void testNameNull() {
        band = new BandUrlData(VALID_MUID, null);
    }

}
