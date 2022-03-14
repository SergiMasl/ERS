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

public class CheckTransIndivid extends HttpServlet {
    List<UserTransactionsObj> employeeList;
    String uname;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

        String approve = request.getParameter("approve");
        String disapprove = request.getParameter("disapprove");
        String pending = request.getParameter("pending");
        String all = request.getParameter("all");
        String uname = request.getParameter("uname");

        Configuration config = new Configuration();
        config.configure("hibernate2.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();


        if(approve != null){
            employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Approve' and u.userName='"+uname+"'", UserTransactionsObj.class).list();
        } else if(disapprove != null){
            employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Disapprove' and u.userName='"+uname+"'", UserTransactionsObj.class).list();
        }  else if(pending != null){
            employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Pending' and u.userName='"+uname+"'", UserTransactionsObj.class).list();
        }else if(all != null){
            employeeList = session.createQuery("from UserTransactionsObj u where u.userName='"+uname+"'", UserTransactionsObj.class).list();
        }

        request.getRequestDispatcher("navbar.html").include(request, response);
        out.println("<link rel='stylesheet' href='css/reimbursemts.css'>");

        out.println("<div class='contener2'>" +
                "        <h2>All Reimbursements</h2>" +
                "        <div class='input-wrap-money'>" +
                "               <p class='input-money-text_user'>ID: </p>" +
                "                <div>|</div>" +
                "               <p class='input-money-text_amount'>Amount of Reimburses: </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_date'>Date:  </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_note'>Note: </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_isAprove'>Status: </p>" +
                "        </div>" +
                "    </div>");
        for(UserTransactionsObj u: employeeList){
            uname = u.getUserName();
            out.println("<div class='contener3'><div class='input-wrap-money'>" +
                    "           <p class='input-money-text_user'>"+u.getId()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_amount'>"+u.getAmount()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_date'>"+u.getDate()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_note'>"+u.getNote()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_isAprove'>"+u.getisAprove()+"</p>" +
                    "        </div></div>");
        }
        out.println("<link rel='stylesheet' href='css/footer.css'>");
        out.println("<footer class='footer_wrap'>" +
                "    <form  action='com.rev.admin.CheckTransIndivid' method='post' class='footer-viewCertainReiSub'>" +
                "            <img class='fviewCertainReiSub-img' class='footer-img' src='css/svg/approve.svg'>" +
                "            <p class='footer'>View Approve</p>" +
                "        <input type='hidden' name='approve' value='approve'><input type='hidden' name='uname' value='"+uname+"'>" +
                "        <input class='viewCertainReiSub' type='submit' value=''>" +
                "    </form>" +
                "    <form  action='com.rev.admin.CheckTransIndivid' method='post' class='footer-viewCertainReiSub'>" +
                "            <img class='fviewCertainReiSub-img' class='footer-img' src='css/svg/pending.svg'>" +
                "            <p class='footer'>View Pending</p>" +
                "        <input type='hidden' name='pending' value='pending'><input type='hidden' name='uname' value='"+uname+"'>" +
                "        <input class='viewCertainReiSub' type='submit' value=''>" +
                "    </form>" +
                "    <form  action='com.rev.admin.CheckTransIndivid' method='post' class='footer-viewCertainReiSub'>" +
                "            <img class='fviewCertainReiSub-img' class='footer-img' src='css/svg/disapprove.svg'>" +
                "            <p class='footer'>View Disprove</p>" +
                "        <input type='hidden' name='disapprove' value='disapprove'><input type='hidden' name='uname' value='"+uname+"'>" +
                "        <input class='viewCertainReiSub' type='submit' value=''>" +
                "    </form>" +
                "    <form  action='com.rev.admin.CheckTransIndivid' method='post' class='footer-viewCertainReiSub'>" +
                "        <img class='fviewCertainReiSub-img' src='css/svg/verify.svg'>" +
                "        <p class='footer'>View All Reimbursements</p>" +
                "        <input type='hidden' name='all' value='all'><input type='hidden' name='uname' value='"+uname+"'> " +
                "        <input class='viewCertainReiSub' type='submit' value=''>" +
                "    </form>" +
                "</footer>");
        session.close();

    }
}

