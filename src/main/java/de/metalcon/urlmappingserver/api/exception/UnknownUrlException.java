package de.metalcon.urlmappingserver.api.exception;

/**
 * failed to resolve URL to MUID
 * 
 * @author sebschlicht
 * 
 */
public class UnknownUrlException extends UrlMappingException {

    private static final long serialVersionUID = -2346967110464984673L;

    /**
     * create unknown URL exception
     * 
     * @param message
     *            detailed error message
     */
    public UnknownUrlException(
            String message) {
        super(message);
    }

}
