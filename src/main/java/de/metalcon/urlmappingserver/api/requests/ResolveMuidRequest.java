package de.metalcon.urlmappingserver.api.requests;

import de.metalcon.domain.Muid;

/**
 * request: resolve MUID to URL
 * 
 * @author sebschlicht
 * 
 */
public class ResolveMuidRequest extends UrlMappingRequest {

    private static final long serialVersionUID = 5123946463524244300L;

    /**
     * MUID to be resolved
     */
    protected Muid muid;

    /**
     * create MUID resolve request
     * 
     * @param muid
     *            MUID to be resolved
     */
    public ResolveMuidRequest(
            Muid muid) {
        this.muid = muid;
    }

    /**
     * @return MUID to be resolved
     */
    public Muid getMuid() {
        return muid;
    }

}
