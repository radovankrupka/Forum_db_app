package controllers;

import DAO.PostDAO;
import model.Post;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/save")
public class SavePost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Post post = new Post();
        User user = new User();

        user = (User) request.getSession().getAttribute("user");

        post.setUser_id(user.getId());
        post.setPost_text(request.getParameter("post-text"));


        PostDAO.savePost(post);

        request.getSession().removeAttribute("act");

        response.sendRedirect("home");
    }
}
