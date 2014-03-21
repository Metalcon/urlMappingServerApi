package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.MuidType;

public class UserUrlDataTest extends EntityUrlDataTest {

    protected static final String VALID_LAST_NAME = "Testatum";

    protected UserUrlData user;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.USER;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testMuidValid() {
        user = new UserUrlData(VALID_MUID, VALID_NAME, VALID_LAST_NAME);
        testEntityValid(user);
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
    }

    @Override
    public void testMuidNull() {
        user = new UserUrlData(null, VALID_NAME, VALID_LAST_NAME);
    }

    @Override
    public void testMuidTypeInvalid() {
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
