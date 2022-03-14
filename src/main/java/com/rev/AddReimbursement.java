package com.rev;

import com.rev.App;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

public class AddReimbursement extends HttpServlet {
    String username;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String amount = req.getParameter("amount");
        String date = req.getParameter("date");
        String note = req.getParameter("note");

        System.out.println("project started...");
        Configuration conf = new Configuration();
        conf.configure("hibernate2.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            username = cookies[0].getValue();
        }

        UserTransactionsObj emp = new UserTransactionsObj();

//        emp.setId(ThreadLocalRandom.current().nextInt());
        emp.setuserName(username);
        emp.setAmount(amount);
        emp.setDate(date);
        emp.setNote(note);
        emp.setisAprove("Pending");
        emp.setAdminNote("");

        req.getRequestDispatcher("com.rev.Profile").include(req, res);

        session.save(emp);
        trans.commit();

        session.clear();
        session.close();
    }
}


