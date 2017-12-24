package com.guess.control;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guess.domain.All_content;
import com.guess.domain.Blogger_content;
import com.guess.domain.Information_minute;
import com.guess.domain.ShareToUser;
import com.guess.service.dbBloggerContentService;
import com.guess.service.dbBloggerContentServiceImpl;
import com.guess.service.dbInformationService;
import com.guess.service.dbInformationServiceImpl;
import com.guess.service.loadAllService;
import com.guess.service.loadAllServiceImpl;

public class dynamicServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 01L;

	/**
	 * Constructor of the object.
	 */
	public dynamicServlet() {
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
		
		String act=request.getParameter("act");
		System.out.println("act"+act);
		
		HttpSession session = request.getSession();
		loadAllService loadall_service=new loadAllServiceImpl();
		
		if("main".equals(act))
		{
			ArrayList<All_content> contentlist=loadall_service.returnDynamicToInteractionContentList();
			session.setAttribute("all_content", contentlist);//查找动态的所有数据，包括动态内容+评论
			
			request.getRequestDispatcher("./jsps/main.jsp").forward(request, response);
		}
		else if("maintow".equals(act))
		{
			ArrayList<All_content> contentlist=loadall_service.returnDynamicToInteractionContentList();
			session.setAttribute("all_content", contentlist);//查找动态的所有数据，包括动态内容+评论

			request.getRequestDispatcher("./jsps/main.jsp").forward(request, response);
		}
		else if("blogger".equals(act))
		{
			dbBloggerContentService bloggerService=new dbBloggerContentServiceImpl();
			List<Blogger_content> contentlist=bloggerService.loadAllBlogger_content();
			
			session.setAttribute("contentlist", contentlist);
			
			request.getRequestDispatcher("./jsps/blogger.jsp").forward(request, response);
		}
		else if("data".equals(act))
		{
			HttpSession seion = request.getSession();
			dbInformationService informationservice=new dbInformationServiceImpl();
			List<Information_minute> list_information=informationservice.loadAllInformation_minute();
			for(Information_minute list:list_information)
			{
				System.out.println(list.getInformation_filename());
				System.out.println(list.getInformation_id());
				System.out.println(list.getInformation_address());
			}
			seion.setAttribute("List_Information", list_information);
			request.getRequestDispatcher("./jsps/data.jsp").forward(request, response);
		}
		else if("share".equals(act))
		{		
			ArrayList<ShareToUser> share_to_user_list=new ArrayList<ShareToUser>();
			share_to_user_list=loadall_service.loadShareToUser();
			session.setAttribute("share_to_user_list", share_to_user_list);
			request.getRequestDispatcher("./jsps/share.jsp").forward(request, response);
		}
		else if("tools".equals(act))
		{
			request.getRequestDispatcher("./jsps/tools.jsp").forward(request, response);
		}
		else if("enduser".equals(act))
		{
			//执行注销操作
			session.removeAttribute("USERALL");
			response.sendRedirect("dynamic?act=main");//重定向
		}
		else if("upload".equals(act))
		{
			request.getRequestDispatcher("./jsps/upload.jsp").forward(request, response);
		}
		else if("write_blogger".equals(act))
		{
			request.getRequestDispatcher("./jsps/publish.jsp").forward(request, response);
		}
		else if("test".equals(act))
		{
			request.getRequestDispatcher("./kindeditor/jsp/demo.jsp").forward(request, response);
		}
		else if("sign".equals(act))
		{
			request.getRequestDispatcher("./jsps/sign.jsp").forward(request, response);
		}
		else if("userbase".equals(act))
		{
			request.getRequestDispatcher("./jsps/userbase.jsp").forward(request, response);
		}
		else if("lookblogger".equals(act))
		{

			String u=request.getParameter("u");
			String id=request.getParameter("id");

			Blogger_content content=new Blogger_content();
			content.setUser_email(u);
			content.setBlogger_id(id);
			
			dbBloggerContentService bloggerService=new dbBloggerContentServiceImpl();
			content=bloggerService.loadBlogger_content(content);
			session.setAttribute("content", content);
			request.getRequestDispatcher("./jsps/lookblogger.jsp").forward(request, response);
		}
		else if("homepage".equals(act))
		{
			request.getRequestDispatcher("./jsps/homepage.jsp").forward(request, response);
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
