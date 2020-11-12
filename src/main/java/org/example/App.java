package org.example;

import org.example.aliens.Alien;
import org.example.stud.n.laptop.Laptop;
import org.example.stud.n.laptop.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App {
    public static void main(String[] args) {
        Alien alienFetched;
        Alien alienNew = new Alien();

        alienNew.setAid(6);
        alienNew.setAname("Bob");
        alienNew.setColor("pink");
        Home home = new Home();

        home.setHomeId("21");
        home.setStreet("Main street");
        alienNew.setHome(home);


        Laptop laptop = new Laptop();
        laptop.setLid(2);
        laptop.setLname("MAC");

        Student student = new Student();
        student.setMarks(4);
        student.setRollno(3);
        student.setName("Polly");
        student.getLaptops().add(laptop);
        Configuration cfg = new Configuration().configure()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

        SessionFactory sf = cfg.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        session.save(alienNew);
        session.save(student);
        session.save(laptop);

        alienFetched = (Alien) session.get(Alien.class,3);
        tx.commit();
        System.out.println(alienFetched);

    }
}
