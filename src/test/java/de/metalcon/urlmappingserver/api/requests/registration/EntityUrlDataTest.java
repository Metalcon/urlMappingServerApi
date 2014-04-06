package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.Muid;
import de.metalcon.domain.UidType;
import de.metalcon.testing.MuidFactory;

public abstract class EntityUrlDataTest {

	protected static final String VALID_NAME = "Testy";

	protected static UidType MUID_TYPE;

	protected static Muid VALID_MUID;

	protected static Muid INVALID_MUID;

	protected EntityUrlData entity;

	@BeforeClass
	public static void beforeClass() {
		VALID_MUID = MuidFactory.generateMuid(MUID_TYPE);
		INVALID_MUID = getInvalidMuid(VALID_MUID.getType());
	}

	protected static Muid getInvalidMuid(final UidType validUidType) {
		short typeIdentifier = (short) (validUidType.getRawIdentifier() + 1);
		if (typeIdentifier == 10) {
			typeIdentifier = 0;
		}
		return MuidFactory.generateMuid(UidType.parseShort(typeIdentifier));
	}

	protected void testEntityValid(final EntityUrlData entity) {
		assertNotNull(entity.getMuid());
		assertNotNull(entity.getName());
	}

	@Test
	public void testEntityNotEmpty() {
		assertFalse(entity.hasEmptyMuid());
	}

	@Test
	public abstract void testEntityFull();

	@Test(expected = IllegalArgumentException.class)
	public abstract void testMuidNull();

	@Test(expected = IllegalArgumentException.class)
	public abstract void testUidTypeInvalid();

	@Test(expected = IllegalArgumentException.class)
	public abstract void testNameNull();

}
