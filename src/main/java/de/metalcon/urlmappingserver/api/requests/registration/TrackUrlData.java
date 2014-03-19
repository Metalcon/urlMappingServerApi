package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class TrackUrlData extends EntityUrlData {

    private static final long serialVersionUID = 4829309992842372145L;

    protected RecordUrlData record;

    protected int trackNumber;

    /**
     * 
     * @param muid
     * @param name
     * @param record
     *            may be null
     * @param trackNumber
     *            may be zero
     */
    public TrackUrlData(
            Muid muid,
            String name,
            RecordUrlData record,
            int trackNumber) {
        super(muid, name);
        this.record = record;
        this.trackNumber = trackNumber;
    }

    public BandUrlData getBand() {
        return getRecord().getBand();
    }

    public RecordUrlData getRecord() {
        return record;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            TrackUrlData t = (TrackUrlData) o;
            return getRecord().equals(t.getRecord())
                    && getTrackNumber() == t.getTrackNumber();
        }
        return false;
    }

    public static String serialize(TrackUrlData track) {
        return serializeTrackToJson(track).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeTrackToJson(TrackUrlData track) {
        JSONObject object = EntityUrlData.serializeEntityToJson(track);
        object.put(RegistrationRequestSerialization.Track.RECORD,
                RecordUrlData.serializeRecordToJson(track.getRecord()));
        object.put(RegistrationRequestSerialization.Track.TRACK_NUMBER,
                track.getTrackNumber());
        return object;
    }

    protected static RecordUrlData deserializeRecordUrlData(JSONObject track) {
        return RecordUrlData.deserialize(ZeroMQSerialization.Helper.getObject(
                RegistrationRequestSerialization.Track.RECORD, track));
    }

    protected static int deserializeTrackNumber(JSONObject track) {
        return ZeroMQSerialization.Helper.getInteger(
                RegistrationRequestSerialization.Track.TRACK_NUMBER, track);
    }

    public static TrackUrlData deserialize(JSONObject track) {
        return deserialize(track, null);
    }

    public static TrackUrlData deserialize(
            JSONObject track,
            Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(track, EntityType.TRACK);
        }
        String name = deserializeName(track);
        RecordUrlData record = deserializeRecordUrlData(track);
        int trackNumber = deserializeTrackNumber(track);

        return new TrackUrlData(deserializedMuid, name, record, trackNumber);
    }

}
