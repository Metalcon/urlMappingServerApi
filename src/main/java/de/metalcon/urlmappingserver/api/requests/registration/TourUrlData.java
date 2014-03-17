package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class TourUrlData extends EntityUrlData {

    protected int year;

    public TourUrlData(
            Muid muid,
            String name,
            int year) {
        super(muid, name);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            TourUrlData t = (TourUrlData) o;
            return getYear() == t.getYear();
        }
        return false;
    }

    public static String serialize(TourUrlData tour) {
        return serializeTourToJson(tour).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeTourToJson(TourUrlData tour) {
        JSONObject object = EntityUrlData.serializeEntityToJson(tour);
        object.put(RegistrationRequestSerialization.Tour.YEAR, tour.getYear());
        return object;
    }

    protected static int deserializeYear(JSONObject tour) {
        return ZeroMQSerialization.Helper.getInteger(
                RegistrationRequestSerialization.Tour.YEAR, tour);
    }

    public static TourUrlData deserialize(JSONObject tour) {
        return deserialize(tour, null);
    }

    public static TourUrlData
        deserialize(JSONObject tour, Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(tour, EntityType.TOUR);
        }
        String name = deserializeName(tour);
        int year = deserializeYear(tour);

        return new TourUrlData(deserializedMuid, name, year);
    }

}
