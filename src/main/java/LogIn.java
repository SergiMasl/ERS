import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;

public class LogIn extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        App app = new App(username, password);
        app.add("Login");

        ///
        System.out.println("project started...");
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

 //       List<User> userList = session.createQuery("from User where username= \"" +username +"\"", User.class).list();
//        Predicate[] predicates = new Predicate[2];
//        predicates[0] = cb.equal()

        session.close();




        ///
        if(username.equals("user1") && password.equals("1234")){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Profile");
            requestDispatcher.forward(req, res);
        }else{
            out.println("Sorry invalid username and password");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/logIn.html");
            requestDispatcher.include(req, res);
        }




    }

}
