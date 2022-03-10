import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewCertainRei extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //This comes down to if its pending but just given a certain ID
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

        String updateId = request.getParameter("updateID");
        int upId = Integer.parseInt(updateId);

        //As of right now this function is checking everything that isnt pending
        //All though its a boolean in the database if we only use the numbers 0 and 1
        //it will still be able to modify the boolean column
        request.getRequestDispatcher("navbar.html").include(request, response);
        System.out.println("ProjectSTARTED");
        Configuration config = new Configuration();
        //Assuming that were checking a seperate database for this
        int notPending = 0;
        int Pending = 1;

        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        // create factory
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Employee> employeeList = (List<Employee>)session.createQuery("from Employee", Employee.class).list();
        out.println("<br> Right now its checking for a specific employee");

      /*  String qryString = "select * from Employee e where e.id=" + upId;
        Query query = session.createQuery(qryString);
        int count = query.executeUpdate();

        out.println(count + " Record(s) Updated.");

        out.println("Updating with Query Parameters ");*/

        for(Employee e : employeeList){
            out.println("<br>");
            //change get pending to get resolved
            if(e.getPending() == notPending && e.getId() == upId) {
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

      //  transaction.commit();
       // session.clear();
        //session.close();
        session.close();

    }
}
