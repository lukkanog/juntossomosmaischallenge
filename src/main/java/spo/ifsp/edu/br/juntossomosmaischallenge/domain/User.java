package spo.ifsp.edu.br.juntossomosmaischallenge.domain;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.helpers.E164PhoneNumberFormatHelper;

import javax.persistence.*;

import java.util.List;
import java.util.Date;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UserType type;
    private char gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nameId", referencedColumnName = "id")
    private Name name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timezoneId", referencedColumnName = "id")
    private Timezone timezone;
    private String email;
    private Date birthday;
    private Date registered;
    
    @ElementCollection
    @CollectionTable(name = "telephoneNumber")
    private List<String> telephoneNumbers;

    @ElementCollection
    @CollectionTable(name = "mobilePhoneNumber")
    private List<String> mobilePhoneNumbers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pictureId", referencedColumnName = "id")
    private Picture picture;
    private String nationality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = Character.toLowerCase(gender);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistered() {
        return this.registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public List<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        for (int i = 0; i < telephoneNumbers.size(); i++) {
            telephoneNumbers.set(i, E164PhoneNumberFormatHelper.format(telephoneNumbers.get(i)));
        }

        this.telephoneNumbers = telephoneNumbers;
    }

    public List<String> getMobilePhoneNumbers() {
        return mobilePhoneNumbers;
    }

    public void setMobilePhoneNumbers(List<String> mobilePhoneNumbers) {
        for (int i = 0; i < mobilePhoneNumbers.size(); i++) {
            mobilePhoneNumbers.set(i, E164PhoneNumberFormatHelper.format(mobilePhoneNumbers.get(i)));
        }

        this.mobilePhoneNumbers = mobilePhoneNumbers;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
