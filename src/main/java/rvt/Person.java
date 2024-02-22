package rvt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    
    private String name;
    private Education education;

    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }

    public Education getEducation(){
        return this.education;
    }

    public String toString() {
        return name + ", " + education;
    }
}
