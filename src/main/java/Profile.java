import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Profile extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        req.getRequestDispatcher("nav.html").include(req, res);
        String name= req.getParameter("username");

        out.println("Welcome "+ name);
        out.println(" <a href='addReimbure.html'>Add Reimbursement</a>");
        out.println(" <a href='AllReimbursement'>Look your Reimbursement</a>");

    }
}
