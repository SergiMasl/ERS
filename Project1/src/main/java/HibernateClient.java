import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Honestly im not sure why i made this kinda confused.
//scared to delete it

public class HibernateClient {
    public static void main(String[] args) {
        Configuration config = new Configuration();

        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");

        SessionFactory sf = config.buildSessionFactory();

    }
}
