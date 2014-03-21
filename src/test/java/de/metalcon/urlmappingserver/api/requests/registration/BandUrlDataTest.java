package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.BeforeClass;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

public class BandUrlDataTest extends EntityUrlDataTest {

    public static final BandUrlData VALID_BAND = new BandUrlData(
            Muid.create(MuidType.BAND), VALID_NAME);

    protected BandUrlData band;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.BAND;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityFull() {
        band = new BandUrlData(VALID_MUID, VALID_NAME);
        testEntityValid(band);
    }

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
