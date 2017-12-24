package com.guess.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
import com.guess.domain.Upload_File;
import com.guess.domain.User_basic;
import com.guess.util.toolsUtil;

public class UploadFile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UploadFile() {
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
		System.out.println("个人资料修改uploadFile");
		
        response.setCharacterEncoding("utf-8"); 
		
		String filename=null;//文件名
		long sizeByte=0;//文件大小
		
		//得到当前系统临时文件夹的位置
		File tempFile=new File(System.getProperty("java.io.tmpdir"));
		System.out.println(tempFile);
		//任何文件提交域都是磁盘文件项
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//文件项数量门槛
		factory.setSizeThreshold(4096);
		//设置临时存储位置
		factory.setRepository(tempFile);
		//构建SFU对象来解析多段提交的request数据流
		ServletFileUpload sfu=new ServletFileUpload(factory);
		//设置了单个文件大小的门槛
		sfu.setSizeMax(5000000);
		//解决中文乱码
		sfu.setHeaderEncoding("UTF-8");
		//定义一个用于取出遍历时为多段提交的文件对象
		FileItem fileitem=null; 
		String act=null;
		List<FileItem> ITEM=null;
		/**
		 * 做过滤操作，是否为多段提交
		 */
		if(sfu.isMultipartContent(request)){
			try {
				//使用SFU解析request流，得到磁盘文件项列表（普通提交域/文件提交域）
				ITEM=sfu.parseRequest(request); 
				for(FileItem item:ITEM)
				{
					if(item.isFormField() && item.getFieldName().equals("act"))
                    {
                    	act=item.getString("utf-8");
                    	System.out.println("act="+act+"1");
                    }
					else {
						fileitem=item;
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}			
		}
		else
		{
		  act = request.getParameter("act");
		  System.out.println("act="+act);
		}
		//存在多段提交的资料则对资料进行操作
		System.out.println(fileitem);
		if(fileitem!=null)
		{
		filename=fileitem.getName();//获得文件名
	    sizeByte = fileitem.getSize();//获得文件大小
	    
	    InputStream in = fileitem.getInputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;
        
        System.out.println(filename);
    	String prefix=filename.substring(filename.lastIndexOf(".")+1);//获取文件后缀
    	String user_email="2768559446@qq.com";
    	
    	user_email=user_email.substring(0, user_email.indexOf("@"));//截取@之前的字符串
    	System.out.println(System.getProperty("user.dir"));
        filename = "E:/JavaEE/GuessWEB1.0/WebRoot/LIBRARY/"+ user_email+"/userbase/"+"headimg."+prefix;//文件最终上传的位置  
        System.out.println(sizeByte);
        System.out.println(filename);
        
        OutputStream out = new FileOutputStream(filename);  
        while ((len = in.read(buffer)) != -1) {  
            out.write(buffer, 0, len);  
        }  
        out.close();  
        in.close();  
		}
		
		
		if("upload".equals(act)){
			//文件对象
			//Upload_File upload_file = new Upload_File();
			User_basic user_basic=new User_basic();
 		    for(FileItem item:ITEM)
 		    {
 		    	if(item.isFormField() && item.getFieldName().equals("user_email")){
 		    		user_basic.setUser_email(item.getString("utf-8"));
 		    	}
 		    	else if(item.isFormField() && item.getFieldName().equals("user_name")){
 		    		user_basic.setUser_name(item.getString("utf-8"));
 		    	}
 		    	else if(item.isFormField() && item.getFieldName().equals("user_password")){
 		    		user_basic.setUser_password(item.getString("utf-8"));
 		    	}
 		    }//遍历fileItems
			System.out.println(user_basic.getUser_email());
		}
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
