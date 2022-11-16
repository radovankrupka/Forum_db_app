package controllers;

import DAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String operacia = request.getParameter("operacia");
        if (operacia == null) {
            //zobrazNeopravnenyPristup(out);

            return;
        }
        else if (operacia.equals("login")) {
            if (UserDAO.checkUserExists(request.getParameter("nickname"), request.getParameter("pwd"))) {
                System.out.println("SUCCESS!!");
            } else {
                //wrong credentials
                System.out.println("wrong cred");
            }
        }





    }
}
