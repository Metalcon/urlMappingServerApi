package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class VenueUrlData extends EntityUrlData {

    private static final long serialVersionUID = 4882678233111916935L;

    protected CityUrlData city;

    /**
     * 
     * @param muid
     * @param name
     * @param city
     *            may be null
     */
    public VenueUrlData(
            Muid muid,
            String name,
            CityUrlData city) {
        super(muid, name);
        this.city = city;
    }

    public CityUrlData getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            VenueUrlData v = (VenueUrlData) o;
            return getCity().equals(v.getCity());
        }
        return false;
    }

    public static String serialize(VenueUrlData venue) {
        return serializeVenueToJson(venue).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeVenueToJson(VenueUrlData venue) {
        JSONObject object = EntityUrlData.serializeEntityToJson(venue);
        object.put(RegistrationRequestSerialization.Venue.CITY,
                CityUrlData.serializeEntityToJson(venue.getCity()));
        return object;
    }

    protected static CityUrlData deserializeCityUrlData(JSONObject venue) {
        return CityUrlData.deserialize(ZeroMQSerialization.Helper.getObject(
                RegistrationRequestSerialization.Venue.CITY, venue));
    }

    public static VenueUrlData deserialize(JSONObject venue) {
        return deserialize(venue, null);
    }

    public static VenueUrlData deserialize(
            JSONObject venue,
            Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(venue, EntityType.VENUE);
        }
        String name = deserializeName(venue);
        CityUrlData city = deserializeCityUrlData(venue);

        return new VenueUrlData(deserializedMuid, name, city);
    }

}
