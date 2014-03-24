package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

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
     * @throws IllegalArgumentException
     *             if MUID or name <b>null</b> or MUID type mismatching
     */
    public TourUrlData(
            Muid muid,
            String name,
            int year) {
        super(false, MuidType.TOUR, muid, name);
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
