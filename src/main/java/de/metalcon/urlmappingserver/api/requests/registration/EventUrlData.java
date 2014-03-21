package de.metalcon.urlmappingserver.api.requests.registration;

import java.util.Date;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

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
     * create event URL information
     * 
     * @param muid
     *            event ID
     * @param name
     *            event name
     * @param date
     *            first event date (milliseconds will be ignored), may be null
     * @param city
     *            city the event is located in<br>
     *            may be <b>null</b><br>
     *            if <b>null</b> the city of the venue is taken, if
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
        super(MuidType.EVENT, muid, name);
        this.date =
                (date != null) ? new Date(date.getTime() - date.getTime()
                        % 1000) : null;
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

}
