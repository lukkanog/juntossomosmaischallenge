package spo.ifsp.edu.br.juntossomosmaischallenge.domain;


import javax.persistence.*;

@Entity
public class Timezone {
    public Timezone(){}
    
    public Timezone(String offset, String description) {
        this.offset = offset;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "timezoneOffset")
    private String offset;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
