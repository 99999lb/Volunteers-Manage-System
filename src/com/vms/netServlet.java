package com.vms;

import dao.ActivityDao;
import entity.Activity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

@WebServlet(name = "netServlet",urlPatterns = "/netServlet")
public class netServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String sort= (String) request.getSession().getAttribute("sort");
        String pass= (String) request.getSession().getAttribute("pass");
        String aid= (String) request.getSession().getAttribute("aid");
        String cusid= (String) request.getSession().getAttribute("cid");
        ActivityDao ad=new ActivityDao();
        boolean flag=false;

        switch (name){
            case "acts":
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
                break;

            case "news":
                break;

            case "pac":
                break;

            case "forum":
                break;

            case "download":
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
