package de.metalcon.urlmappingserver.api.requests.registration;

import java.util.Date;

import de.metalcon.domain.Muid;

/**
 * URL information for event entities
 * 
 * @author sebschlicht
 * 
 */
public class EventUrlData extends EntityUrlData {

    private static final long serialVersionUID = -3249109237520805058L;

    /**
     * first event date<br>
     * may be <b>null</b>: unknown
     */
    protected Date date;

    /**
     * city the event is located in<br>
     * may be <b>null</b>: venue set, unknown
     */
    protected CityUrlData city;

    /**
     * venue the event is located in<br>
     * may be <b>null</b>: unknown
     */
    protected VenueUrlData venue;

    /**
     * 
     * @param muid
     * @param name
     * @param date
     *            first event date (milliseconds will be ignored), may be null
     * @param city
     *            city the event is located in<br>
     *            may be <b>null</b><br>
     *            if <b>null</b> the city of the venue will be returned, if
     *            venue was set
     * @param venue
     *            venue the event is located in<br>
     *            may be <b>null</b>
     */
    public EventUrlData(
            Muid muid,
            String name,
            Date date,
            CityUrlData city,
            VenueUrlData venue) {
        super(muid, name);
        this.date = new Date(date.getTime() - date.getTime() % 1000);
        this.city = city;
        this.venue = venue;
    }

    /**
     * @return first event date<br>
     *         may be <b>null</b>: unknown
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return city the event is located in<br>
     *         may be <b>null</b>
     */
    public CityUrlData getCity() {
        if (city == null && venue != null) {
            return venue.getCity();
        }
        return city;
    }

    /**
     * @return venue the event is located in<br>
     *         may be <b>null</b>
     */
    public VenueUrlData getVenue() {
        return venue;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            EventUrlData e = (EventUrlData) o;

            return getDate().equals(e.getDate())
                    && getCity().equals(e.getCity())
                    && getVenue().equals(e.getVenue());
        }
        return false;
    }

}
