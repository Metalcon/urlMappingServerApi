package de.metalcon.urlmappingserver.api.requests;

import java.util.Map;

import de.metalcon.domain.EntityType;

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
    private EntityType entityType;

    /**
     * create URL mapping resolve request
     * 
     * @param urlPathVars
     *            path variables in URL
     * @param entityType
     *            type of the entity to resolve
     */
    public UrlMappingResolveRequest(
            Map<String, String> urlPathVars,
            EntityType entityType) {
        if (urlPathVars == null) {
            throw new IllegalArgumentException("url path vars must not be null");
        }
        if (entityType == null) {
            throw new IllegalArgumentException("entity type must not be null");
        }

        this.urlPathVars = urlPathVars;
        this.entityType = entityType;
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
    public EntityType getEntityType() {
        return entityType;
    }

}
