package com.blino.app;

import com.blino.models.Car;
import com.blino.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

/**
 * 03.02.2020
 * Application
 *
 * @author RombyGuIde (Home Software Engineering Platform)
 * @version v1.0
 */

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto","update");
        configuration.setProperty("hibernate.show_sql", "true");

        configuration.addResource("User.hbm.xml");
        configuration.addAnnotatedClass(Car.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        User user = session.createQuery("from User user where id = 1", User.class).getSingleResult();
        session.beginTransaction();
        session.save(new User("Alex", "Stregabor", 50));
        session.getTransaction().commit();
        System.out.println(user);

        List<Car> car = session.createQuery("from Car car", Car.class).getResultList();

        int i = 0;
    }
}
