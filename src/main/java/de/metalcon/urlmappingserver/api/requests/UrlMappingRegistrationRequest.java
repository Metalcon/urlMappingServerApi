package de.metalcon.urlmappingserver.api.requests;

import de.metalcon.urlmappingserver.api.requests.registration.EntityUrlData;

/**
 * request: register a new URL mapping for an entity
 * 
 * @author sebschlicht
 * 
 */
public class UrlMappingRegistrationRequest extends UrlMappingRequest {

    private static final long serialVersionUID = -8451776170663227973L;

    /**
     * URL information for the entity
     */
    private EntityUrlData urlData;

    /**
     * create URL mapping registration request
     * 
     * @param urlData
     *            URL information for the entity
     */
    public UrlMappingRegistrationRequest(
            EntityUrlData urlData) {
        this.urlData = urlData;
    }

    /**
     * @return URL information for the entity
     */
    public EntityUrlData getUrlData() {
        return urlData;
    }

}
