package com.rev.admin;

import com.rev.User;
import com.rev.UserTransactionsObj;
import jakarta.servlet.RequestDispatcher;
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


public class VerifyRequest extends HttpServlet {
    String isAprove;
    String isPending;
    String user;
    String amountWanted;
    String oldAmount;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String updateId = request.getParameter("updateId");
        String adminNote = request.getParameter("adminNote");
        String verify = request.getParameter("Verify");

        switch (verify){
            case "0": isAprove = "Disapprove";
            break;
            case "1": isAprove = "Approve";
            break;
        }

        Configuration config = new Configuration();

        config.configure("hibernate2.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserTransactionsObj> objTrans = session.createQuery("from UserTransactionsObj u where u.id='"+ updateId+ "'", UserTransactionsObj.class).list();

        for (UserTransactionsObj u : objTrans) {
            user = u.getUserName();
            amountWanted = u.getAmount();
            isPending = u.getisAprove();
        }


        if(isPending.equals("Pending")){
            String qryString = "update UserTransactionsObj u set u.isAprove='" + isAprove + "', u.adminNote='" + adminNote + "' where u.id='" + updateId + "'";
            Query query = session.createQuery(qryString);
            int count = query.executeUpdate();
            transaction.commit();

            //Change amount
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

            //Change Amount if Approved
            String qryString2 = "update User u set u.amount='" + x + "' where u.userName='"+user+"'";
            Query query2 = session2.createQuery(qryString2);
            int count2 = query2.executeUpdate();

            transaction2.commit();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("com.rev.admin.AdminHome");
            requestDispatcher.forward(request, response);

            session2.clear();
            session.close();
            session.clear();
            session.close();
        } else {
            request.getRequestDispatcher("wrongIsNotPending.html").include(request, response);
            request.getRequestDispatcher("com.rev.admin.AdminHome").include(request, response);
            session.clear();
            session.close();
        }

    }
}
