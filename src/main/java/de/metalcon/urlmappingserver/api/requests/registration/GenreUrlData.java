package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.UidType;

/**
 * URL information for genre entities
 * 
 * @author sebschlicht
 * 
 */
public class GenreUrlData extends EntityUrlData {

    private static final long serialVersionUID = -8678056610527852471L;

    /**
     * create genre URL information
     * 
     * @param muid
     *            genre ID
     * @param name
     *            genre name
     * @throws IllegalArgumentException
     *             if MUID or name <b>null</b> or MUID type mismatching
     */
    public GenreUrlData(
            Muid muid,
            String name) {
        super(false, UidType.GENRE, muid, name);
    }

}
