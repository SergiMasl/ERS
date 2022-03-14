package com.rev.transactins;

import com.rev.UserTransactionsObj;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Approve extends HttpServlet {
String uname;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Cookie[] cookies =  req.getCookies();
        if(cookies!=null){
            uname = cookies[0].getValue();
        }

        System.out.println("project started...");
        Configuration conf = new Configuration();
        conf.configure("hibernate2.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        List<UserTransactionsObj> tList = (List<UserTransactionsObj>) session.createQuery("from UserTransactionsObj u where u.userName='" + uname + "' and u.isAprove='Approve'", UserTransactionsObj.class).list();


        req.getRequestDispatcher("navbarUser.html").include(req, res);
        req.getRequestDispatcher("footer.html").include(req, res);
        out.println("<link rel='stylesheet' href='css/reimbursemts.css'>");

        out.println("<div class='contener2'>" +
                "        <h2>All Reimbursements</h2>" +
                "        <div class='input-wrap-money'>" +
                "            <p class='input-money-text_amount'>Amount of Reimburses: </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_date'>Date:  </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_note'>Note: </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_isAprove'>Status: </p>" +
                "        </div>" +
                "    </div>");
        for(UserTransactionsObj u: tList){
            out.println("<div class='contener3'><div class='input-wrap-money'>" +
                    "            <p class='input-money-text_amount'>"+u.getAmount()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_date'>"+u.getDate()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_note'>"+u.getNote()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_isAprove'>"+u.getisAprove()+"</p>" +
                    "        </div></div>");
        }
        req.getRequestDispatcher(" ").include(req, res);
        session.close();
    }
}