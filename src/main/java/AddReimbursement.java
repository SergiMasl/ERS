import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AddReimbursement extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String amount = req.getParameter("amount");
        String pin = req.getParameter("pin");
        String date = req.getParameter("date");
        String note = req.getParameter("note");

        out.println("Done");

        out.close();
        App app = new App(amount, pin, date, note);
        app.add("addreim");
    }

}
