package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.Before;

import de.metalcon.domain.Muid;

public class CityUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(7);

    @Before
    public void setUp() {
        sourceEntity = new CityUrlData(VALID_MUID, VALID_NAME);
    }

    @Override
    public void serialize() {
        serObject = CityUrlData.serialize(sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = CityUrlData.deserialize(deserObject);
    }
}
