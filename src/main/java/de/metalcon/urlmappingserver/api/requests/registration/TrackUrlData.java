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
     * band that released the track<br>
     * may be <b>null</b>: record set, unknown
     */
    protected BandUrlData band;

    /**
     * record containing the track<br>
     * may be <b>null</b>: not existing, unknown
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
     *            if <b>null</b> the band of the record is taken, if record was
     *            set
     * @param record
     *            record containing the track<br>
     *            may be <b>null</b>
     * @param trackNumber
     *            track number within record<br>
     *            may be zero
     */
    public TrackUrlData(
            Muid muid,
            String name,
            BandUrlData band,
            RecordUrlData record,
            int trackNumber) {
        super(MuidType.TRACK, muid, name);
        this.band = band;
        this.record = record;
        this.trackNumber = trackNumber;
    }

    /**
     * @return band that released the track<br>
     *         may be <b>null</b>
     */
    public BandUrlData getBand() {
        if (band == null && record != null) {
            return record.getBand();
        }
        return band;
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
