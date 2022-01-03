package com.vms;

import dao.CustomerDao;
import dao.PostDao;
import dao.ReplyDao;
import entity.Customer;

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
        String cid=(String) request.getSession().getAttribute("cid");
        String cname=request.getParameter("cname");
        String title=request.getParameter("title");
        String tText=request.getParameter("tText");
        String tid=request.getParameter("tid");
        String rep=request.getParameter("rep");
        String aid=(String) request.getSession().getAttribute("aid");
        String pass=(String) request.getSession().getAttribute("pass");
        String rid=request.getParameter("rid");
        Customer c=cd.queryCustomerByCID(cid);

        switch(name){
            case "addPost":
                String pid=request.getParameter("pid");
                String pname=request.getParameter("pname");
                boolean pr=false;
                try {
                    pr=pd.addPost(pid,pname,title,tText);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(pr)
                        response.sendRedirect("post.jsp?p=y");
                else
                        response.sendRedirect("post.jsp?p=n");


                break;
            case "deletep":
                try {
                    pd.deletePost(tid);
                    response.sendRedirect("customer.jsp");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            case "deleter":
                String cidR=request.getParameter("cidR");
                System.out.println("cid"+cid);
                System.out.println("aid"+aid);
                System.out.println("cidR"+cidR);
                if(cid==null&&aid==null){
                    System.out.println("deleter1");
                    response.sendRedirect("main.jsp?errorm=nologin");
                }
                    else if(cid!=null&&!pass.trim().equals("Y")){
                        System.out.println("deleter2.1");
                        response.sendRedirect("reply.jsp?ra=p");
                    }
                    else if(cidR.equals(cid)||aid!=null) {
                        try {
                            System.out.println("deleter2.2");
                            rd.deleteReply(rid);
                            response.sendRedirect("reply.jsp");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                    else{
                        response.sendRedirect("reply.jsp?ra=dn");
                }
                break;

            case "reply":
                request.getSession().setAttribute("tid",tid);
                String cn=request.getParameter("cn");
                System.out.println(cn);
                Boolean rr=false;
                try {
                    if(rep!=null){
                        if(aid!=null){
                            rr=rd.addReply(Integer.parseInt(tid),aid,cn,rep);}
                        else{
                            rr=rd.addReply(Integer.parseInt(tid),cid,cn,rep);
                        }
                    }
                } catch (SQLException throwables) {
                }
                    response.sendRedirect("reply.jsp");
                break;


            case "post":
                System.out.print("cid"+cid);
                System.out.print("aid"+aid);
                if(aid==null&&cid==null){
                    System.out.println("post1");
                    response.sendRedirect("main.jsp?errorm=nologin");
                }
                else{
                    if(cid!=null) {
                        if (!pass.trim().equals("Y")) {
                            System.out.println("post2.1");
                            response.sendRedirect("post.jsp?pa=p");
                        }
                        else if(c.getCname()==null){
                            System.out.println("post2.2");
                            response.sendRedirect("customer.jsp?upd=update");
                        }
                        else{
                            System.out.println("post2.3");
                            response.sendRedirect("addPost.jsp");
                        }
                    }
                    else{
                        System.out.println("post2.3");
                        response.sendRedirect("addPost.jsp");
                    }
                }
                break;

            case "dPost":
                response.sendRedirect("displayPost.jsp");
                break;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
