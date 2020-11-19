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
         *  use aliases in join queries
         * */
        Query q = session.createQuery("select rollno,name from Student where marks>50");
        Query qSelectOnlyOne = session.createQuery("select rollno,name from Student where rollno=7");
        List<Object[]> students = (List<Object[]>) q.list(); //This will return list of object arrays
        Object[] student = (Object[]) qSelectOnlyOne.uniqueResult();// if result is unique will be returned one array of object
        System.out.println("ONLY ONE "+ student[0]+" "+student[1]);

        for(Object[] s:students){
            System.out.println(s[0]+" "+s[1]);
        }

        session.getTransaction().commit();


    }
}
