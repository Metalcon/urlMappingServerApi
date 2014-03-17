package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.Before;
import org.junit.Test;

import de.metalcon.domain.Muid;

public class UserUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(1);

    public static String VALID_FIRST_NAME = VALID_NAME;

    public static String VALID_LAST_NAME = "Testarum";

    protected UserUrlData user;

    @Before
    public void setUp() {
        user = new UserUrlData(VALID_MUID, VALID_FIRST_NAME, VALID_LAST_NAME);
        sourceEntity = user;
    }

    @Override
    public void serialize() {
        serObject = UserUrlData.serialize((UserUrlData) sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = UserUrlData.deserialize(deserObject);
    }

    @Test
    public void testDifferentFirstName() {
        process();
        user.firstName = VALID_FIRST_NAME + VALID_LAST_NAME;
        testEntitiesNotEqual();
    }

    @Test
    public void testDifferentLastName() {
        process();
        user.lastName = VALID_LAST_NAME + VALID_FIRST_NAME;
        testEntitiesNotEqual();
    }
}
