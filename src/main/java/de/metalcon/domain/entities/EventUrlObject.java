package de.metalcon.domain.entities;

import java.util.Date;

import org.json.simple.JSONObject;

import de.metalcon.urlmappingserver.api.EntityType;
import de.metalcon.urlmappingserver.api.EntityUrlObject;
import de.metalcon.urlmappingserver.api.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

/**
 * event URL information class
 * 
 * @author sebschlicht
 * 
 */
public class EventUrlObject extends EntityUrlObject {

    /**
     * city URL information
     */
    private CityUrlObject city;

    /**
     * venue URL information
     */
    private VenueUrlObject venue;

    /**
     * event start
     */
    private Date date;

    /**
     * create new event URL object
     * 
     * @param muid
     *            event identifier
     * @param name
     *            event name
     */
    public EventUrlObject(
            Muid muid,
            String name) {
        super(muid, name);
    }

    public CityUrlObject getCity() {
        if (city == null) {
            return venue.getCity();
        }
        return city;
    }

    public void setCity(CityUrlObject city) {
        this.city = city;
    }

    public VenueUrlObject getVenue() {
        return venue;
    }

    public void setVenue(VenueUrlObject venue) {
        this.venue = venue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @SuppressWarnings("unchecked")
    public static JSONObject serialize(final EventUrlObject event) {
        final JSONObject object = EntityUrlObject.serialize(event);
        final JSONObject cityObject = CityUrlObject.serialize(event.getCity());
        object.put(ZeroMQSerialization.Event.CITY, cityObject);
        final JSONObject venueObject =
                VenueUrlObject.serialize(event.getVenue());
        object.put(ZeroMQSerialization.Event.VENUE, venueObject);
        object.put(ZeroMQSerialization.Event.DATE,
                DATE_FORMATTER.format(event.getDate()));
        return object;
    }

    protected static CityUrlObject getCityUrlObject(final JSONObject event) {
        final JSONObject cityObject =
                getObject(ZeroMQSerialization.Event.CITY, event);
        return CityUrlObject.deserialize(cityObject, null);
    }

    protected static VenueUrlObject getVenueUrlObject(final JSONObject event) {
        final JSONObject venueObject =
                getObject(ZeroMQSerialization.Event.VENUE, event);
        return VenueUrlObject.deserialize(venueObject, null);
    }

    protected static Date getDate(final JSONObject event) {
        return getDate(ZeroMQSerialization.Event.DATE, event);
    }

    /**
     * deserialize event
     * 
     * @param event
     *            JSON serialized event
     * @param deserializedMuid
     *            MUID if deserialized yet
     * @return deserialized event URL object
     */
    public static EventUrlObject deserialize(
            final JSONObject event,
            final Muid deserializedMuid) {
        final Muid muid =
                (deserializedMuid != null) ? deserializedMuid : getMuid(event,
                        EntityType.EVENT);
        final String name = getName(event);
        final EventUrlObject eventUrlObject = new EventUrlObject(muid, name);

        final CityUrlObject cityUrlObject = getCityUrlObject(event);
        eventUrlObject.setCity(cityUrlObject);

        final VenueUrlObject venueUrlObject = getVenueUrlObject(event);
        eventUrlObject.setVenue(venueUrlObject);

        final Date date = getDate(event);
        eventUrlObject.setDate(date);

        return eventUrlObject;
    }

}
