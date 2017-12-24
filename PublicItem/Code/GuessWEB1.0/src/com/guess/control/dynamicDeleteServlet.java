package com.guess.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guess.domain.Blogger_share;
import com.guess.service.dbBloggerShareService;
import com.guess.service.dbBloggerShareServiceImpl;

public class dynamicDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public dynamicDeleteServlet() {
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
			System.out.println("actdelete="+act);
			
			if("sharedelete".equals(act))
			{
				String share_number=request.getParameter("share_number");
				String user_email=request.getParameter("user_email");
				Blogger_share BloggerShare=new Blogger_share(user_email, null, null, null, share_number, null);
				
				dbBloggerShareService BloggerShareService=new dbBloggerShareServiceImpl();
				BloggerShareService.removeBlogger_share(BloggerShare);
				
				response.sendRedirect("dynamic?act=share");//÷ÿ∂®œÚ
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
