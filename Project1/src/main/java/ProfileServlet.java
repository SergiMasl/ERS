import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        request.getRequestDispatcher("navbar.html").include(request, response);
        String name= request.getParameter("username");

        out.println("<br> Welcome " + name);
        out.println(" <br> <a href='ViewAllPending'> View All Pending</a>");
        out.println(" <br> <a href='printAllEmployees'> Print All Employees</a>");
        out.println(" <br> <a href='update.html'> WHat This dO</a>");



/*
        Cookie[] cookies =  request.getCookies();
        if(cookies!=null){
            String username = cookies[0].getValue();
            if(!username.equals("") || username!=null){
                out.println("<h1>Welcome to profile</h1>");
                out.println("<h1>Welcome "+ username+ "</h1>");
            }else{
                out.println("please do the login page and login first");
                request.getRequestDispatcher("/login").include(request, response);
            }
            out.close();
        }*/

    }
}
