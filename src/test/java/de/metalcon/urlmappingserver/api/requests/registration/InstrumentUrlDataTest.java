package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.Before;

import de.metalcon.domain.Muid;

public class InstrumentUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(9);

    @Before
    public void setUp() {
        sourceEntity = new InstrumentUrlData(VALID_MUID, VALID_NAME);
    }

    @Override
    public void serialize() {
        serObject = InstrumentUrlData.serialize(sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = InstrumentUrlData.deserialize(deserObject);
    }
}
