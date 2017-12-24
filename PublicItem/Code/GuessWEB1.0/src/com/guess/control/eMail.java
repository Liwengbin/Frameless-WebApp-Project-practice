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
	 * ���������ʼ���������֤��
	 * @author ������ַ��17805931278@163.com
	 *
	 */
	public class eMail 
	{
		/**
		 * ���������ʼ�
		 * @param check
		 * @param email
		 * @throws MessagingException
		 */
		public void sendEmail(String check,String email) throws MessagingException{
			//���÷����ʼ��Ļ�������
			final Properties props = new Properties();
			//��ʾsmtp�����ʼ�����Ҫ���������֤
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.163.com");
			//�����˵��˺�
			props.put("mail.user", "17805931278@163.com");
			//�������˺�����
			props.put("mail.password","163com");
			//������Ȩ��Ϣ�����ڽ���smtp�����֤
			Authenticator authenticator = new Authenticator(){

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					String userName = props.getProperty("mail.user");
					String passWord = props.getProperty("mail.password");
					return new PasswordAuthentication(userName,passWord);
				}
				
			};
			
			//ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
			Session mailSession = Session.getInstance(props,authenticator);
			//�����ʼ���Ϣ
			MimeMessage message = new MimeMessage(mailSession);
			//���÷�����
			InternetAddress from = null;
			try {
				from = new InternetAddress(props.getProperty("mail.user"),"����Ȥѧ", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message.setFrom(from);
			//�����ռ���
			InternetAddress to = new InternetAddress(email);
			message.setRecipient(RecipientType.TO, to);
			//�����ʼ�����
			message.setSubject("����Ȥѧ��֤��");
			//�����ʼ�������
			Date time=null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				time= dateFormat.parse(dateFormat.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			message.setContent("��֤��Ϊ����"+check+"��"+time,"text/html;charset=UTF-8");
			//�����ʼ�
			Transport.send(message);
			
		}
		
		
		/**
		 * ������֤��
		 * @return String 4���ַ�
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
				System.out.println("һ��");
			}
		}*/
	}

