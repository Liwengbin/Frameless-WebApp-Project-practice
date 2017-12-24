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
		System.out.println("���������޸�uploadFile");
		
        response.setCharacterEncoding("utf-8"); 
		
		String filename=null;//�ļ���
		long sizeByte=0;//�ļ���С
		
		//�õ���ǰϵͳ��ʱ�ļ��е�λ��
		File tempFile=new File(System.getProperty("java.io.tmpdir"));
		System.out.println(tempFile);
		//�κ��ļ��ύ���Ǵ����ļ���
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//�ļ��������ż�
		factory.setSizeThreshold(4096);
		//������ʱ�洢λ��
		factory.setRepository(tempFile);
		//����SFU��������������ύ��request������
		ServletFileUpload sfu=new ServletFileUpload(factory);
		//�����˵����ļ���С���ż�
		sfu.setSizeMax(5000000);
		//�����������
		sfu.setHeaderEncoding("UTF-8");
		//����һ������ȡ������ʱΪ����ύ���ļ�����
		FileItem fileitem=null; 
		String act=null;
		List<FileItem> ITEM=null;
		/**
		 * �����˲������Ƿ�Ϊ����ύ
		 */
		if(sfu.isMultipartContent(request)){
			try {
				//ʹ��SFU����request�����õ������ļ����б���ͨ�ύ��/�ļ��ύ��
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
		//���ڶ���ύ������������Ͻ��в���
		System.out.println(fileitem);
		if(fileitem!=null)
		{
		filename=fileitem.getName();//����ļ���
	    sizeByte = fileitem.getSize();//����ļ���С
	    
	    InputStream in = fileitem.getInputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;
        
        System.out.println(filename);
    	String prefix=filename.substring(filename.lastIndexOf(".")+1);//��ȡ�ļ���׺
    	String user_email="2768559446@qq.com";
    	
    	user_email=user_email.substring(0, user_email.indexOf("@"));//��ȡ@֮ǰ���ַ���
    	System.out.println(System.getProperty("user.dir"));
        filename = "E:/JavaEE/GuessWEB1.0/WebRoot/LIBRARY/"+ user_email+"/userbase/"+"headimg."+prefix;//�ļ������ϴ���λ��  
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
			//�ļ�����
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
 		    }//����fileItems
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
