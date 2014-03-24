package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

/**
 * URL information for instrument entities
 * 
 * @author sebschlicht
 * 
 */
public class InstrumentUrlData extends EntityUrlData {

    private static final long serialVersionUID = -2932460810703329508L;

    /**
     * create instrument URL information
     * 
     * @param muid
     *            instrument ID
     * @param name
     *            instrument name
     * @throws IllegalArgumentException
     *             if MUID or name <b>null</b> or MUID type mismatching
     */
    public InstrumentUrlData(
            Muid muid,
            String name) {
        super(MuidType.INSTRUMENT, muid, name);
    }

}
