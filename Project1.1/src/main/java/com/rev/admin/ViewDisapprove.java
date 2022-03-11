package com.rev.admin;

import com.rev.UserTransactionsObj;
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

public class ViewDisapprove extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

   //     request.getRequestDispatcher("navbar.html").include(request, response);
        Configuration config = new Configuration();
        config.configure("hibernate2.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        out.println("<h1> Disapproved Reimbursement Requests </h1>");
        List<UserTransactionsObj> employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Disapprove'", UserTransactionsObj.class).list();
        for(UserTransactionsObj e : employeeList){
            out.println();
            out.println("Request ID: " + e.getId() + "<br>");
            out.println("Account Username: " + e.getUserName() + "<br>");
            out.println( "Amount: " + e.getAmount() + "<br>");
            out.println( "Date: " + e.getDate() + "<br>");
            out.println( "Status: " + e.getisAprove() + "<br>");
            out.println( "Employee Note: " + e.getNote() + "<br>");
            out.println( "Admin Note: " + e.getAdminNote() + "<br>");
            out.println("<br>");
        }

        session.close();

    }
}
