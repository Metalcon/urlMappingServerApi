package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class RecordUrlData extends EntityUrlData {

    protected BandUrlData band;

    protected int releaseYear;

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

    @Override
    public boolean equals(Object o) {
        boolean entityEquals = super.equals(o);
        if (entityEquals) {
            RecordUrlData r = (RecordUrlData) o;
            return getBand().equals(r.getBand())
                    && getReleaseYear() == r.getReleaseYear();
        }
        return false;
    }

    public static String serialize(RecordUrlData record) {
        return serializeRecordToJson(record).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeRecordToJson(RecordUrlData record) {
        JSONObject object = EntityUrlData.serializeEntityToJson(record);
        object.put(RegistrationRequestSerialization.Record.BAND,
                BandUrlData.serializeEntityToJson(record.getBand()));
        object.put(RegistrationRequestSerialization.Record.RELEASE_YEAR,
                record.getReleaseYear());
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
