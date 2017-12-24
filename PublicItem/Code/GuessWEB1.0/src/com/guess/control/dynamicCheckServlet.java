package com.guess.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guess.domain.Sign;
import com.guess.domain.User_all;
import com.guess.domain.User_basic;
import com.guess.domain.User_minute;
import com.guess.exception.GUESSException;
import com.guess.service.dbUserService;
import com.guess.service.dbUserServiceImpl;
import com.guess.service.loadAllService;
import com.guess.service.loadAllServiceImpl;
import com.guess.service.signServic;
import com.guess.service.signServiceImpl;
import com.guess.util.toolsUtil;

public class dynamicCheckServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public dynamicCheckServlet() {
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
		System.out.println("actcheck="+act);
		HttpSession session = request.getSession();
		if("login".equals(act))
		{
			String user_email=request.getParameter("user_email");
			String password=request.getParameter("user_password");
			dbUserService user_service=new dbUserServiceImpl();
			try{
					//登录时验证账号密码
					user_service.checkUser(user_email, password);
					   
					User_all UserAll=new User_all();
					loadAllService LoadAllService=new loadAllServiceImpl();
					UserAll=LoadAllService.loadUserAll(user_email);
					
					//登录成功后将个人信息存入session中供系统使用
					session.setAttribute("USERALL", UserAll);
					response.sendRedirect("dynamic?act=maintow");//重定向 
				}catch(GUESSException e){
				   request.setAttribute("errMsg", e.getMessage());
				   request.getRequestDispatcher("./jsps/sign.jsp").forward(request, response);	
				}
		}
		

		else if("sign".equals(act))
		{
			String user_email=request.getParameter("user_email");
			String user_password=request.getParameter("user_password");
			String user_name=request.getParameter("user_name");
			
			//非必要判断（防止网页被篡改提交无效数据，使系统出错误）
			if(user_email !=null && user_password != null && user_name !=null)
			{
			User_basic user=new User_basic();
			user.setUser_email(user_email);
			user.setUser_name(user_name);
			user.setUser_password(user_password);
			
			dbUserService UserService=new dbUserServiceImpl();
			UserService.addUser_basic(user);
			
			User_minute User_minute=new  User_minute();
			User_minute.setUser_email(user.getUser_email());
			//添加默认头像
			//随机数用于随机添加默认头像
			int x=(int)(Math.random()*7+1);
			User_minute.setUser_headimg("/img/imgDafault/headimg"+x+".png");
			UserService.addUser_minute(User_minute);
			
			//在数据库生成该账号的标记
			Sign sign=new Sign(user.getUser_email(), 0, 0, 0, 0);
			signServic signS=new signServiceImpl();
			signS.addSign(sign);

			//创建用户文件目录
			toolsUtil.addUserCatalogue(user_email);
			request.getRequestDispatcher("./jsps/sign.jsp").forward(request, response);
			}
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
