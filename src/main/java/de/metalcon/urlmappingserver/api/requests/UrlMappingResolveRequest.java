package de.metalcon.urlmappingserver.api.requests;

import java.util.Map;

import de.metalcon.domain.MuidType;

/**
 * request: resolve URL to MUID
 * 
 * @author sebschlicht
 * 
 */
public class UrlMappingResolveRequest extends UrlMappingRequest {

    private static final long serialVersionUID = -8896029228990786870L;

    /**
     * path variables in URL
     */
    private Map<String, String> urlPathVars;

    /**
     * type of the entity to resolve
     */
    private MuidType muidType;

    /**
     * create URL mapping resolve request
     * 
     * @param urlPathVars
     *            path variables in URL
     * @param muidType
     *            type of the entity to resolve
     */
    public UrlMappingResolveRequest(
            Map<String, String> urlPathVars,
            MuidType muidType) {
        if (urlPathVars == null) {
            throw new IllegalArgumentException("url path vars must not be null");
        }
        if (muidType == null) {
            throw new IllegalArgumentException("entity type must not be null");
        }

        this.urlPathVars = urlPathVars;
        this.muidType = muidType;
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
    public MuidType getMuidType() {
        return muidType;
    }

}
