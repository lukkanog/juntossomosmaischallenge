package spo.ifsp.edu.br.juntossomosmaischallenge.domain;

public class Timezone {
    private String offset;
    private String description;

    public Timezone(String offset, String description) {
        this.offset = offset;
        this.description = description;
    }
}
