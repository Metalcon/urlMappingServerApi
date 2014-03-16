package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;

public class CityUrlData extends EntityUrlData {

    public CityUrlData(
            Muid muid,
            String name) {
        super(muid, name);
    }

    public static CityUrlData deserialize(JSONObject city) {
        return deserialize(city, null);
    }

    public static CityUrlData
        deserialize(JSONObject city, Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(city, EntityType.CITY);
        }
        String name = deserializeName(city);

        return new CityUrlData(deserializedMuid, name);
    }
}
