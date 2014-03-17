package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class RecordUrlData extends EntityUrlData {

    private BandUrlData band;

    private int releaseYear;

    /**
     * 
     * @param muid
     * @param name
     * @param band
     *            may be null if not clear
     * @param releaseYear
     */
    public RecordUrlData(
            Muid muid,
            String name,
            BandUrlData band,
            int releaseYear) {
        super(muid, name);
        this.band = band;
        this.releaseYear = releaseYear;
    }

    public BandUrlData getBand() {
        return band;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public static String serialize(RecordUrlData record) {
        return serializeToJSON(record).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeToJSON(RecordUrlData record) {
        JSONObject object = EntityUrlData.serializeToJson(record);
        object.put(RegistrationRequestSerialization.Record.BAND,
                BandUrlData.serializeToJson(record.getBand()));
        object.put(
                RegistrationRequestSerialization.Record.RELEASE_YEAR,
                ZeroMQSerialization.Helper.parseInteger(record.getReleaseYear()));
        return object;
    }

    protected static BandUrlData deserializeBandUrlData(JSONObject record) {
        return BandUrlData.deserialize(ZeroMQSerialization.Helper.getObject(
                RegistrationRequestSerialization.Record.BAND, record));
    }

    protected static int deserializeReleaseYear(JSONObject record) {
        return ZeroMQSerialization.Helper.getInteger(
                RegistrationRequestSerialization.Record.RELEASE_YEAR, record);
    }

    public static RecordUrlData deserialize(JSONObject record) {
        return deserialize(record, null);
    }

    public static RecordUrlData deserialize(
            JSONObject record,
            Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(record, EntityType.RECORD);
        }
        String name = deserializeName(record);
        BandUrlData band = deserializeBandUrlData(record);
        int releaseYear = deserializeReleaseYear(record);

        return new RecordUrlData(deserializedMuid, name, band, releaseYear);
    }

}
