package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;

public class GenreUrlData extends EntityUrlData {

    private static final long serialVersionUID = -8678056610527852471L;

    public GenreUrlData(
            Muid muid,
            String name) {
        super(muid, name);
    }

    public static GenreUrlData deserialize(JSONObject genre) {
        return deserialize(genre, null);
    }

    public static GenreUrlData deserialize(
            JSONObject genre,
            Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(genre, EntityType.GENRE);
        }
        String name = deserializeName(genre);

        return new GenreUrlData(deserializedMuid, name);
    }

}
