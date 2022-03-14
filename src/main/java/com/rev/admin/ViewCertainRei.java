package com.rev.admin;

import com.rev.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewCertainRei extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("updateID");

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        List<User> employeeList = (List<User>)session.createQuery("from User u where u.userName='" + userName + "'", User.class).list();

        if(employeeList.size() == 0) {
            request.getRequestDispatcher("wrongId.html").include(request, response);
            request.getRequestDispatcher("certainReim.html").include(request, response);
        } else{
            for(User e : employeeList) {
                request.getRequestDispatcher("navbar.html").include(request, response);

                out.println("<link rel='stylesheet' href='css/usersView.css'>");
                out.println("<div class='users_contener spaceUser'>" +
                        "               <h2>Users:</h2>" +
                        "               <div class='input-wrap-user'>" +
                        "                   <p class='input-money-text_name'>Employee Name: </p>" +
                        "                    <div>|</div>" +
                        "                    <p class='input-money-text_role'>Position:  </p>" +
                        "                   <div>|</div>" +
                        "                   <p class='input-money-text_email'>Email: </p>" +
                        "                    <div>|</div>" +
                        "                    <p class='input-money-text_phone'>Phone: </p>" +
                        "                    <div>|</div>" +
                        "                    <p class='input-money-text_balance'>Balance: </p>" +
                        "                    <div>|</div>" +
                        "                    <p class='input-money-text_adress'>Address: </p>" +
                        "                       <p class='input-money-text_username'>UserName: </p>" +
                        "        </div></div>");

                out.println("<div class='users_contener'>" +
                        "        <div class='input-wrap-user'>" +
                        "            <p class='input-money-text_name'>"+e.getname()+" </p>" +
                        "             <div>|</div>" +
                        "             <p class='input-money-text_name'>"+e.getrole()+"  </p>" +
                        "            <div>|</div>" +
                        "            <p class='input-money-text_name'><a class='user_link' href='email:"+e.getemail()+"'>"+e.getemail()+"</a> </p>" +
                        "             <div>|</div>" +
                        "             <p class='input-money-text_name'><a class='user_link' href='tel:"+e.getphone()+"'>"+e.getphone()+"</a> </p>" +
                        "             <div>|</div>" +
                        "             <p class='input-money-text_name'>"+e.getAmount()+" </p>" +
                        "             <div>|</div>" +
                        "             <p class='input-money-text_adress'>"+e.getadress()+" </p>" +
                        "             <p class='input-money-text_name'>"+e.getuserName()+" </p>" +
                        "        </div>" +
                        "    </div>");

                out.println("<link rel='stylesheet' href='css/footer.css'>");
                out.println("<footer class='footer_wrap'>" +
                        "    <form  action='com.rev.admin.CheckTransIndivid' method='post' class='footer-viewCertainReiSub'>" +
                        "            <img class='fviewCertainReiSub-img' class='footer-img' src='css/svg/approve.svg'>" +
                        "            <p class='footer'>View Approve</p>" +
                        "        <input type='hidden' name='approve' value='approve'><input type='hidden' name='uname' value='"+userName+"'>" +
                        "        <input class='viewCertainReiSub' type='submit' value=''>" +
                        "    </form>" +
                        "    <form  action='com.rev.admin.CheckTransIndivid' method='post' class='footer-viewCertainReiSub'>" +
                        "            <img class='fviewCertainReiSub-img' class='footer-img' src='css/svg/pending.svg'>" +
                        "            <p class='footer'>View Pending</p>" +
                        "        <input type='hidden' name='pending' value='pending'><input type='hidden' name='uname' value='"+userName+"'>" +
                        "        <input class='viewCertainReiSub' type='submit' value=''>" +
                        "    </form>" +
                        "    <form  action='com.rev.admin.CheckTransIndivid' method='post' class='footer-viewCertainReiSub'>" +
                        "            <img class='fviewCertainReiSub-img' class='footer-img' src='css/svg/disapprove.svg'>" +
                        "            <p class='footer'>View Disprove</p>" +
                        "        <input type='hidden' name='disapprove' value='disapprove'><input type='hidden' name='uname' value='"+userName+"'>" +
                        "        <input class='viewCertainReiSub' type='submit' value=''>" +
                        "    </form>" +
                        "    <form  action='com.rev.admin.CheckTransIndivid' method='post' class='footer-viewCertainReiSub'>" +
                        "        <img class='fviewCertainReiSub-img' src='css/svg/verify.svg'>" +
                        "        <p class='footer'>View All Reimbursements</p>" +
                        "        <input type='hidden' name='all' value='all'><input type='hidden' name='uname' value='"+userName+"'> " +
                        "        <input class='viewCertainReiSub' type='submit' value=''>" +
                        "    </form>" +
                        "</footer>");



                out.println("<form>dsdssds</form>");
            }

        }


        session.close();
    }
}
