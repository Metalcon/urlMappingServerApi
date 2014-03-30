package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

/**
 * URL information for event entities
 * 
 * @author sebschlicht
 * 
 */
public class EventUrlData extends EntityUrlData {

    private static final long serialVersionUID = -3249109237520805058L;

    /**
     * create event URL information
     * 
     * @param muid
     *            event ID
     * @throws IllegalArgumentException
     *             if MUID <b>null</b> or MUID type mismatching
     */
    public EventUrlData(
            Muid muid) {
        super(false, MuidType.EVENT, muid);
    }

}
