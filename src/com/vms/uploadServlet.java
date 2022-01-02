package com.vms;

import com.jspsmart.upload.SmartUpload;
import dao.FileDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;


@WebServlet(name = "upload",urlPatterns ="upload")
public class uploadServlet extends HttpServlet {
    private ServletConfig config;
    FileDao fd=new FileDao();

    public void init(ServletConfig config) throws ServletException{
        this.config=config;
    }

    public ServletConfig getServletConfig(){
        return config;
    }

    private String createFileUUID(){
        String uuid= UUID.randomUUID().toString();
        return uuid.replaceAll("-","");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        int count=0;
        Boolean fr;
        SmartUpload su=new SmartUpload();//新建一个SmartUpload对象

        try{
            su.initialize(config,request,response);//上传初始化
            su.setAllowedFilesList("doc,docx");//设定上传限制
            su.upload();
            String opttype=su.getRequest().getParameter("opttype");
            if("fileupload".equals(opttype)){
                for(int i=0;i<su.getFiles().getCount();i++){
                    com.jspsmart.upload.File file=su.getFiles().getFile(i);
                    if(file.isMissing())
                        continue;
                    //获取文件属性
                    String fileExt=file.getFileExt();//获取文件扩展名
                    int fileSize=file.getSize();//文件大小
                    String fileName=file.getFileName();//文件名(不含目录信息)
                    String fileClientPath=file.getFilePathName();//文件名(带目录)
                    String curPathId=(String)request.getSession().getAttribute("curPathId");
                    String newFileName=createFileUUID();
                    //写入数据
                    fr=fd.addFile(fileName,newFileName,fileSize,fileExt);
                    out.println(fileName+" "+newFileName+" "+fileSize+" "+fileExt);
                    count++;
                    file.saveAs("D:/upload/"+newFileName+"."+fileExt,su.SAVE_PHYSICAL);
                }
                out.println("共有"+count+"个文件上传成功！");
            }
            else if("filedownload".equals(opttype)){
                String fname=request.getParameter("fname");
                su.setContentDisposition(null);
                su.downloadFile("D:/upload/"+fname);
            }

        }catch(Exception e){
            out.println("Unable to upload the file.<br>");
            out.println("Error:"+e.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
