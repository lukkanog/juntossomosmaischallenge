package spo.ifsp.edu.br.juntossomosmaischallenge.domain;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;

public class Location {
    private Region region;
    private String street;
    private String city;
    private String state;
    private String postcode;
    private Coordinates coordinates;

    public Location(String street, String city, String state, String postcode, Coordinates coordinates) {
        this.region = getRegionFromCoordinates(coordinates);
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    private static Region getRegionFromCoordinates(Coordinates coordinates) {
        return null;
    }
}
