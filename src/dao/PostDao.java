package dao;

import DBHelper.SQLHelper;
import entity.Activity;
import entity.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDao {
    public ArrayList<Post> queryPostByPass(){//仅测试查询结果，未修改sql语句！！！
        ArrayList<Post> list =new ArrayList<>();

        Post p=null;
        String sql="select * from Post where Pass='"+"Y"+"'";// where Pass='"+"N"+"'
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                p=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                list.add(p);
            }
        }catch(Exception e){}

        return list;
    }

    public Boolean addPost(String cid,String cname,String title,String tText) throws SQLException {
        Boolean flag=false;
        int rs=SQLHelper.executeUpdate("insert into Post(CID,CName,Title,Ttext) values('"+cid+"','"+cname+"','"+title+"','"+tText+"')");
        System.out.print(rs);
        if (rs!=0)
            flag=true;
        return flag;
    }
}

