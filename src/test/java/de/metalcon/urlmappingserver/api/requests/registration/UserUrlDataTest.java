package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.UidType;

public class UserUrlDataTest extends EntityUrlDataTest {

    protected static final String VALID_LAST_NAME = "Testatum";

    protected UserUrlData user;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = UidType.USER;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity = new UserUrlData(VALID_MUID, VALID_NAME, VALID_LAST_NAME);
        super.testEntityNotEmpty();
    }

    @Override
    protected void testEntityValid(EntityUrlData entity) {
        assertEquals(VALID_MUID, entity.getMuid());
    }

    @Override
    public void testEntityFull() {
        user = new UserUrlData(VALID_MUID, VALID_NAME, VALID_LAST_NAME);
        testEntityValid(user);
        assertEquals(VALID_NAME, user.getFirstName());
        assertEquals(VALID_LAST_NAME, user.getLastName());
    }

    @Override
    public void testMuidNull() {
        user = new UserUrlData(null, VALID_NAME, VALID_LAST_NAME);
    }

    @Override
    public void testUidTypeInvalid() {
        user = new UserUrlData(INVALID_MUID, VALID_NAME, VALID_LAST_NAME);
    }

    @Override
    public void testNameNull() {
        user = new UserUrlData(VALID_MUID, null, VALID_LAST_NAME);
    }

    @Test(
            expected = IllegalArgumentException.class)
    public void testLastNameNull() {
        user = new UserUrlData(VALID_MUID, VALID_NAME, null);
    }

}
