	package com.guess.control;
	import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


	/**
	 * 
	 * 创建发送邮件和生成验证码
	 * @author 发件地址：17805931278@163.com
	 *
	 */
	public class eMail 
	{
		/**
		 * 创建发送邮件
		 * @param check
		 * @param email
		 * @throws MessagingException
		 */
		public void sendEmail(String check,String email) throws MessagingException{
			//配置发送邮件的环境属性
			final Properties props = new Properties();
			//表示smtp发送邮件，需要进行身份验证
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.163.com");
			//发件人的账号
			props.put("mail.user", "17805931278@163.com");
			//发件人账号密码
			props.put("mail.password","163com");
			//构建授权信息，用于进行smtp身份验证
			Authenticator authenticator = new Authenticator(){

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					String userName = props.getProperty("mail.user");
					String passWord = props.getProperty("mail.password");
					return new PasswordAuthentication(userName,passWord);
				}
				
			};
			
			//使用环境属性和授权信息，创建邮件会话
			Session mailSession = Session.getInstance(props,authenticator);
			//创建邮件消息
			MimeMessage message = new MimeMessage(mailSession);
			//设置发件人
			InternetAddress from = null;
			try {
				from = new InternetAddress(props.getProperty("mail.user"),"那里趣学", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message.setFrom(from);
			//设置收件人
			InternetAddress to = new InternetAddress(email);
			message.setRecipient(RecipientType.TO, to);
			//设置邮件标题
			message.setSubject("那里趣学验证码");
			//设置邮件内容体
			Date time=null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				time= dateFormat.parse(dateFormat.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			message.setContent("验证码为：【"+check+"】"+time,"text/html;charset=UTF-8");
			//发送邮件
			Transport.send(message);
			
		}
		
		
		/**
		 * 生成验证码
		 * @return String 4个字符
		 */
		public String createchecknum()
		{
			String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			StringBuilder sb=new StringBuilder(4);
			for(int i=0;i<4;i++)
			{
			char ch=str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
			}
			System.out.println("++"+sb.toString());
			return sb.toString();
		}
		
		/*public static void main(String[] args) {
			mailtest t=new mailtest();
			try {
				t.sendEmail(t.createchecknum());
			} catch (MessagingException e) {
				e.printStackTrace();
				System.out.println("一场");
			}
		}*/
	}

