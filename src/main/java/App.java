import jakarta.servlet.http.HttpServlet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App extends HttpServlet {
    private int id;
    private String amount;
    private String pin;
    private String date;
    private String note;
    private String username;
    private String password;

    public App(String amount, String pin, String date, String note) {
        this.amount = amount;
        this.date = date;
        this.pin = pin;
        this.note = note;
    }

    public App(String username, String password) {
        this.username = username;
        this.password = password;
    }

     void add(String toDo){
         System.out.println("project started...");
         Configuration conf = new Configuration();
         conf.configure("hibernate.cfg.xml");
         SessionFactory factory = conf.buildSessionFactory();
         Session session = factory.openSession();
         Transaction trans = session.beginTransaction();

        if(toDo.equals("addreim")){
            User emp = new User();

            emp.setId(2);
            emp.setAmount(amount);
            emp.setDate(date);
            emp.setNote(note);

            session.save(emp);
            trans.commit();
        }




        session.close();

    }
}
