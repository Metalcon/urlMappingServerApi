package de.metalcon.urlmappingserver.api.requests.registration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    BandUrlDataTest.class, CityUrlDataTest.class, GenreUrlDataTest.class,
    InstrumentUrlDataTest.class, RecordUrlDataTest.class
})
public class EntityUrlDataTests {

}
