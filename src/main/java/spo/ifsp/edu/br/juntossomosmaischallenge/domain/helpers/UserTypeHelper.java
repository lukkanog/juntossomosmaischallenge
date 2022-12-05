package spo.ifsp.edu.br.juntossomosmaischallenge.domain.helpers;

import java.util.ArrayList;
import java.util.List;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;

public class UserTypeHelper {
    public static List<UserType> getUserTypesByString(String userTypes) {
        List<UserType> userTypesList = new ArrayList<>();
        if (userTypes != null) {
            String[] userTypesArray = userTypes.split(",");
            for (String userType : userTypesArray) {
                userTypesList.add(UserType.valueOf(userType.toUpperCase()));
            }
        }
        return userTypesList;
    }
}
