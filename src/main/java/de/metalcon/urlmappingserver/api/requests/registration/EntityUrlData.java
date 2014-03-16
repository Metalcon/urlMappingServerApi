package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;
import de.metalcon.urlmappingserver.api.requests.Request;

public abstract class EntityUrlData extends Request {

    protected Muid muid;

    protected String name;

    public EntityUrlData(
            Muid muid,
            String name) {
        this.muid = muid;
        this.name = name;
    }

    public Muid getMuid() {
        return muid;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() != getClass()) {
            return false;
        }

        EntityUrlData e = (EntityUrlData) o;
        return getMuid().equals(e.getMuid()) && getName().equals(e.getName());
    }

    public static String serialize(EntityUrlData entity) {
        return serializeToJson(entity).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeToJson(final EntityUrlData object) {
        JSONObject muidObject = new JSONObject();
        muidObject.put(RegistrationRequestSerialization.Muid.VALUE, object
                .getMuid().getValue());

        JSONObject serialized = new JSONObject();
        serialized.put(RegistrationRequestSerialization.MUID, muidObject);
        serialized.put(RegistrationRequestSerialization.NAME, object.getName());

        return serialized;
    }

    protected static Muid deserializeMuid(
            JSONObject entity,
            EntityType expectedType) {
        JSONObject muidObject =
                ZeroMQSerialization.Helper.getObject(
                        RegistrationRequestSerialization.MUID, entity);
        long value =
                ZeroMQSerialization.Helper
                        .getLong(RegistrationRequestSerialization.Muid.VALUE,
                                muidObject);
        Muid muid = new Muid(value);

        if (expectedType == null || expectedType == muid.getEntityType()) {
            return muid;
        }

        return null;
    }

    protected static String deserializeName(JSONObject entity) {
        return ZeroMQSerialization.Helper.getString(
                RegistrationRequestSerialization.NAME, entity);
    }

    public static EntityUrlData deserialize(JSONObject entity) {
        Muid muid = deserializeMuid(entity, null);

        switch (muid.getEntityType()) {

            case BAND:
                return BandUrlData.deserialize(entity, muid);

            case CITY:
                return CityUrlData.deserialize(entity, muid);

            case EVENT:
                return EventUrlData.deserialize(entity, muid);

            case GENRE:
                return GenreUrlData.deserialize(entity, muid);

            case INSTRUMENT:
                return InstrumentUrlData.deserialize(entity, muid);

            case RECORD:
                return RecordUrlData.deserialize(entity, muid);

            case TOUR:
                return TourUrlData.deserialize(entity, muid);

            case TRACK:
                return TrackUrlData.deserialize(entity, muid);

            case USER:
                return UserUrlData.deserialize(entity, muid);

            case VENUE:
                return VenueUrlData.deserialize(entity, muid);

            default:
                throw new UnsupportedOperationException(
                        "unknown entity type \"" + muid.getEntityType() + "\"");
        }
    }

}
