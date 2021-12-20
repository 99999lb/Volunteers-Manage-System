package com.vms;

import dao.AccountDao;
import dao.CustomerDao;
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
                    ArrayList<Customer> list=c.queryCustomerByPass();
                    request.getSession().setAttribute("list",list);
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

            case "returnlogin"://退出账号并回到登录界面
                request.getSession().removeAttribute("cid");
                request.getSession().removeAttribute("aid");
                response.sendRedirect("Login.jsp");
                break;


            case "passp"://审核通过（个人信息）
                String pid1=request.getParameter("pid");
                boolean pflag1=c.passIDMessage(pid1);
                ArrayList<Customer> list=c.queryCustomerByPass();
                request.getSession().setAttribute("list",list);

                if(pflag1)
                    response.sendRedirect("admin.jsp?passp=yes");
                else
                    response.sendRedirect("admin.jsp?passp=no");
                break;
            case "errorp"://审核不通过（个人信息）
                String pid2=request.getParameter("pid");
                boolean pflag2=c.noPassIDMessage(pid2);
                list=c.queryCustomerByPass();
                request.getSession().setAttribute("list",list);

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
                String peoNum=request.getParameter("peoNum");
                if(Integer.parseInt(peoNum.trim())>0)
                    response.sendRedirect("sign.jsp?aRep=true");
                else
                    response.sendRedirect("actInfo.jsp?aRep=false");
                break;

            case "vpost":
                break;

            case "fact":
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
