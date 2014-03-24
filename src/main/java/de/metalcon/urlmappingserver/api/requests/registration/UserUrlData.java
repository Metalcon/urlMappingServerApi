package de.metalcon.urlmappingserver.api.requests.registration;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

/**
 * URL information for user entities
 * 
 * @author sebschlicht
 * 
 */
public class UserUrlData extends EntityUrlData {

    private static final long serialVersionUID = 4505905094818111661L;

    /**
     * user's first name
     */
    protected String firstName;

    /**
     * user's last name
     */
    protected String lastName;

    /**
     * create user URL information
     * 
     * @param muid
     *            user ID
     * @param firstName
     *            user's first name
     * @param lastName
     *            user's last name
     * @throws IllegalArgumentException
     *             if MUID or first name or last name <b>null</b> or MUID type
     *             mismatching
     */
    public UserUrlData(
            Muid muid,
            String firstName,
            String lastName) {
        super(false, MuidType.USER, muid, concatNames(firstName, lastName));

        if (firstName == null) {
            throw new IllegalArgumentException("first name must not be null");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("last name must not be null");
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return user's last name
     */
    public String getLastName() {
        return lastName;
    }

}
