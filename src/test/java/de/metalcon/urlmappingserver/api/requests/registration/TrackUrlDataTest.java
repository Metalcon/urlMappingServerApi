package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.Before;
import org.junit.Test;

import de.metalcon.domain.Muid;

public class TrackUrlDataTest extends EntityUrlDataTest {

    public static Muid VALID_MUID = new Muid(4);

    public static RecordUrlData VALID_RECORD = new RecordUrlData(
            RecordUrlDataTest.VALID_MUID, VALID_NAME,
            RecordUrlDataTest.VALID_BAND, RecordUrlDataTest.VALID_RELEASE_YEAR);

    public static int VALID_TRACK_NUMBER = 7;

    protected TrackUrlData track;

    @Before
    public void setUp() {
        track =
                new TrackUrlData(VALID_MUID, VALID_NAME, VALID_RECORD,
                        VALID_TRACK_NUMBER);
        sourceEntity = track;
    }

    @Override
    public void serialize() {
        serObject = TrackUrlData.serialize((TrackUrlData) sourceEntity);
    }

    @Override
    public void deserialize() {
        entity = TrackUrlData.deserialize(deserObject);
    }

    @Test
    public void testDifferentRecord() {
        process();
        track.record =
                new RecordUrlData(new Muid(
                        VALID_RECORD.getMuid().getValue() + 10),
                        VALID_RECORD.getName(), VALID_RECORD.getBand(),
                        VALID_RECORD.getReleaseYear());
        testEntitiesNotEqual();
    }

    @Test
    public void testDifferentTrackNumber() {
        process();
        track.trackNumber = VALID_TRACK_NUMBER - 1;
        testEntitiesNotEqual();
    }
}
