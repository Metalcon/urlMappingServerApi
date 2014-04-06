package de.metalcon.urlmappingserver.api.requests.registration;

import java.io.Serializable;

import de.metalcon.domain.Muid;
import de.metalcon.domain.UidType;

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
	 * @param UidType
	 *            MUID type the URL information is for
	 * @param muid
	 *            entity MUID
	 * @param name
	 *            entity name
	 * @throws IllegalArgumentException
	 *             if MUID or name <b>null</b> or MUID type mismatching while
	 *             empty MUID flag unset
	 */
	public EntityUrlData(final boolean allowEmptyMuid, final UidType UidType,
			final Muid muid, final String name) {
		if (allowEmptyMuid && muid == null) {
			this.muid = Muid.getEmptyType(UidType);
			this.name = null;
		} else {
			if (muid == null) {
				throw new IllegalArgumentException("MUID must not be null");
			}
			if (muid.getType() != UidType) {
				throw new IllegalArgumentException("MUID type must be \""
						+ UidType + "\" (was \"" + muid.getType() + "\")");
			}
			if (name == null) {
				throw new IllegalArgumentException("name must not be null");
			}

			this.muid = muid;
			this.name = name;
		}
	}

	/**
	 * create basic entity URL information
	 * 
	 * @param allowEmptyMuid
	 *            empty MUID flag
	 * @param UidType
	 *            MUID type the URL information is for
	 * @param muid
	 *            entity MUID
	 * @throws IllegalArgumentException
	 *             if MUID <b>null</b> or MUID type mismatching while empty MUID
	 *             flag unset
	 */
	protected EntityUrlData(final boolean allowEmptyMuid,
			final UidType UidType, final Muid muid) {
		if (allowEmptyMuid && muid == null) {
			this.muid = Muid.getEmptyType(UidType);
		} else {
			if (muid == null) {
				throw new IllegalArgumentException("MUID must not be null");
			}
			if (muid.getType() != UidType) {
				throw new IllegalArgumentException("MUID type must be \""
						+ UidType + "\" (was \"" + muid.getType() + "\")");
			}

			this.muid = muid;
		}
		name = null;
	}

	/**
	 * @return true if entity is anonymous
	 */
	public boolean hasEmptyMuid() {
		return getMuid().isEmpty();
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
	public static String concatNames(final String firstName,
			final String lastName) {
		return firstName + " " + lastName;
	}

}
