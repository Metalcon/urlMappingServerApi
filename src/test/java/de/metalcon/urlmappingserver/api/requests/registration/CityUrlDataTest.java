package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.BeforeClass;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

public class CityUrlDataTest extends EntityUrlDataTest {

    public static final CityUrlData VALID_CITY = new CityUrlData(
            Muid.create(MuidType.CITY), VALID_NAME);

    protected CityUrlData city;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.CITY;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testMuidValid() {
        city = new CityUrlData(VALID_MUID, VALID_NAME);
        testEntityValid(city);
    }

    @Override
    public void testMuidNull() {
        city = new CityUrlData(null, VALID_NAME);
    }

    @Override
    public void testMuidTypeInvalid() {
        city = new CityUrlData(INVALID_MUID, VALID_NAME);
    }

    @Override
    public void testNameNull() {
        city = new CityUrlData(VALID_MUID, null);
    }

}
