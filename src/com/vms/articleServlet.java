package com.vms;

import dao.ArticleDao;
import entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "articleServlet",urlPatterns = "/articleServlet")
public class articleServlet extends HttpServlet {
    ArticleDao atd=new ArticleDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String aid= (String) request.getSession().getAttribute("aid");
        String name=request.getParameter("name");
        String title=request.getParameter("title");
        String tText=request.getParameter("tText");
        String tid=request.getParameter("tid");

        switch(name) {
            case "addnews":
                boolean pr = false;
                try {
                    pr = atd.addNews(aid,title,tText);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (pr) {
                    ArrayList<Article> atclist=atd.queryNews();
                    request.getSession().setAttribute("atclist",atclist);
                    response.sendRedirect("news.jsp?p=y&n=n");
                }
                else
                    response.sendRedirect("admin.jsp?passp=nn");
                break;
            case "deletenews":
                pr=false;
                try {
                    pr=atd.deletePost(tid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                if(pr) {
                    response.sendRedirect("admin.jsp?passp=dny");
                    ArrayList<Article> atclist=atd.queryNews();
                    request.getSession().setAttribute("atclist",atclist);
                }
                else
                    response.sendRedirect("admin.jsp?passp=dnn");
                break;

            case "addpac":
                pr = false;
                try {
                    pr = atd.addPacs(aid,title,tText);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (pr) {
                    ArrayList<Article> atclist=atd.queryPacs();
                    request.getSession().setAttribute("atclist",atclist);
                    response.sendRedirect("news.jsp?p=py&n=p");
                }
                else
                    response.sendRedirect("admin.jsp?passp=pnn");
                break;
            case "deletepac":
                pr=false;
                try {
                    pr=atd.deletePac(tid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                if(pr) {
                    response.sendRedirect("admin.jsp?passp=dny");
                    ArrayList<Article> paclist=atd.queryPacs();
                    request.getSession().setAttribute("paclist",paclist);
                }
                else
                    response.sendRedirect("admin.jsp?passp=dnn");
                break;

            case "browse":
                String sort=request.getParameter("s");
                ArrayList<Article> actlist;
                switch (sort){
                    case "n":
                        actlist=atd.queryNewsByTid(tid);
                        break;

                    case "p":
                        actlist=atd.queryPacsByTid(tid);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + sort);
                }
                request.getSession().setAttribute("actlist",actlist);
                response.sendRedirect("browse.jsp?s="+sort);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
