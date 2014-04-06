package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.BeforeClass;

import de.metalcon.domain.UidType;

public class GenreUrlDataTest extends EntityUrlDataTest {

    protected GenreUrlData genre;

    @BeforeClass
    public static void beforeClass() {
        MUID_TYPE = UidType.GENRE;
        EntityUrlDataTest.beforeClass();
    }

    @Override
    public void testEntityNotEmpty() {
        entity = new GenreUrlData(VALID_MUID, VALID_NAME);
        super.testEntityNotEmpty();
    }

    @Override
    public void testEntityFull() {
        genre = new GenreUrlData(VALID_MUID, VALID_NAME);
        testEntityValid(genre);
    }

    @Override
    public void testMuidNull() {
        genre = new GenreUrlData(null, VALID_NAME);
    }

    @Override
    public void testUidTypeInvalid() {
        genre = new GenreUrlData(INVALID_MUID, VALID_NAME);
    }

    @Override
    public void testNameNull() {
        genre = new GenreUrlData(VALID_MUID, null);
    }

}
