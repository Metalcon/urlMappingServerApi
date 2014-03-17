package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.Before;

import de.metalcon.domain.Muid;

public class GenreUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(8);

    @Before
    public void setUp() {
        sourceEntity = new GenreUrlData(VALID_MUID, VALID_NAME);
    }

    @Override
    public void serialize() {
        serObject = GenreUrlData.serializeEntity(sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = GenreUrlData.deserialize(deserObject);
    }
}
