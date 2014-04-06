package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.UidType;

/**
 * URL information for record entities
 * 
 * @author sebschlicht
 * 
 */
public class RecordUrlData extends EntityUrlData {

    private static final long serialVersionUID = -2288914572869215389L;

    /**
     * band that released the record<br>
     * may be <b>null</b>: multiple bands, unknown
     */
    protected BandUrlData band;

    /**
     * release year<br>
     * may be zero
     */
    protected int releaseYear;

    /**
     * create existing record URL information
     * 
     * @param muid
     *            record ID
     * @param name
     *            record name
     * @param band
     *            band that released the record<br>
     *            may be <b>null</b>
     * @param releaseYear
     *            release year<br>
     *            may be zero
     * @throws IllegalArgumentException
     *             if MUID or name <b>null</b> or MUID type mismatching
     */
    public RecordUrlData(
            Muid muid,
            String name,
            BandUrlData band,
            int releaseYear) {
        super(true, UidType.RECORD, muid, name);
        if (band == null) {
            this.band = new BandUrlData();
        } else {
            this.band = band;
        }
        this.releaseYear = releaseYear;
    }

    /**
     * create anonymous record URL information
     * 
     * @param band
     *            band that released the record<br>
     *            may be <b>null</b>
     */
    public RecordUrlData(
            BandUrlData band) {
        this(null, null, band, 0);
    }

    /**
     * @return band that released the record<br>
     *         may be anonymous: multiple bands, unknown
     */
    public BandUrlData getBand() {
        return band;
    }

    /**
     * @return release year<br>
     *         may be zero
     */
    public int getReleaseYear() {
        return releaseYear;
    }

}
