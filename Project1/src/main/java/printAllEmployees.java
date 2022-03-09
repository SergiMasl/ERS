import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class printAllEmployees extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();


        request.getRequestDispatcher("navbar.html").include(request, response);
        System.out.println("ProjectSTARTED");
        Configuration config = new Configuration();

        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create factory
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        List<Employee> employeeList = (List<Employee>)session.createQuery("from Employee", Employee.class).list();

        out.println("<br>");
        for(Employee e : employeeList){
            out.println();
            out.println( e.getUser_name());
            out.println( e.getUser_pass() );
            out.println( e.getId() );
            out.println( e.getEmail() );
            out.println( e.getName() );
            out.println( e.getBalance() );
            out.println("<br>");
        }

        session.close();

    }
}
