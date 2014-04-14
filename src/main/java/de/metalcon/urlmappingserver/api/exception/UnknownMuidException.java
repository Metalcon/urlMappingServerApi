package de.metalcon.urlmappingserver.api.exception;

/**
 * failed to resolve MUID to URL
 * 
 * @author sebschlicht
 * 
 */
public class UnknownMuidException extends UrlMappingException {

    private static final long serialVersionUID = 2388083232518181123L;

    /**
     * create unknown MUID exception
     * 
     * @param message
     *            detailed error message
     */
    public UnknownMuidException(
            String message) {
        super(message);
    }

}
