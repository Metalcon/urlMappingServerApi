package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

/**
 * URL information for band entities
 * 
 * @author sebschlicht
 * 
 */
public class BandUrlData extends EntityUrlData {

    private static final long serialVersionUID = -7235814801174019771L;

    /**
     * create band URL information
     * 
     * @param muid
     *            band ID
     * @param name
     *            band name
     */
    public BandUrlData(
            Muid muid,
            String name) {
        super(MuidType.BAND, muid, name);
    }

}
