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
    boolean approve = false;
    String user;
    String amountWanted;
    String oldAmount;
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
                approve = true;
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
        for (UserTransactionsObj u : objTrans) {
            user = u.getUserName();
            amountWanted = u.getAmount();

        }

        String qryString = "update UserTransactionsObj u set u.isAprove='" + isAprove + "', u.adminNote='" + adminNote + "' where u.id='" + updateId + "'";
        Query query = session.createQuery(qryString);
        int count = query.executeUpdate();
        transaction.commit();
        session.clear();


        session.close();


        //Change Amount if Approved

        if(approve){
            out.println("<p>Status set to: " + approve + "</p>");
            Configuration config2 = new Configuration();
            config2.configure("hibernate.cfg.xml");
            SessionFactory factory2 = config2.buildSessionFactory();
            Session session2 = factory2.openSession();
            Transaction transaction2 = session2.beginTransaction();

            List<User> tList = session2.createQuery("from User u where u.userName='" + user + "'", User.class).list();
            for (User u : tList) {
                oldAmount = u.getAmount();
            }
            Double newAmount = Double.valueOf(oldAmount) + Double.valueOf(amountWanted);

            String x = String.valueOf(newAmount);

            String qryString2 = "update User u set u.amount='" + x + "' where u.userName='"+user+"'";
            out.println("<p>fdsfsd</p>");
            Query query2 = session2.createQuery(qryString2);
            int count2 = query2.executeUpdate();
            out.println("<p>fdsfs 333 432d</p>");

            transaction2.commit();
            session2.clear();
            out.println("<p>fd5323sfsd</p>");

        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("com.rev.admin.AdminHome");
        requestDispatcher.forward(request, response);
        out.println("<form action='com.rev.admin.AdminHome' method='post'><input type='submit' value='Back'>");

    }
}
