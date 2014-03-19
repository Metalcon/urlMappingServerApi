package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;

/**
 * URL information for tour entities
 * 
 * @author sebschlicht
 * 
 */
public class TourUrlData extends EntityUrlData {

    private static final long serialVersionUID = -1667464688180293594L;

    /**
     * year the tour started<br>
     * may be zero: unknown
     */
    protected int year;

    /**
     * create tour URL information
     * 
     * @param muid
     *            tour ID
     * @param name
     *            tour name
     * @param year
     *            year the tour started<br>
     *            may be zero
     */
    public TourUrlData(
            Muid muid,
            String name,
            int year) {
        super(muid, name);
        this.year = year;
    }

    /**
     * @return year the tour started<br>
     *         may be zero
     */
    public int getYear() {
        return year;
    }

}
