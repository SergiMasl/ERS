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

public class ViewAllResolved extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

        //As of right now this function is checking everything that isnt pending
        //All though its a boolean in the database if we only use the numbers 0 and 1
        //it will still be able to modify the boolean column
        request.getRequestDispatcher("navbar.html").include(request, response);
        System.out.println("ProjectSTARTED");
        Configuration config = new Configuration();
        //Assuming that were checking a seperate database for this
        int notResolved = 0;
        int isResolved = 1;

        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create factory
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        List<Employee> employeeList = (List<Employee>)session.createQuery("from Employee", Employee.class).list();
        out.println("<br> Right now its checking everything that isnt Resolved");
        for(Employee e : employeeList){
            out.println("<br>");
            //change get pending to get resolved
            if(e.getIsResolved() == notResolved) {
                out.println();
                out.println(e.getUser_name());
                out.println(e.getUser_pass());
                out.println(e.getId());
                out.println(e.getEmail());
                out.println(e.getName());
                out.println(e.getBalance());
                out.println();
            }
        }

        session.close();

    }
}
