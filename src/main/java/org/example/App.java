package org.example;

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
        Home home = new Home();

        home.setHomeId("21");
        home.setStreet("Main street");
        alienNew.setAid(6);
        alienNew.setAname("Bob");
        alienNew.setColor("pink");
       alienNew.setHome(home);


        Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

        SessionFactory sf = cfg.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alienNew);

        alienFetched = (Alien) session.get(Alien.class,3);
        tx.commit();
        System.out.println(alienFetched);

    }
}
