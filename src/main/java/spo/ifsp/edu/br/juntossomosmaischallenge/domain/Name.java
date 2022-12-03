package spo.ifsp.edu.br.juntossomosmaischallenge.domain;

public class Name {
    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }
    
    private String title;
    private String first;
    private String last;

    @Override
    public String toString() {
        return title + " " + first + " " + last;
    }
}
