package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

/**
 * URL information for venue entities
 * 
 * @author sebschlicht
 * 
 */
public class VenueUrlData extends EntityUrlData {

    private static final long serialVersionUID = 4882678233111916935L;

    /**
     * city the venue is located in<br>
     * may be <b>null</b>: unknown
     */
    protected CityUrlData city;

    /**
     * create venue URL information
     * 
     * @param muid
     *            venue ID
     * @param name
     *            venue name
     * @param city
     *            city the venue is located in<br>
     *            may be <b>null</b>
     * @throws IllegalArgumentException
     *             if MUID or name <b>null</b> or MUID type mismatching
     */
    public VenueUrlData(
            Muid muid,
            String name,
            CityUrlData city) {
        super(MuidType.VENUE, muid, name);
        this.city = city;
    }

    /**
     * @return city the venue is located in<br>
     *         may be <b>null</b>
     */
    public CityUrlData getCity() {
        return city;
    }

}
