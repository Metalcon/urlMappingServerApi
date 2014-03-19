package de.metalcon.urlmappingserver.api.requests.registration;

import java.io.Serializable;

import de.metalcon.domain.Muid;

/**
 * basic URL information for entities
 * 
 * @author sebschlicht
 * 
 */
public abstract class EntityUrlData implements Serializable {

    private static final long serialVersionUID = -4401073729083016529L;

    /**
     * entity MUID
     */
    protected Muid muid;

    /**
     * entity name
     */
    protected String name;

    /**
     * create basic entity URL information
     * 
     * @param muid
     *            entity MUID
     * @param name
     *            entity name
     */
    public EntityUrlData(
            Muid muid,
            String name) {
        this.muid = muid;
        this.name = name;
    }

    /**
     * @return entity MUID
     */
    public Muid getMuid() {
        return muid;
    }

    /**
     * @return entity name
     */
    public String getName() {
        return name;
    }

    /**
     * concatenate human readable names
     * 
     * @param firstName
     *            first name
     * @param lastName
     *            last name
     * @return human readable full name
     */
    public static String concatNames(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

}
