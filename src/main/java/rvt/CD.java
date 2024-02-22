package rvt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CD implements Packable{

    private String author;
    private String title;
    private int year;

    public CD(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    @Override
    public double weight() {
        return 0.1;
    }

    public String toString() {
        return author + ": " + title + " (" + year + ")";
    }
    
}
