package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.BeforeClass;

import de.metalcon.domain.UidType;
import de.metalcon.testing.MuidFactory;

public class CityUrlDataTest extends EntityUrlDataTest {

	public static final CityUrlData VALID_CITY = new CityUrlData(
			MuidFactory.generateMuid(UidType.CITY), VALID_NAME);

	protected CityUrlData city;

	@BeforeClass
	public static void beforeClass() {
		MUID_TYPE = UidType.CITY;
		EntityUrlDataTest.beforeClass();
	}

	@Override
	public void testEntityNotEmpty() {
		entity = VALID_CITY;
		super.testEntityNotEmpty();
	}

	@Override
	public void testEntityFull() {
		city = new CityUrlData(VALID_MUID, VALID_NAME);
		testEntityValid(city);
	}

	@Override
	public void testMuidNull() {
		city = new CityUrlData(null, VALID_NAME);
	}

	@Override
	public void testUidTypeInvalid() {
		city = new CityUrlData(INVALID_MUID, VALID_NAME);
	}

	@Override
	public void testNameNull() {
		city = new CityUrlData(VALID_MUID, null);
	}

}
