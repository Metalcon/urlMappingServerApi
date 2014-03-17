package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class EventUrlData extends EntityUrlData {

    protected CityUrlData city;

    protected VenueUrlData venue;

    public EventUrlData(
            Muid muid,
            String name,
            CityUrlData city,
            VenueUrlData venue) {
        super(muid, name);
        this.city = city;
        this.venue = venue;
    }

    public CityUrlData getCity() {
        return city;
    }

    public VenueUrlData getVenue() {
        return venue;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            EventUrlData e = (EventUrlData) o;
            return getCity().equals(e.getCity())
                    && getVenue().equals(e.getVenue());
        }
        return false;
    }

    public static String serialize(EventUrlData event) {
        return serializeEventToJson(event).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeEventToJson(EventUrlData event) {
        JSONObject object = EntityUrlData.serializeEntityToJson(event);
        object.put(RegistrationRequestSerialization.Event.CITY,
                CityUrlData.serializeEntityToJson(event.getCity()));
        object.put(RegistrationRequestSerialization.Event.VENUE,
                VenueUrlData.serializeVenueToJson(event.getVenue()));
        return object;
    }

    protected static CityUrlData deserializeCityUrlData(JSONObject event) {
        return CityUrlData.deserialize(ZeroMQSerialization.Helper.getObject(
                RegistrationRequestSerialization.Event.CITY, event));
    }

    protected static VenueUrlData deserializeVenueUrlData(JSONObject event) {
        return VenueUrlData.deserialize(ZeroMQSerialization.Helper.getObject(
                RegistrationRequestSerialization.Event.VENUE, event));
    }

    public static EventUrlData deserialize(JSONObject event) {
        return deserialize(event, null);
    }

    public static EventUrlData deserialize(
            JSONObject event,
            Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(event, EntityType.EVENT);
        }
        String name = deserializeName(event);
        CityUrlData city = deserializeCityUrlData(event);
        VenueUrlData venue = deserializeVenueUrlData(event);

        return new EventUrlData(deserializedMuid, name, city, venue);
    }

}
