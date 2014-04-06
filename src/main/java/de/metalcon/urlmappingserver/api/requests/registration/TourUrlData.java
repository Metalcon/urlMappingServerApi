package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.UidType;

/**
 * URL information for tour entities
 * 
 * @author sebschlicht
 * 
 */
public class TourUrlData extends EntityUrlData {

    private static final long serialVersionUID = -1667464688180293594L;

    /**
     * create tour URL information
     * 
     * @param muid
     *            tour ID
     * @throws IllegalArgumentException
     *             if MUID <b>null</b> or MUID type mismatching
     */
    public TourUrlData(
            Muid muid) {
        super(false, UidType.TOUR, muid);
    }

}
