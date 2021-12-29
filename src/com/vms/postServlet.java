package com.vms;

import dao.CustomerDao;
import dao.PostDao;
import dao.ReplyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "postServlet",urlPatterns = "/postServlet")
public class postServlet extends HttpServlet {
       PostDao pd=new PostDao();
       ReplyDao rd=new ReplyDao();
       CustomerDao cd=new CustomerDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String cid= request.getParameter("cid");
        String cname=request.getParameter("cname");
        String title=request.getParameter("title");
        String tText=request.getParameter("tText");
        String tid= request.getParameter("tid");
        String rep=request.getParameter("rep");

        switch(name){
            case "addPost":
                boolean pr=false;
                try {
                    pr=pd.addPost(cid,cname,title,tText);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(pr)
                    response.sendRedirect("post.jsp");
                else
                    response.sendRedirect("main.jsp");
                break;
            case "deletep":
                try {
                    pd.deletePost(tid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                response.sendRedirect("post.jsp");
                break;
            case "reply":
                request.getSession().setAttribute("tid",tid);
                Boolean rr=false;
                try {
                    if(rep!=null)
                    rr=rd.addReply(Integer.parseInt(tid),cid,cname,rep);
                } catch (SQLException throwables) {
                }
                response.sendRedirect("reply.jsp");

                break;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
