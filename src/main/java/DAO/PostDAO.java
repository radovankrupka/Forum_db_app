package DAO;

import config.DBConnection;
import model.Post;
import model.User;

import java.sql.*;

public class PostDAO {

    public static Post getPostById(int id){
        Post post = new Post();

        try {


            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            String sql = " select  id, post_text,users_id FROM posts WHERE id = '"+ id +"'" ;
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            System.out.println(rs.getInt("id"));
            post.setId(rs.getInt("id"));
            post.setPost_text(rs.getString("post_text"));
            post.setUser_id(rs.getInt("users_id"));
            post.setPosted_at(rs.getString("posted_at"));

            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return post;
        }
        return post;
    }

    public static void savePost(Post post){

        try{
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO posts (post_text, users_id) values (?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString (1, post.getPost_text());
            preparedStmt.setInt (2, post.getUser_id());

            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}


    }


    public static void removePost(String post_id) {

        try{
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate ("DELETE FROM posts WHERE id = "+ post_id );
            con.close();

        }catch(Exception e){e.printStackTrace();}


    }
}
