package com.vms;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "download",urlPatterns ="download")
public class downloadServlet extends HttpServlet {
    private ServletConfig config;
    public void init(ServletConfig config) throws ServletException{
        this.config=config;
    }

    public ServletConfig getServletConfig(){
        return config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String fname=request.getParameter("fname");
        String fsort=request.getParameter("fsort");
        String result=fname+"."+fsort;
        System.out.println(result);
        SmartUpload smartUpload=new SmartUpload();
        smartUpload.initialize(config,request,response);
        smartUpload.setContentDisposition(null);
        try{
            smartUpload.downloadFile("D:/upload/"+result);
        }catch(SmartUploadException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
