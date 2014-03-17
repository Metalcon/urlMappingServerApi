package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;

public class InstrumentUrlData extends EntityUrlData {

    public InstrumentUrlData(
            Muid muid,
            String name) {
        super(muid, name);
    }

    public static InstrumentUrlData deserialize(JSONObject instrument) {
        return deserialize(instrument, null);
    }

    public static InstrumentUrlData deserialize(
            JSONObject instrument,
            Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid =
                    deserializeMuid(instrument, EntityType.INSTRUMENT);
        }
        String name = deserializeName(instrument);

        return new InstrumentUrlData(deserializedMuid, name);
    }

}
