package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

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
     */
    public GenreUrlData(
            Muid muid,
            String name) {
        super(MuidType.GENRE, muid, name);
    }

}
