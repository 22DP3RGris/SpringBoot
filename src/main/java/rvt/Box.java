package rvt;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Box implements Packable{

    private double maxWeight;
    private String name;
    private ArrayList<Packable> items = new ArrayList<>();

    public Box(double maxWeight, String name) {
        this.maxWeight = maxWeight;
        this.name = name;
    }

    public void add(Packable packable) {
        items.add(packable);
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Packable item : items) {
            if (weight + item.weight() > maxWeight){
                System.out.println(item.toString() + " | is too heavy!");
                continue;
            }
            weight += item.weight();
        }
        return Math.round(weight * 100) / 100;
    }

    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }

}
