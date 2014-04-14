package de.metalcon.urlmappingserver.api.responses;

import de.metalcon.api.responses.SuccessResponse;

/**
 * response: MUID was successfully resolved to URL
 * 
 * @author sebschlicht
 * 
 */
public class MuidResolvedResponse extends SuccessResponse {

    private static final long serialVersionUID = 6839536627177880096L;

    /**
     * URL the MUID was resolved to
     */
    protected String url;

    /**
     * create MUID resolved response
     * 
     * @param url
     *            URL the MUID was resolved to
     */
    public MuidResolvedResponse(
            String url) {
        super();
        this.url = url;
    }

    /**
     * @return URL the MUID was resolved to
     */
    public String getUrl() {
        return url;
    }

}
