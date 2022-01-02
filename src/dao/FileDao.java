package dao;

import DBHelper.SQLHelper;
import entity.FileStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FileDao {
    public Boolean addFile(String fileName,String newFileName,int size,String sort) throws SQLException {
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("insert into Filer(FileName,NewFileName,Size,Sort) values('"+fileName+"','"+newFileName+"','"+size+"','"+sort+"')");
        if (rs!=0)
            flag=true;
        return flag;
    }

    public ArrayList<FileStore> queryFile(){
        ArrayList<FileStore> flist =new ArrayList<>();

        FileStore f=null;
        String sql="select * from Filer";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                f=new FileStore(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),
                        Integer.parseInt(rs.getString(5)),rs.getString(6),rs.getString(7),rs.getString(8));
                flist.add(f);
            }
        }catch(Exception e){}

        return flist;
    }
}
