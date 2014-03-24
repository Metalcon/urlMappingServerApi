package de.metalcon.urlmappingserver.api.requests.registration;

import java.io.Serializable;

import de.metalcon.domain.Muid;
import de.metalcon.domain.MuidType;

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
     * @param allowEmptyMuid
     *            empty MUID flag
     * @param muidType
     *            MUID type the URL information is for
     * @param muid
     *            entity MUID
     * @param name
     *            entity name
     * @throws IllegalArgumentException
     *             if MUID or name <b>null</b> or MUID type
     *             mismatching while empty MUID flag unset
     */
    public EntityUrlData(
            boolean allowEmptyMuid,
            MuidType muidType,
            Muid muid,
            String name) {
        if (allowEmptyMuid && muid == null) {
            this.muid = Muid.EMPTY_MUID;
            this.name = null;
        } else {
            if (muid == null) {
                throw new IllegalArgumentException("MUID must not be null");
            }
            if (muid.getMuidType() != muidType) {
                throw new IllegalArgumentException("MUID type must be \""
                        + muidType + "\" (was \"" + muid.getMuidType() + "\")");
            }
            if (name == null) {
                throw new IllegalArgumentException("name must not be null");
            }

            this.muid = muid;
            this.name = name;
        }
    }

    /**
     * @return true if entity is anonymous
     */
    public boolean hasEmptyMuid() {
        return getMuid().equals(Muid.EMPTY_MUID);
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
