package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.BeforeClass;

import de.metalcon.domain.MuidType;

public class InstrumentUrlDataTest extends EntityUrlDataTest {

    protected InstrumentUrlData instrument;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.INSTRUMENT;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testMuidValid() {
        instrument = new InstrumentUrlData(VALID_MUID, VALID_NAME);
        testEntityValid(instrument);
    }

    @Override
    public void testMuidNull() {
        instrument = new InstrumentUrlData(null, VALID_NAME);
    }

    @Override
    public void testMuidTypeInvalid() {
        instrument = new InstrumentUrlData(INVALID_MUID, VALID_NAME);
    }

    @Override
    public void testNameNull() {
        instrument = new InstrumentUrlData(VALID_MUID, null);
    }

}
