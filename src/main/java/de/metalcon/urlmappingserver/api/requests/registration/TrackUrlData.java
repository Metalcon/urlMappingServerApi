package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class TrackUrlData extends EntityUrlData {

    private BandUrlData band;

    private RecordUrlData record;

    private int trackNumber;

    public TrackUrlData(
            Muid muid,
            String name,
            BandUrlData band,
            RecordUrlData record,
            int trackNumber) {
        super(muid, name);
        this.band = band;
        this.record = record;
        this.trackNumber = trackNumber;
    }

    public BandUrlData getBand() {
        return band;
    }

    public RecordUrlData getRecord() {
        return record;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public static String serialize(TrackUrlData track) {
        return serializeToJSON(track).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeToJSON(TrackUrlData track) {
        JSONObject object = EntityUrlData.serializeToJson(track);
        object.put(RegistrationRequestSerialization.Track.BAND,
                BandUrlData.serializeToJson(track.getBand()));
        object.put(RegistrationRequestSerialization.Track.RECORD,
                RecordUrlData.serializeToJson(track.getRecord()));
        object.put(RegistrationRequestSerialization.Track.TRACK_NUMBER,
                track.getTrackNumber());
        return object;
    }

    protected static BandUrlData deserializeBandUrlData(JSONObject track) {
        return BandUrlData.deserialize(ZeroMQSerialization.Helper.getObject(
                RegistrationRequestSerialization.Track.BAND, track));
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
        BandUrlData band = deserializeBandUrlData(track);
        RecordUrlData record = deserializeRecordUrlData(track);
        int trackNumber = deserializeTrackNumber(track);

        return new TrackUrlData(deserializedMuid, name, band, record,
                trackNumber);
    }

}
