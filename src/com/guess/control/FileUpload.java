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
		
		System.out.println("����fileuplod");
		
        response.setCharacterEncoding("utf-8");  
        String information_txt=null;
        String information_filename=null;
        String information_type=null;
        String fileName=null;
        
        User_all userall=(User_all)request.getSession().getAttribute("USERALL");//��ɨsession�е�userall
		String user_email=userall.getUser_basic().getUser_email();
		
        //����information�洢����
        Information_minute information =new Information_minute();
        
        //1������һ��DiskFileItemFactory����  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        
        //2������һ���ļ��ϴ�������  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        //����ϴ��ļ�������������  
        upload.setHeaderEncoding("UTF-8");   
        factory.setSizeThreshold(1024 * 1024);//�����ڴ���ٽ�ֵΪ500K  
        File linshi = new File(SetBase.FILE_CACHEPATH);//������500K��ʱ�򣬴浽һ����ʱ�ļ�����  
        factory.setRepository(linshi);  
         upload.setSizeMax(1024 * 1024 * 100);//�����ϴ����ļ��ܵĴ�С���ܳ���100M
        try {  
            // 1. �õ� FileItem �ļ��� items  
            List<FileItem> /* FileItem */items = upload.parseRequest(request);  
            // 2. ���� items:  
            for (FileItem item : items) {  
                // ����һ��һ��ı���, ��ӡ��Ϣ  
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
                // �����ļ�������ļ����浽 e:\\files Ŀ¼��.  
                else {  
                    fileName = item.getName();  
                    long sizeInBytes = item.getSize();  


                    information.setInformation_size(toolsUtil.getBytes(sizeInBytes));
                    InputStream in = item.getInputStream();  
                    byte[] buffer = new byte[1024];  
                    int len = 0;  
                    
                    String prefix=fileName.substring(fileName.lastIndexOf(".")+1);//��ȡ�ļ���׺

                    information.setInformation_filename(information_filename);
                    fileName = SetBase.FILE_UPPATH+user_email.substring(0, user_email.indexOf("@"))+"/datafile/"+fileName;//�ļ������ϴ���λ��  

                    OutputStream out = new FileOutputStream(fileName);  
                    while ((len = in.read(buffer)) != -1) {  
                        out.write(buffer, 0, len);  
                    }  
                    out.close();  
                    in.close();  
                }  
            } 
            
            //�洢�����ݿ�
            information.setUser_email(user_email);
            //�������ʵ��
            Sign sign=new Sign();
            
            //�������ݿ����ʵ��\
            signServic signservic=new signServiceImpl();
            sign=signservic.loadSign(user_email);
            long sign_information=sign.getSign_information();
            sign_information++;
            information.setInformation_id(String.valueOf(sign_information));
            sign.setSign_information(sign_information);//����information���     
            signservic.updateSign(sign);
            
            information.setInformation_txt(information_txt);
            information.setInformation_time(toolsUtil.getSYSDatetime());
            information.setInformation_praise(10);
            
            //���磺E:/JavaEE/GuessWEB1.0/WebRoot/LIBRARY/2768559446/datafile/background_body.jpg��ַ��
            //��ȡ�õ�/LIBRARY/2768559446/datafile/background_body.jpg
            fileName=fileName.substring(fileName.lastIndexOf("LIBRARY")-1);
            information.setInformation_address(fileName);

            information.setInformation_type(information_type);
            //�������ݿ����ʵ��
            dbInformationService informationservice=new dbInformationServiceImpl();
            informationservice.addInformation_minute(information);//���ú����������ݿ�
        } catch (FileUploadException e) {  
            e.printStackTrace();  
        }    
        response.sendRedirect("dynamic?act=data");//�ض���
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
