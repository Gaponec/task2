package servlets;

import services.DataManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(DataManager.instance().makeAuthentication(login,password)){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("Authorized: "+login);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Unauthorized");
        }
    }
}
