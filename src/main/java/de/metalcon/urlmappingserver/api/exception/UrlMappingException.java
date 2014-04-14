package de.metalcon.urlmappingserver.api.exception;

/**
 * basic exception for URL mapping server
 * 
 * @author sebschlicht
 * 
 */
public abstract class UrlMappingException extends RuntimeException {

    private static final long serialVersionUID = -3191645752771601248L;

    /**
     * create basic URL mapping exception
     * 
     * @param message
     *            detailed error message
     */
    public UrlMappingException(
            String message) {
        super(message);
    }

}
