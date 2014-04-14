package de.metalcon.urlmappingserver.api.requests;

import java.util.Map;

import de.metalcon.domain.UidType;

/**
 * request: resolve URL to MUID
 * 
 * @author sebschlicht
 * 
 */
public class ResolveUrlRequest extends UrlMappingRequest {

    private static final long serialVersionUID = -8896029228990786870L;

    /**
     * path variables in URL
     */
    private Map<String, String> urlPathVars;

    /**
     * type of the entity to resolve
     */
    private UidType UidType;

    /**
     * create URL resolve request
     * 
     * @param urlPathVars
     *            path variables in URL
     * @param UidType
     *            type of the entity to resolve
     */
    public ResolveUrlRequest(
            Map<String, String> urlPathVars,
            UidType UidType) {
        if (urlPathVars == null) {
            throw new IllegalArgumentException("url path vars must not be null");
        }
        if (UidType == null) {
            throw new IllegalArgumentException("entity type must not be null");
        }

        this.urlPathVars = urlPathVars;
        this.UidType = UidType;
    }

    /**
     * @return path variables in URL
     */
    public Map<String, String> getUrlPathVars() {
        return urlPathVars;
    }

    /**
     * @return type of the entity to resolve
     */
    public UidType getUidType() {
        return UidType;
    }

}
