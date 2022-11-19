package DAO;

import config.DBConnection;
import model.Post;
import model.User;
import model.User_Post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserPostDAO {


    public static List<User_Post> getAllPosts(){
        List<User_Post> list = new ArrayList<>();


            try{
                Connection con = DBConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM chat_db.posts");


                while(rs.next()){
                  User_Post user_post = new User_Post();
                  User user = new User();
                  Post post = new Post();

                    post.setId(rs.getInt("id"));
                    post.setPost_text(rs.getString("post_text"));
                    post.setUser_id(rs.getInt("users_id"));
                    post.setPosted_at(rs.getString("posted_at"));


                    user = UserDAO.getUserById(post.getUser_id());

                    user_post.setPost(post);
                    user_post.setUser(user);

                    if (!(user.isBanned())) { list.add(user_post); }
                }

                con.close();

            }catch(Exception e){e.printStackTrace();}
        return list;
    }


}
