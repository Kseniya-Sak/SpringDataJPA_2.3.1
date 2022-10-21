package web.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import web.model.User;

import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/my_db?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    private static SessionFactory factory;

    static {
        Properties prop= new Properties();
        prop.setProperty("hibernate.connection.url", URL);
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty("hibernate.connection.username", USERNAME);
        prop.setProperty("hibernate.connection.password", PASSWORD);
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        factory = new Configuration()
                .addProperties(prop)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
    public static void close() {
        factory.close();
    }
}
