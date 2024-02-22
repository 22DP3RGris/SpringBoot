package rvt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book implements Packable {

    private String author;
    private String title;
    private double weight;

    public Book(String author, String title, double weight) {
        this.author = author;
        this.title = title;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    public String toString() {
        return author + ": " + title;
    }

}
