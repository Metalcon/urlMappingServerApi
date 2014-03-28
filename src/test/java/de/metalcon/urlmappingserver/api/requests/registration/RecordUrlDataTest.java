package de.metalcon.urlmappingserver.api.requests.registration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import de.metalcon.domain.MuidType;
import de.metalcon.testing.MuidFactory;

public class RecordUrlDataTest extends EntityUrlDataTest {

    protected static final BandUrlData VALID_BAND = new BandUrlData(
            MuidFactory.generateMuid(MuidType.BAND),
            BandUrlDataTest.VALID_BAND.getName());

    protected static final int VALID_RELEASE_YEAR = 2014;

    public static final RecordUrlData VALID_RECORD = new RecordUrlData(
            MuidFactory.generateMuid(MuidType.RECORD), VALID_NAME, VALID_BAND,
            VALID_RELEASE_YEAR);

    protected static final RecordUrlData EMPTY_RECORD = new RecordUrlData(
            VALID_BAND);

    protected RecordUrlData record;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = MuidType.RECORD;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity = VALID_RECORD;
        super.testEntityNotEmpty();
    }

    @Test
    public void testEntityEmpty() {
        entity = EMPTY_RECORD;
        assertTrue(entity.hasEmptyMuid());
        assertNull(entity.getName());
        assertEquals(VALID_BAND, EMPTY_RECORD.getBand());
        assertEquals(0, EMPTY_RECORD.getReleaseYear());
    }

    @Override
    public void testEntityFull() {
        record =
                new RecordUrlData(VALID_MUID, VALID_NAME, VALID_BAND,
                        VALID_RELEASE_YEAR);
        testEntityValid(record);
        assertEquals(VALID_BAND, record.getBand());
        assertEquals(VALID_RELEASE_YEAR, record.getReleaseYear());
    }

    @Test
    @Override
    public void testMuidNull() {
        record =
                new RecordUrlData(null, VALID_NAME, VALID_BAND,
                        VALID_RELEASE_YEAR);
    }

    @Override
    public void testMuidTypeInvalid() {
        record =
                new RecordUrlData(INVALID_MUID, VALID_NAME, VALID_BAND,
                        VALID_RELEASE_YEAR);
    }

    @Override
    public void testNameNull() {
        record =
                new RecordUrlData(VALID_MUID, null, VALID_BAND,
                        VALID_RELEASE_YEAR);
    }

    @Test
    public void testBandNull() {
        record =
                new RecordUrlData(VALID_MUID, VALID_NAME, null,
                        VALID_RELEASE_YEAR);
        testEntityValid(record);
        assertTrue(record.getBand().hasEmptyMuid());
        assertEquals(VALID_RELEASE_YEAR, record.getReleaseYear());
    }

    @Test
    public void testReleaseYearZero() {
        record = new RecordUrlData(VALID_MUID, VALID_NAME, VALID_BAND, 0);
        testEntityValid(record);
        assertEquals(VALID_BAND, record.getBand());
        assertEquals(0, record.getReleaseYear());
    }

}
