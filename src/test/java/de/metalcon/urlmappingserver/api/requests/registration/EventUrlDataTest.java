package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.UidType;

public class EventUrlDataTest extends EntityUrlDataTest {

    protected EventUrlData event;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = UidType.EVENT;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity = new EventUrlData(VALID_MUID);
        super.testEntityNotEmpty();
    }

    @Override
    public void testEntityFull() {
        event = new EventUrlData(VALID_MUID);
        testEntityValid(event);
    }

    @Override
    public void testMuidNull() {
        event = new EventUrlData(null);
    }

    @Override
    public void testUidTypeInvalid() {
        event = new EventUrlData(INVALID_MUID);
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
