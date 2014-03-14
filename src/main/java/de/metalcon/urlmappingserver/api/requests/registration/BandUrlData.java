package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;

public class BandUrlData extends EntityUrlData {

    public BandUrlData(
            Muid muid,
            String name) {
        super(muid, name);
    }

    public static BandUrlData deserialize(JSONObject band) {
        return deserialize(band, null);
    }

    public static BandUrlData deserialize(
            JSONObject band,
            Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(band, EntityType.BAND);
        }
        String name = deserializeName(band);

        return new BandUrlData(deserializedMuid, name);
    }

}
