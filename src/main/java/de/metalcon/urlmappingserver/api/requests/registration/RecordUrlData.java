package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;

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
     * create record URL information
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

    /**
     * @return band that released the record<br>
     *         may be <b>null</b>: multiple bands, unknown
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
