package de.metalcon.urlmappingserver.api.requests.registration;

import org.json.simple.JSONObject;

import de.metalcon.domain.EntityType;
import de.metalcon.domain.Muid;
import de.metalcon.urlmappingserver.api.ZeroMQSerialization;

public class UserUrlData extends EntityUrlData {

    private String firstName;

    private String lastName;

    public UserUrlData(
            Muid muid,
            String firstName,
            String lastName) {
        super(muid, concatNames(firstName, lastName));
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static String concatNames(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static String serialize(UserUrlData user) {
        return serializeUserToJson(user).toJSONString();
    }

    @SuppressWarnings("unchecked")
    static JSONObject serializeUserToJson(UserUrlData user) {
        JSONObject object = EntityUrlData.serializeEntityToJson(user);
        object.put(RegistrationRequestSerialization.User.FIRST_NAME,
                user.getFirstName());
        object.put(RegistrationRequestSerialization.User.LAST_NAME,
                user.getLastName());
        return object;
    }

    protected static String deserializeFirstName(JSONObject user) {
        return ZeroMQSerialization.Helper.getString(
                RegistrationRequestSerialization.User.FIRST_NAME, user);
    }

    protected static String deserializeLastName(JSONObject user) {
        return ZeroMQSerialization.Helper.getString(
                RegistrationRequestSerialization.User.LAST_NAME, user);
    }

    public static UserUrlData deserialize(JSONObject user) {
        return deserialize(user, null);
    }

    public static UserUrlData
        deserialize(JSONObject user, Muid deserializedMuid) {
        if (deserializedMuid == null) {
            deserializedMuid = deserializeMuid(user, EntityType.USER);
        }
        String firstName = deserializeFirstName(user);
        String lastName = deserializeLastName(user);

        return new UserUrlData(deserializedMuid, firstName, lastName);
    }

}
