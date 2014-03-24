package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

public abstract class EntityUrlDataTest {

    protected static final String VALID_NAME = "Testy";

    protected static MuidType MUID_TYPE;

    protected static Muid VALID_MUID;

    protected static Muid INVALID_MUID;

    protected EntityUrlData entity;

    @BeforeClass
    public static void beforeClass() {
        VALID_MUID = Muid.create(MUID_TYPE);
        INVALID_MUID = getInvalidMuid(VALID_MUID.getMuidType());
    }

    protected static Muid getInvalidMuid(MuidType validMuidType) {
        short typeIdentifier = (short) (validMuidType.getRawIdentifier() + 1);
        if (typeIdentifier == 10) {
            typeIdentifier = 0;
        }
        return Muid.create(MuidType.parseShort(typeIdentifier));
    }

    protected void testEntityValid(EntityUrlData entity) {
        assertNotNull(entity.getMuid());
        assertNotNull(entity.getName());
    }

    @Test
    public void testEntityNotEmpty() {
        assertFalse(entity.hasEmptyMuid());
    }

    @Test
    public abstract void testEntityFull();

    @Test(
            expected = IllegalArgumentException.class)
    public abstract void testMuidNull();

    @Test(
            expected = IllegalArgumentException.class)
    public abstract void testMuidTypeInvalid();

    @Test(
            expected = IllegalArgumentException.class)
    public abstract void testNameNull();

}
