package de.metalcon.domain.entities;

import org.json.simple.JSONObject;

import de.metalcon.urlmappingserver.api.EntityType;
import de.metalcon.urlmappingserver.api.EntityUrlObject;
import de.metalcon.urlmappingserver.api.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

/**
 * venue URL information class
 * 
 * @author sebschlicht
 * 
 */
public class VenueUrlObject extends EntityUrlObject {

    /**
     * city URL information
     */
    private CityUrlObject city;

    /**
     * create new venue URL object
     * 
     * @param muid
     *            venue identifier
     * @param name
     *            venue name
     */
    public VenueUrlObject(
            Muid muid,
            String name) {
        super(muid, name);
    }

    public CityUrlObject getCity() {
        return city;
    }

    public void setCity(CityUrlObject city) {
        this.city = city;
    }

    @SuppressWarnings("unchecked")
    public static JSONObject serialize(final VenueUrlObject venue) {
        final JSONObject object = EntityUrlObject.serialize(venue);
        final JSONObject cityObject = CityUrlObject.serialize(venue.getCity());
        object.put(ZeroMQSerialization.Venue.CITY, cityObject);
        return object;
    }

    protected static CityUrlObject getCityUrlObject(final JSONObject event) {
        final JSONObject cityObject =
                getObject(ZeroMQSerialization.Venue.CITY, event);
        return CityUrlObject.deserialize(cityObject, null);
    }

    /**
     * deserialize venue
     * 
     * @param venue
     *            JSON serialized venue
     * @param deserializedMuid
     *            MUID if deserialized yet
     * @return deserialized venue URL object
     */
    public static VenueUrlObject deserialize(
            final JSONObject venue,
            final Muid deserializedMuid) {
        final Muid muid =
                (deserializedMuid != null) ? deserializedMuid : getMuid(venue,
                        EntityType.VENUE);
        final String name = getName(venue);
        final VenueUrlObject venueUrlObject = new VenueUrlObject(muid, name);

        final CityUrlObject cityUrlObject = getCityUrlObject(venue);
        venueUrlObject.setCity(cityUrlObject);

        return venueUrlObject;
    }

}
