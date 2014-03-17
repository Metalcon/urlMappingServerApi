package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    BandUrlDataTest.class, CityUrlDataTest.class, EventUrlDataTest.class,
    GenreUrlDataTest.class, InstrumentUrlDataTest.class,
    RecordUrlDataTest.class, TourUrlDataTest.class, TrackUrlDataTest.class,
    UserUrlDataTest.class, VenueUrlDataTest.class
})
public class EntityUrlDataTests {

}
