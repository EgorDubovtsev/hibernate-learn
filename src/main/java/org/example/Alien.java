package org.example;

import javax.persistence.*;

@Entity
@Table(name = "aliens")
public class Alien {
    @Id
    private int aid; //annotation @Transient for ignore column
    @Column(name = "alien_name")
    private String aname;
    @Column(name = "alien_color")
    private String color;
    @Embedded
    private Home home;

    /**
     * annotation @Embedded will separate object on columns
     * and insert into "aliens" row
     *
     */
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
