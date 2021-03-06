package com.vms;

import dao.ActivityDao;
import dao.ArticleDao;
import dao.JoinActsDao;
import entity.Activity;
import entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

@WebServlet(name = "netServlet",urlPatterns = "/netServlet")
public class netServlet extends HttpServlet {
    ActivityDao ad=new ActivityDao();
    JoinActsDao jad=new JoinActsDao();
    ArticleDao atd=new ArticleDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String sort= (String) request.getSession().getAttribute("sort");
        String pass= (String) request.getSession().getAttribute("pass");
        String aid= (String) request.getSession().getAttribute("aid");
        String cusid= (String) request.getSession().getAttribute("cid");
        boolean flag=false;

        switch (name){
            case "acts"://转向志愿活动模块
                ArrayList<Activity> passalist=ad.AllPassActivities();
                request.getSession().setAttribute("passalist",passalist);
                response.sendRedirect("acts.jsp");
                break;

            case "creatact":
                if(aid!=null)
                    response.sendRedirect("acts.jsp?ca=admin");
                else {
                    if(cusid==null)
                        response.sendRedirect("CLogin.jsp?errorc=nologin");
                    else {
//                    System.out.println(pass.equals("Y"));
//                    System.out.println(sort.equals("C"));
                        if(!pass.trim().equals("Y"))
                            response.sendRedirect("acts.jsp?ca=p");
                        else {
                            if(sort.trim().equals("P"))
                                response.sendRedirect("acts.jsp?ca=ebs");
                            else if(sort.trim().equals("C"))
                                response.sendRedirect("ActSub.jsp");
                        }
                    }
                }
                break;

            case "subact":
                String cid=request.getParameter("actcid");
                String actid=request.getParameter("actid");
                String actn=request.getParameter("actn");
                String as=request.getParameter("as");
                String p=request.getParameter("p");
                String st=request.getParameter("st");
                String et=request.getParameter("et");
                String srt=request.getParameter("srt");
                String ert=request.getParameter("ert");
                String dur=request.getParameter("dur");
                String pnum=request.getParameter("pnum");
                String abrif=request.getParameter("abrif");
                String ps="N";
                Activity a=new Activity(cid,actid,actn,as,p,st,et,srt,ert,dur,pnum,abrif,ps);

                try {
                    flag=ad.addActivity(a);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(flag)
                    response.sendRedirect("acts.jsp?ca=sucs");
                else
                    response.sendRedirect("ActSub.jsp?ec=err");
                break;

            case "join":
                cusid= (String) request.getSession().getAttribute("cid");
                String jaid=request.getParameter("jaid");
                int jnum= Integer.parseInt(request.getParameter("jnum"));
                aid= (String) request.getSession().getAttribute("aid");
                flag=false;

                if(aid!=null)//是否为管理员
                    response.sendRedirect("acts.jsp?ja=adm");
                else {//是否为用户
                    if(cusid==null)//用户是否登录
                        response.sendRedirect("CLogin.jsp?errorc=nologin");
                    else {
                        if(!pass.trim().equals("Y"))//是否通过审核
                            response.sendRedirect("acts.jsp?ja=np");
                        else {
                            if(sort.trim().equals("C"))//是否为团队用户
                                response.sendRedirect("acts.jsp?ja=c");
                            else {
                                if(jnum>jad.JoinCountByID(jaid)){//活动是否满员

                                    try {
                                        flag=jad.JoinAct(cusid,jaid);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }

                                    if(flag)
                                        response.sendRedirect("acts.jsp?ja=y");
                                    else
                                        response.sendRedirect("acts.jsp?ja=n");
                                }
                                else
                                    response.sendRedirect("CLogin.jsp?errorc=surpass");
                            }
                        }
                    }
                }
                break;
            case "quit":
                cusid= (String) request.getSession().getAttribute("cid");
                String qaid=request.getParameter("qaid");
                flag=false;

                try {
                    flag=jad.QuitAct(cusid,qaid);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(flag)
                    response.sendRedirect("acts.jsp?ja=qy");
                else
                    response.sendRedirect("acts.jsp?ja=qn");
                break;

            case "news"://转向新闻报道模块
                ArrayList<Article> atclist=atd.queryNews();
                request.getSession().setAttribute("atclist",atclist);
                response.sendRedirect("news.jsp?n=n");
                break;

            case "pac":
                atclist=atd.queryPacs();
                request.getSession().setAttribute("atclist",atclist);
                response.sendRedirect("news.jsp?n=p");
                break;

            case "forum"://转向志愿者论坛模块
                response.sendRedirect("post.jsp");
                break;

            case "download"://转向文件下载模块
                response.sendRedirect("downloadFiles.jsp");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
