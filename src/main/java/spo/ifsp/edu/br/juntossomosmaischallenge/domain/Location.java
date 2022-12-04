package spo.ifsp.edu.br.juntossomosmaischallenge.domain;

import java.util.UUID;

import javax.persistence.*;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;

@Entity
public class Location {
    public Location(){}
    public Location(String street, String city, String state, String postcode, Coordinates coordinates) {
        this.region = getRegionFromCoordinates(coordinates);
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Region region;
    private String street;
    private String city;
    private String state;
    private String postcode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinatesId", referencedColumnName = "id")
    private Coordinates coordinates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    private static Region getRegionFromCoordinates(Coordinates coordinates) {
        return null;
    }
}
