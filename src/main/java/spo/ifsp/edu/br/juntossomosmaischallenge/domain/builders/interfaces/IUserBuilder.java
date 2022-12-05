package spo.ifsp.edu.br.juntossomosmaischallenge.domain.builders.interfaces;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;

import java.util.Date;

public interface IUserBuilder {
    IUserBuilder withGender(char gender);
    IUserBuilder withName(String title, String first, String last);
    IUserBuilder withLocation(String street, String city, String state, String postcode, double latitude, double longitude);
    IUserBuilder withTimezone(String offset, String description);
    IUserBuilder withEmail(String email);
    IUserBuilder withBirthday(Date date);
    IUserBuilder withRegistered(Date date);
    IUserBuilder withTelephoneNumbers(String[] telephoneNumbers);
    IUserBuilder withMobilePhoneNumbers(String[] mobilePhoneNumbers);
    IUserBuilder withPicture(String large, String medium, String thumbnail);
    IUserBuilder withNationality(String nationality);
    User build();
}
