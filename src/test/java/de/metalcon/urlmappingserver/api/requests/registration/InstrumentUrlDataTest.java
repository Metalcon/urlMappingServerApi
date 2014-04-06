package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.BeforeClass;

import de.metalcon.domain.UidType;

public class InstrumentUrlDataTest extends EntityUrlDataTest {

    protected InstrumentUrlData instrument;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = UidType.INSTRUMENT;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity = new InstrumentUrlData(VALID_MUID, VALID_NAME);
        super.testEntityNotEmpty();
    }

    @Override
    public void testEntityFull() {
        instrument = new InstrumentUrlData(VALID_MUID, VALID_NAME);
        testEntityValid(instrument);
    }

    @Override
    public void testMuidNull() {
        instrument = new InstrumentUrlData(null, VALID_NAME);
    }

    @Override
    public void testUidTypeInvalid() {
        instrument = new InstrumentUrlData(INVALID_MUID, VALID_NAME);
    }

    @Override
    public void testNameNull() {
        instrument = new InstrumentUrlData(VALID_MUID, null);
    }

}
