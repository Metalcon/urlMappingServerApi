package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

/**
 * URL information for track entities
 * 
 * @author sebschlicht
 * 
 */
public class TrackUrlData extends EntityUrlData {

    private static final long serialVersionUID = 4829309992842372145L;

    /**
     * record containing the track<br>
     * may be anonymous
     */
    protected RecordUrlData record;

    /**
     * track number within record<br>
     * may be zero: no record, unknown
     */
    protected int trackNumber;

    /**
     * create track URL information
     * 
     * @param muid
     *            track ID
     * @param name
     *            track name
     * @param band
     *            band that released the track<br>
     *            may be <b>null</b><br>
     *            do only set band if record is null
     * @param record
     *            record containing the track<br>
     *            may be <b>null</b>
     * @param trackNumber
     *            track number within record<br>
     *            may be zero
     * @throws IllegalArgumentException
     *             if MUID or name <b>null</b> or MUID type mismatching or if
     *             band and record set
     */
    public TrackUrlData(
            Muid muid,
            String name,
            BandUrlData band,
            RecordUrlData record,
            int trackNumber) {
        super(true, MuidType.TRACK, muid, name);
        if (band != null && record != null) {
            throw new IllegalArgumentException(
                    "band must not be set if record was set");
        }
        if (record == null) {
            this.record = new RecordUrlData(band);
        } else {
            this.record = record;
        }
        this.trackNumber = trackNumber;
    }

    /**
     * @return record containing the track<br>
     *         may be <b>null</b>
     */
    public RecordUrlData getRecord() {
        return record;
    }

    /**
     * @return track number within record<br>
     *         may be zero
     */
    public int getTrackNumber() {
        return trackNumber;
    }

}
