package de.metalcon.urlmappingserver.api.requests;

import de.metalcon.urlmappingserver.api.requests.registration.EntityUrlData;

public class UrlMappingRegistrationRequest extends UrlMappingRequest {

    private static final long serialVersionUID = -8451776170663227973L;

    private EntityUrlData urlData;

    public UrlMappingRegistrationRequest(
            EntityUrlData urlData) {
        this.urlData = urlData;
    }

    public EntityUrlData getUrlData() {
        return urlData;
    }

}
