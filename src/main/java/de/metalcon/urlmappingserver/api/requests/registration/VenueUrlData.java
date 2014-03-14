package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class VenueUrlData extends EntityUrlData {

    private CityUrlData city;

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

    public static String serialize(VenueUrlData venue) {
        return serializeToJSON(venue).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeToJSON(VenueUrlData venue) {
        JSONObject object = EntityUrlData.serializeToJson(venue);
        object.put(RegistrationRequestSerialization.Venue.CITY,
                CityUrlData.serializeToJson(venue.getCity()));
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
