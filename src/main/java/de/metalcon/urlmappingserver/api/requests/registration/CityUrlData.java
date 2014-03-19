package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;

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
     */
    public CityUrlData(
            Muid muid,
            String name) {
        super(muid, name);
    }

}
