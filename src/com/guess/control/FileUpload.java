package com.guess.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.guess.configurationtool.SetBase;
import com.guess.domain.Information_minute;
import com.guess.domain.Sign;
import com.guess.domain.User_all;
import com.guess.service.dbInformationService;
import com.guess.service.dbInformationServiceImpl;
import com.guess.service.signServic;
import com.guess.service.signServiceImpl;
import com.guess.util.toolsUtil;

public class FileUpload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public FileUpload() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("资料fileuplod");
		
        response.setCharacterEncoding("utf-8");  
        String information_txt=null;
        String information_filename=null;
        String information_type=null;
        String fileName=null;
        
        User_all userall=(User_all)request.getSession().getAttribute("USERALL");//的扫session中的userall
		String user_email=userall.getUser_basic().getUser_email();
		
        //创建information存储对象
        Information_minute information =new Information_minute();
        
        //1、创建一个DiskFileItemFactory工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        
        //2、创建一个文件上传解析器  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        //解决上传文件名的中文乱码  
        upload.setHeaderEncoding("UTF-8");   
        factory.setSizeThreshold(1024 * 1024);//设置内存的临界值为500K  
        File linshi = new File(SetBase.FILE_CACHEPATH);//当超过500K的时候，存到一个临时文件夹中  
        factory.setRepository(linshi);  
         upload.setSizeMax(1024 * 1024 * 100);//设置上传的文件总的大小不能超过100M
        try {  
            // 1. 得到 FileItem 的集合 items  
            List<FileItem> /* FileItem */items = upload.parseRequest(request);  
            // 2. 遍历 items:  
            for (FileItem item : items) {  
                // 若是一个一般的表单域, 打印信息  
                if (item.isFormField()) {  
                    String name = item.getFieldName();  
                    String value = item.getString("utf-8"); 
                    switch (name) {
					case "information_txt":
						information_txt=value;
						break;
					case "filename":
						information_filename=value;
						break;
					case "information_type":
						information_type=value;
						break;
					default:
						break;
					}
                } 
                // 若是文件域则把文件保存到 e:\\files 目录下.  
                else {  
                    fileName = item.getName();  
                    long sizeInBytes = item.getSize();  


                    information.setInformation_size(toolsUtil.getBytes(sizeInBytes));
                    InputStream in = item.getInputStream();  
                    byte[] buffer = new byte[1024];  
                    int len = 0;  
                    
                    String prefix=fileName.substring(fileName.lastIndexOf(".")+1);//获取文件后缀

                    information.setInformation_filename(information_filename);
                    fileName = SetBase.FILE_UPPATH+user_email.substring(0, user_email.indexOf("@"))+"/datafile/"+fileName;//文件最终上传的位置  

                    OutputStream out = new FileOutputStream(fileName);  
                    while ((len = in.read(buffer)) != -1) {  
                        out.write(buffer, 0, len);  
                    }  
                    out.close();  
                    in.close();  
                }  
            } 
            
            //存储到数据库
            information.setUser_email(user_email);
            //创建标记实体
            Sign sign=new Sign();
            
            //创建数据库操作实例\
            signServic signservic=new signServiceImpl();
            sign=signservic.loadSign(user_email);
            long sign_information=sign.getSign_information();
            sign_information++;
            information.setInformation_id(String.valueOf(sign_information));
            sign.setSign_information(sign_information);//更改information标记     
            signservic.updateSign(sign);
            
            information.setInformation_txt(information_txt);
            information.setInformation_time(toolsUtil.getSYSDatetime());
            information.setInformation_praise(10);
            
            //例如：E:/JavaEE/GuessWEB1.0/WebRoot/LIBRARY/2768559446/datafile/background_body.jpg地址，
            //截取得到/LIBRARY/2768559446/datafile/background_body.jpg
            fileName=fileName.substring(fileName.lastIndexOf("LIBRARY")-1);
            information.setInformation_address(fileName);

            information.setInformation_type(information_type);
            //创建数据库操作实例
            dbInformationService informationservice=new dbInformationServiceImpl();
            informationservice.addInformation_minute(information);//调用函数更新数据库
        } catch (FileUploadException e) {  
            e.printStackTrace();  
        }    
        response.sendRedirect("dynamic?act=data");//重定向
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
