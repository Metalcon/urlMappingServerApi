package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

public class TrackUrlDataTest extends EntityUrlDataTest {

    protected static final BandUrlData VALID_BAND = BandUrlDataTest.VALID_BAND;

    protected static final RecordUrlData VALID_RECORD =
            RecordUrlDataTest.VALID_RECORD;

    protected static final RecordUrlData VALID_RECORD_WITHOUT_BAND =
            new RecordUrlData(Muid.create(MuidType.RECORD),
                    VALID_RECORD.getName(), null, VALID_RECORD.getReleaseYear());

    protected static final int VALID_TRACK_NUMBER = 100;

    protected TrackUrlData track;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.TRACK;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity =
                new TrackUrlData(VALID_MUID, VALID_NAME, null, VALID_RECORD,
                        VALID_TRACK_NUMBER);
        super.testEntityNotEmpty();
    }

    @Override
    public void testEntityFull() {
        track =
                new TrackUrlData(VALID_MUID, VALID_NAME, null, VALID_RECORD,
                        VALID_TRACK_NUMBER);
        testEntityValid(track);
        assertEquals(VALID_RECORD, track.getRecord());
        assertEquals(VALID_TRACK_NUMBER, track.getTrackNumber());
    }

    @Test
    @Override
    public void testMuidNull() {
        track =
                new TrackUrlData(null, VALID_NAME, null, VALID_RECORD,
                        VALID_TRACK_NUMBER);
    }

    @Override
    public void testMuidTypeInvalid() {
        track =
                new TrackUrlData(INVALID_MUID, VALID_NAME, null, VALID_RECORD,
                        VALID_TRACK_NUMBER);
    }

    @Override
    public void testNameNull() {
        track =
                new TrackUrlData(VALID_MUID, null, null, VALID_RECORD,
                        VALID_TRACK_NUMBER);
    }

    @Test(
            expected = IllegalArgumentException.class)
    public void testBandAndRecord() {
        track =
                new TrackUrlData(VALID_MUID, VALID_NAME, VALID_BAND,
                        VALID_RECORD, VALID_TRACK_NUMBER);
    }

    @Test
    public void testBandNullRecordNull() {
        track =
                new TrackUrlData(VALID_MUID, VALID_NAME, null, null,
                        VALID_TRACK_NUMBER);
        testEntityValid(track);
        assertTrue(track.getRecord().hasEmptyMuid());
        assertTrue(track.getRecord().hasEmptyMuid());
        assertEquals(VALID_TRACK_NUMBER, track.getTrackNumber());
    }

    @Test
    public void testRecordNull() {
        track =
                new TrackUrlData(VALID_MUID, VALID_NAME, VALID_BAND, null,
                        VALID_TRACK_NUMBER);
        testEntityValid(track);
        assertEquals(VALID_BAND, track.getRecord().getBand());
        assertTrue(track.getRecord().hasEmptyMuid());
        assertEquals(VALID_TRACK_NUMBER, track.getTrackNumber());
    }

    @Test
    public void testRecordWithoutBand() {
        track =
                new TrackUrlData(VALID_MUID, VALID_NAME, null,
                        VALID_RECORD_WITHOUT_BAND, VALID_TRACK_NUMBER);
        testEntityValid(track);
        assertTrue(track.getRecord().getBand().hasEmptyMuid());
        assertEquals(VALID_RECORD_WITHOUT_BAND, track.getRecord());
        assertEquals(VALID_TRACK_NUMBER, track.getTrackNumber());
    }

    @Test
    public void testTrackNumberZero() {
        track = new TrackUrlData(VALID_MUID, VALID_NAME, null, VALID_RECORD, 0);
        testEntityValid(track);
        assertEquals(VALID_RECORD.getBand(), track.getRecord().getBand());
        assertEquals(VALID_RECORD, track.getRecord());
        assertEquals(0, track.getTrackNumber());
    }

}
