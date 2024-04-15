package com.questionario.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.questionario.entities.User;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		 SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try{
          session.beginTransaction();
          User user = new User("José Ryan", "joseryan@gmail.com", "password123");
          session.persist(user);
          session.getTransaction().commit();
        }catch(Exception e){
          if(session.getTransaction() != null){
            session.getTransaction().rollback();
          }
          e.printStackTrace();
        } finally {
          session.close();
        }
	}

}
