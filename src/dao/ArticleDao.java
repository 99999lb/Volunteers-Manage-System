package dao;

import DBHelper.SQLHelper;
import entity.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDao {
    public ArrayList<Article> queryNews(){
        ArrayList<Article> list =new ArrayList<>();
        Article p=null;
        String sql="select * from news";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                p=new Article(rs.getString(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)));
                list.add(p);
            }
        }catch(Exception e){}

        return list;
    }

    public ArrayList<Article> queryNewsByTid(String tid){
        ArrayList<Article> list =new ArrayList<>();
        Article p=null;
        String sql="select * from news where NID='"+tid+"'";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                p=new Article(rs.getString(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)));
                list.add(p);
            }
        }catch(Exception e){}

        return list;
    }

    public Boolean addNews(String aid,String title,String tText) throws SQLException {
        Boolean flag=false;
        int rs=SQLHelper.executeUpdate("insert into news(aid,Title,Ttext) values('"+aid+"','"+title+"','"+tText+"')");
        if (rs!=0)
            flag=true;
        return flag;
    }

    public Boolean deletePost(String tid) throws SQLException {
        Boolean flag=false;
        int rs=SQLHelper.executeUpdate("delete from news where NID='"+tid+"'");
        if (rs!=0)
            flag=true;
        return flag;
    }
}
