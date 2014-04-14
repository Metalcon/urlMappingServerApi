package de.metalcon.urlmappingserver.api.responses;

import de.metalcon.api.responses.SuccessResponse;
import de.metalcon.domain.Muid;

/**
 * response: URL was successfully resolved to MUID
 * 
 * @author sebschlicht
 * 
 */
public class UrlResolvedResponse extends SuccessResponse {

    private static final long serialVersionUID = -4562632902314567529L;

    /**
     * MUID the URL was resolved to
     */
    protected Muid muid;

    /**
     * create URL resolved response
     * 
     * @param muid
     *            MUID the URL was resolved to
     */
    public UrlResolvedResponse(
            Muid muid) {
        super();
        this.muid = muid;
    }

    /**
     * @return MUID the URL was resolved to
     */
    public Muid getMuid() {
        return muid;
    }

}
