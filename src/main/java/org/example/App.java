package org.example;

import org.example.aliens.Alien;
import org.example.stud.n.laptop.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.Random;


public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(reg);
        Session session = sf.openSession();
        session.beginTransaction();

        Random r = new Random();
//fill the table
//        for (int i=1;i<=50;i++){
//            Student student = new Student();
//            student.setRollno(i);
//            student.setName("Name "+i);
//            student.setMarks(r.nextInt(100));
//            session.save(student);
//        }
/**
 * Student below it is Entity name,
 * for the filtering use field names
 *
 * */
        Query q = session.createQuery("from Student where marks>50");
        Query qSelectOnlyOne = session.createQuery("from Student where rollno=7");
        List<Student> students = q.list();
        Student student = (Student) qSelectOnlyOne.uniqueResult();
        System.out.println("ONLY ONE "+ student);
        for(Student s:students){
            System.out.println(s);
        }

        session.getTransaction().commit();


    }
}
