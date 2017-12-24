package com.guess.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guess.domain.Blogger_content;
import com.guess.domain.Dynamic_content;
import com.guess.domain.Interaction_content;
import com.guess.domain.Sign;
import com.guess.domain.User_all;
import com.guess.domain.User_minute;
import com.guess.service.dbBloggerContentService;
import com.guess.service.dbBloggerContentServiceImpl;
import com.guess.service.dbDynamicService;
import com.guess.service.dbDynamicServiceImpl;
import com.guess.service.dbUserService;
import com.guess.service.dbUserServiceImpl;
import com.guess.service.loadAllService;
import com.guess.service.loadAllServiceImpl;
import com.guess.service.signServic;
import com.guess.service.signServiceImpl;
import com.guess.util.addUtil;
import com.guess.util.toolsUtil;

public class dynamicAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public dynamicAddServlet() {
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
		addUtil addUtil=new addUtil();
		String act=null;
		act=request.getParameter("act");
		System.out.println("addact="+act);
		HttpSession session = request.getSession();
		User_all userall=(User_all)request.getSession().getAttribute("USERALL");//��ɨsession�е�userall
		String user_selfe=userall.getUser_basic().getUser_email();
		if("shareadd".equals(act))
		{
			String share_describe=request.getParameter("share_describe");
			String share_web_url=request.getParameter("share_web_url");
			if(share_web_url!=null)
			{
				addUtil.addShare(user_selfe, share_describe, share_web_url);
				response.sendRedirect("dynamic?act=share");//�ض���
			}
			else
			{
				response.sendRedirect("dynamic?act=share");//�ض���
			}
		}
		else if("content".equals(act))
		{
			String dynamic_txt=request.getParameter("dynamic_txt");
			
			Sign sign=new Sign();
			signServic sign_service=new signServiceImpl();
			sign=sign_service.loadSign(user_selfe);
			Dynamic_content dynamic_content=new Dynamic_content(user_selfe, Long.toString(sign.getSign_dynamic()+1), dynamic_txt, null, null, toolsUtil.getSYSDatetime());
			sign.setSign_dynamic(sign.getSign_dynamic()+1);
			sign_service.updateSign(sign);
			
			dbDynamicService DBDynamicService=new dbDynamicServiceImpl();
			DBDynamicService.addDynamic_content(dynamic_content);
			
			response.sendRedirect("dynamic?act=main");//�ض���
		}
		else if("interaction".equals(act))
		{
			String interaction_txt=request.getParameter("interaction_txt");
			String dynamic_id=request.getParameter("dynamic_id");
			String user_email=request.getParameter("user_email");
			
			if(user_selfe=="null")response.sendRedirect("dynamic?act=main");//�ض���
			else
			{
			System.out.println(interaction_txt+user_selfe+dynamic_id+user_email);
			Interaction_content interactioncontent=new Interaction_content();
			interactioncontent.setDynamic_id(dynamic_id);
			interactioncontent.setInteraction_email(user_selfe);
			interactioncontent.setUser_email(user_email);
			interactioncontent.setInteraction_txt(interaction_txt);
			interactioncontent.setInteraction_time(toolsUtil.getSYSDatetime());
			dbDynamicService dbinteraction=new dbDynamicServiceImpl();
			dbinteraction.addInteraction_content(interactioncontent);
			response.sendRedirect("dynamic?act=main");//�ض���
			}
		}
		else if("publish".equals(act))
		{
			String content1=request.getParameter("content1");
			String blogger_type=request.getParameter("blogger_type");
			String blogger_name=request.getParameter("blogger_name");
			
			Sign sign=new Sign();
			signServic sign_service=new signServiceImpl();
			sign=sign_service.loadSign(user_selfe);
			Blogger_content blogger_con=new Blogger_content(user_selfe, Long.toString(sign.getSign_blogger()+1), blogger_name, content1, 10, toolsUtil.getSYSDatetime(), blogger_type);
			sign.setSign_blogger(sign.getSign_blogger()+1);
			sign_service.updateSign(sign);
			
			dbBloggerContentService dbservice=new dbBloggerContentServiceImpl();
			dbservice.addBlogger_content(blogger_con);
			
			System.out.println("content1��:"+content1);
			System.out.println("blogger_type��:"+blogger_type);
			
			response.sendRedirect("dynamic?act=blogger");//�ض���
		}
		else if ("addminute".equals(act)) {
			User_minute User_minute=new  User_minute();
			User_minute.setUser_email(user_selfe);
			User_minute.setUser_age(Integer.parseInt(request.getParameter("user_age")));
			User_minute.setUser_sex(request.getParameter("user_sex"));
			User_minute.setUser_signature(request.getParameter("user_signature"));

			//��Ӧ���������û���Ϣ����ע��ʱ�Ѿ������û���Ϣ������ֻ���޸�
			dbUserService UserService=new dbUserServiceImpl();
			UserService.updateUser_minute(User_minute);
			
			User_all UserAll=new User_all();
			loadAllService LoadAllService=new loadAllServiceImpl();
			UserAll=LoadAllService.loadUserAll(user_selfe);
			
			//�޸���Ϣ�ɹ���ɹ����ٴν�������Ϣ����session�й�ϵͳʹ��
			session.setAttribute("USERALL", UserAll);
			
			response.sendRedirect("dynamic?act=main");//�ض���
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
