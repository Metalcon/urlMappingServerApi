package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.Before;
import org.junit.Test;

import de.metalcon.domain.Muid;

public class RecordUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(3);

    public static final BandUrlData VALID_BAND = new BandUrlData(
            BandUrlDataTest.VALID_MUID, VALID_NAME);

    public static final int VALID_RELEASE_YEAR = 2014;

    protected RecordUrlData record;

    @Before
    public void setUp() {
        record =
                new RecordUrlData(VALID_MUID, VALID_NAME, VALID_BAND,
                        VALID_RELEASE_YEAR);
        sourceEntity = record;
    }

    @Override
    public void serialize() {
        serObject = RecordUrlData.serialize((RecordUrlData) sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = RecordUrlData.deserialize(deserObject);
    }

    @Test
    public void testDifferentBand() {
        process();
        record.band =
                new BandUrlData(new Muid(VALID_BAND.getMuid().getValue() + 10),
                        VALID_BAND.getName());
        testEntitiesNotEqual();
    }

    @Test
    public void testDifferentReleaseYear() {
        process();
        record.releaseYear = VALID_RELEASE_YEAR - 1;
        testEntitiesNotEqual();
    }
}
