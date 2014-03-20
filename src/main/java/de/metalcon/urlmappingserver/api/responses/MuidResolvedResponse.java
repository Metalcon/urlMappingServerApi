package de.metalcon.urlmappingserver.api.responses;

import de.metalcon.api.responses.SuccessResponse;
import de.metalcon.domain.Muid;

/**
 * response: MUID was resolved successfully
 * 
 * @author sebschlicht
 * 
 */
public class MuidResolvedResponse extends SuccessResponse {

    private static final long serialVersionUID = -4562632902314567529L;

    /**
     * resolved MUID
     */
    protected Muid muid;

    /**
     * create MUID resolved response
     * 
     * @param muid
     *            resolved MUID
     */
    public MuidResolvedResponse(
            Muid muid) {
        super();
        this.muid = muid;
    }

    /**
     * @return resolved MUID
     */
    public Muid getMuid() {
        return muid;
    }

}
