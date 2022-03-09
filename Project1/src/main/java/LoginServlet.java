import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // when user enter correct details


        System.out.println("ProjectSTARTED");
        Configuration config = new Configuration();

        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create factory
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        List<Employee> employeeList = (List<Employee>)session.createQuery("from Employee", Employee.class).list();

        for(Employee e : employeeList) {

            if (username.equals(e.getUser_name()) && password.equals(e.getUser_pass()))
            {


                out.println("<br>You are successfully logged In");
                out.println("<br>Welcome " + e.getName());
                out.println();

            }
        }
    /*    if(username.equals("admin") && password.equals("123")){
            out.println("You are successfully logged In");
            out.println("<br>Welcome "+ username);

            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);

        }else{
            out.println("Sorry! invalid details");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.include(request, response);
        } */
        out.close();

    }

}