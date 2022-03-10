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

public class ViewAllPending extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

   //     request.getRequestDispatcher("navbar.html").include(request, response);
        Configuration config = new Configuration();
        config.configure("hibernate2.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        List<UserTransactionsObj> employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Pending'", UserTransactionsObj.class).list();
        for(UserTransactionsObj e : employeeList){
            out.println();
            out.println( e.getAmount());
            out.println( e.getDate() );
            out.println( e.getisAprove() );
            out.println( e.getNote() );
            out.println("<br>");
        }

        session.close();

    }
}
