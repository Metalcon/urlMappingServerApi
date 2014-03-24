package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

/**
 * URL information for city entities
 * 
 * @author sebschlicht
 * 
 */
public class CityUrlData extends EntityUrlData {

    private static final long serialVersionUID = -385662030616628951L;

    /**
     * create city URL information
     * 
     * @param muid
     *            city ID
     * @param name
     *            city name
     * @throws IllegalArgumentException
     *             if MUID or name <b>null</b> or MUID type mismatching
     */
    public CityUrlData(
            Muid muid,
            String name) {
        super(MuidType.CITY, muid, name);
    }

}
