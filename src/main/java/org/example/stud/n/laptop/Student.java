package org.example.stud.n.laptop;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private int rollno;
    private String name;
    private int marks;
    @ManyToMany(mappedBy = "students")//field in Laptop
    private List<Laptop> laptops = new ArrayList<Laptop>();

    /**
     * will  be created table laptop_student
     * where will storing student PK and laptop PK
     * !ManyToMany
     */
    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
