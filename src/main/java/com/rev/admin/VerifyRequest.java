package com.rev.admin;

import com.rev.User;
import com.rev.UserTransactionsObj;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
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


public class VerifyRequest extends HttpServlet {
    String isAprove;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String Verify = request.getParameter("Verify");
        switch (Verify) {
            case "0":
                isAprove = "Disapprove";
                break;
            case "1":
                isAprove = "Approve";
                break;
        }

        String updateId = request.getParameter("updateId");
        String adminNote = request.getParameter("adminNote");

        Configuration config = new Configuration();

        config.configure("hibernate2.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserTransactionsObj> objTrans = session.createQuery("from UserTransactionsObj", UserTransactionsObj.class).list();

        String qryString = "update UserTransactionsObj u set u.isAprove='" + isAprove + "', u.adminNote='" + adminNote + "' where u.id='" + updateId + "'";
        Query query = session.createQuery(qryString);
        int count = query.executeUpdate();
        transaction.commit();
        session.clear();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("com.rev.admin.AdminHome");
        requestDispatcher.forward(request, response);

        session.close();
        out.close();
    }
}
