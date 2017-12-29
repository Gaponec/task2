package servlets;

import objects.User;
import services.DataManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String login = request.getParameter("login");
        String pasword = request.getParameter("password");

        DataManager.instance().registerUser(new User(login,pasword));
    }
}
