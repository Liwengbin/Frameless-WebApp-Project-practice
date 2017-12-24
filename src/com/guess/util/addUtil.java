package com.guess.util;

import com.guess.domain.Blogger_share;
import com.guess.domain.Sign;
import com.guess.service.dbBloggerShareService;
import com.guess.service.dbBloggerShareServiceImpl;
import com.guess.service.signServic;
import com.guess.service.signServiceImpl;

public class addUtil {
	
	/**
	 * 创建分享，调用service的内容添加数据
	 * @param user_email
	 * @param share_describe
	 * @param share_web_url
	 */
	public void addShare(String user_email,String share_describe,String share_web_url)
	{
		if((share_web_url.trim()) !="" && (share_describe.trim()) !="")
		{
			dbBloggerShareService blogger_share_service=new dbBloggerShareServiceImpl();
			Sign sign=new Sign();
			signServic sign_service=new signServiceImpl();
			sign=sign_service.loadSign(user_email);
			Blogger_share baogger_share=new Blogger_share(sign.getUser_email(), share_web_url, share_describe, toolsUtil.getSYSDatetime(), Long.toString(sign.getSign_share()+1), "0");
			sign.setSign_share(sign.getSign_share()+1);
			sign_service.updateSign(sign);
			blogger_share_service.addBlogger_share(baogger_share);
		}
		else
		{
			System.out.println("内容为空无法添加");
		}
	}
	
}
