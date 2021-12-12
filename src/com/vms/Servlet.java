package com.vms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dao.AccountDao;

@WebServlet(name="servelt",urlPatterns = "/servlet")
public class Servlet extends HttpServlet {
    AccountDao ad=new AccountDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        switch (name){
            case "al":
                response.sendRedirect("ALogin.jsp");
                break;
            case "cl":
                response.sendRedirect("CLogin.jsp");
                break;
            case "regis":
                response.sendRedirect("register.jsp");
                break;

            case "clogin":
                String id=request.getParameter("cn");
                String pwd=request.getParameter("cp");
                boolean flag= false;
                try {
                   flag = ad.CheckCustomer(id,pwd);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if(flag){
                    //传入个人信息，跳转到主页
                    response.sendRedirect("CLogin.jsp?errorc=no");//仅作为测试用例，非最终验证结果
                }
                else
                    response.sendRedirect("CLogin.jsp?errorc=yes");
                break;

            case "alogin":
                String aid=request.getParameter("an");
                String apwd=request.getParameter("ap");
                boolean aflag= false;
                try {
                    aflag = ad.CheckAdmin(aid,apwd);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if(aflag){
                    //传入个人信息，跳转到主页
                    response.sendRedirect("ALogin.jsp?errora=no");//仅作为测试用例，非最终验证结果
                }
                else
                    response.sendRedirect("ALogin.jsp?errora=yes");
                break;

            case "cregister":
                String cid=request.getParameter("cid");
                String cpwd=request.getParameter("cpwd");
                String cc=request.getParameter("cc");
                boolean rf=false;

                if(!cc.equals(cpwd)){
                    response.sendRedirect("register.jsp?errorR=y1");
                }

                else {
                    try {
                        rf=ad.addCustomer(cid,cpwd);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    if(rf){
                        response.sendRedirect("CLogin.jsp?errorc=regis");
                    }
                    else
                        response.sendRedirect("register.jsp?errorR=y2");
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
