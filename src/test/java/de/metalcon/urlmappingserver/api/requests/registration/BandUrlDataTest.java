package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.Before;

import de.metalcon.domain.Muid;

public class BandUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(2);

    @Before
    public void setUp() {
        sourceEntity = new BandUrlData(VALID_MUID, VALID_NAME);
    }

    @Override
    public void serialize() {
        serObject = BandUrlData.serializeEntity(sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = BandUrlData.deserialize(deserObject);
    }
}
