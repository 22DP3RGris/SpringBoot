package rvt;

import java.util.ArrayList;
import java.util.Iterator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employees {

    private ArrayList<Person> employees = new ArrayList<>();

    public void add(Person personToAdd)
    {
        employees.add(personToAdd);
    }

    public void add(ArrayList<Person> peopleToAdd){
        for (Person person : peopleToAdd){
            add(person);
        }
    }

    public void print(){
        for (Person person : employees){
            System.out.println(person);
        }
    }

    public void print(Education education){
        for (Person person : employees){
            if (person.getEducation().equals(education)){
                System.out.println(person);
            }
        }
    }

    public void fire(Education education){
        Iterator<Person> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
