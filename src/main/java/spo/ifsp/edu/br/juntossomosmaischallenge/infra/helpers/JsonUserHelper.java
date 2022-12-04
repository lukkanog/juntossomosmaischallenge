package spo.ifsp.edu.br.juntossomosmaischallenge.infra.helpers;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.builders.UserBuilder;

public class JsonUserHelper {
     public static List<User> getUsersFromJson(String json) throws Exception {
        List<User> users = new ArrayList<>();

        JSONArray usersNode = new JSONObject(json).getJSONArray("results");

        for (int i = 0; i < usersNode.length(); i++) {
            JSONObject jsonUser = usersNode.getJSONObject(i);

            User user = new UserBuilder()
                    .withGender(jsonUser.getString("gender").charAt(0))
                    .withName(
                        jsonUser.getJSONObject("name").getString("first"),
                        jsonUser.getJSONObject("name").getString("last"),
                        jsonUser.getJSONObject("name").getString("title")
                    )
                    .withLocation(
                        jsonUser.getJSONObject("location").getString("street"),
                        jsonUser.getJSONObject("location").getString("city"),
                        jsonUser.getJSONObject("location").getString("state"),
                        String.valueOf(jsonUser.getJSONObject("location").getInt("postcode")),
                        jsonUser.getJSONObject("location").getJSONObject("coordinates").getString("latitude"),
                        jsonUser.getJSONObject("location").getJSONObject("coordinates").getString("longitude")
                    )
                    .withTimezone(
                        jsonUser.getJSONObject("location").getJSONObject("timezone").getString("offset"),
                        jsonUser.getJSONObject("location").getJSONObject("timezone").getString("description")
                    )
                    .withEmail(jsonUser.getString("email"))
                    .withBirthday(DateHelper.getDateFromString(jsonUser.getJSONObject("dob").getString("date")))
                    .withRegistered(DateHelper.getDateFromString(jsonUser.getJSONObject("registered").getString("date")))
                    .withTelephoneNumbers(jsonUser.getString("phone").split(";"))
                    .withMobilePhoneNumbers(jsonUser.getString("cell").split(";"))
                    .withPicture(
                        jsonUser.getJSONObject("picture").getString("large"),
                        jsonUser.getJSONObject("picture").getString("medium"),
                        jsonUser.getJSONObject("picture").getString("thumbnail")
                    )
                    .withNationality("BR")
                    .build();

            users.add(user);
        }

        return users;
    }
}
