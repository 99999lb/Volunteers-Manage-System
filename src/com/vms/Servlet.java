package com.vms;

import dao.AccountDao;
import dao.ActivityDao;
import dao.CustomerDao;
import dao.PostDao;
import entity.Activity;
import entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="servelt",urlPatterns = "/servlet")
public class Servlet extends HttpServlet {
    AccountDao ad=new AccountDao();
    CustomerDao c=new CustomerDao();
    ActivityDao actd=new ActivityDao();
    PostDao pd=new PostDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        switch (name){
            case "al"://登录方式选择
                response.sendRedirect("ALogin.jsp");
                break;
            case "alogin"://管理员登录验证
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
                    request.getSession().setAttribute("aid",aid);
                    ArrayList<Customer> clist=c.queryCustomerByPass();
                    request.getSession().setAttribute("clist",clist);
                    ArrayList<Activity> alist=actd.queryActivityByPass();
                    request.getSession().setAttribute("alist",alist);
                    response.sendRedirect("admin.jsp");//仅作为测试用例，非最终验证结果
                }
                else
                    response.sendRedirect("ALogin.jsp?errora=yes");
                break;

            case "cl":
                response.sendRedirect("CLogin.jsp");
                break;
            case "clogin"://普通用户登录验证
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
                    request.getSession().setAttribute("cid",id);
                    response.sendRedirect("customer.jsp");
                }
                else
                    response.sendRedirect("CLogin.jsp?errorc=yes");

                break;

            case "returnlogin"://退出账号并回到主界面
                if(request.getSession().getAttribute("cid")!=null) {
                    request.getSession().removeAttribute("cid");
                    request.getSession().removeAttribute("pass");
                    request.getSession().removeAttribute("sort");
                }
                if(request.getSession().getAttribute("aid")!=null)
                    request.getSession().removeAttribute("aid");
                response.sendRedirect("main.jsp");
                break;


            case "passp"://审核通过（个人信息）
                String pid1=request.getParameter("pid");
                boolean pflag1=c.passIDMessage(pid1);
                ArrayList<Customer> clist=c.queryCustomerByPass();
                request.getSession().setAttribute("clist",clist);

                if(pflag1)
                    response.sendRedirect("admin.jsp?passp=yes");
                else
                    response.sendRedirect("admin.jsp?passp=no");
                break;
            case "errorp"://审核不通过（个人信息）
                String pid2=request.getParameter("pid");
                boolean pflag2=c.noPassIDMessage(pid2);
                clist=c.queryCustomerByPass();
                request.getSession().setAttribute("clist",clist);

                if(pflag2)
                    response.sendRedirect("admin.jsp?passp=yes");
                else
                    response.sendRedirect("admin.jsp?passp=no");
                break;

            case "regis":
                response.sendRedirect("register.jsp");
                break;

            case "cregister"://用户注册（仅普通用户）
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

            case "updatecinfo":
                response.sendRedirect("renew.jsp");
                break;

            case "renew"://普通用户更新个人信息
                String rid= (String) request.getSession().getAttribute("cid");
                String rcn=request.getParameter("rcname");
                String rs=request.getParameter("rsex");
                String rsig=request.getParameter("rsig");
                String rp=request.getParameter("rphone");
                String rads=request.getParameter("rads");
                String rsort=request.getParameter("rsort");

                Customer rc=new Customer();
                rc.setCid(rid);rc.setCname(rcn);
                rc.setAddress(rads);rc.setSex(rs);
                rc.setPhone(rp);rc.setSig(rsig);
                rc.setCsort(rsort);rc.setPass("N");
                boolean ref=false;
                try {
                    ref=c.updateCInfo(rc);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if(ref)
                    response.sendRedirect("customer.jsp?upd=true");
                else
                    response.sendRedirect("renew.jsp?upd=false");

                break;

            case "vact":
                response.sendRedirect("actInfo.jsp");
                break;

            case "vactmes":
                response.sendRedirect("actMes.jsp");
                break;

            case "vpost":
                String idofPost= (String) request.getSession().getAttribute("cid");
                String cname=request.getParameter("cname");
                String title=request.getParameter("title");
                String tText=request.getParameter("tText");
                boolean pr=false;
                try {
                    pr=pd.addPost(idofPost,cname,title,tText);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(pr)
                    response.sendRedirect("post.jsp");
                else
                    response.sendRedirect("main.jsp");
                break;

            case "fact":
                response.sendRedirect("joinacts.jsp");
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
