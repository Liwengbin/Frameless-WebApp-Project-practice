/**
 * 
 */
package com.guess.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.guess.configurationtool.SetBase;

/**
 * @author 李文兵
 *
 */
public class toolsUtil {
	
	/**
	 * 返回系统的当前时间
	 * @return String(yyyy-MM-dd HH:mm:ss)
	 */
		public static String getSYSDatetime()
		{
			Date day=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
			/*System.out.println(df.format(day));*/
			return df.format(day);
		}
		
		/**
		 * 传进String格式的时间字符串，返回日期（没有具体时间）
		 * @param day
		 * @return
		 */
		public static String getDate(String date)
		{
			Date day=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    try {
				day = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
			return df.format(day);
		}
		
		/**
		 * 创建字节码返回KB或MB
		 * @param bytes
		 * @return
		 */
	    public static String getBytes(long bytes) {  
	        BigDecimal filesize = new BigDecimal(bytes);  
	        BigDecimal megabyte = new BigDecimal(1024 * 1024);  
	        float returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP)  
	                .floatValue();  
	        if (returnValue > 1)  
	            return (returnValue + "MB");  
	        BigDecimal kilobyte = new BigDecimal(1024);  
	        returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP)  
	                .floatValue();  
	        return (returnValue + "KB");  
	    } 
	    
	    /**
	     * 用于创建目录(多级目录)
	     * @param path
	     * @return
	     */
	    public static boolean createCatalogue(String path)
	    {
	    	File newcatalogue=new File(path);
	    	if (newcatalogue.exists()) {  
	            System.out.println("创建目录" + path + "失败，目标目录已经存在");  
	            return false;  
	        }  
	        //创建目录  
	        if (newcatalogue.mkdirs()) {  
	            System.out.println("创建目录" + path + "成功！");  
	            return true;  
	        } else {  
	            System.out.println("创建目录" + path + "失败！");  
	            return false;  
	        }  
	    }
	    
	    
	    /**
	     * 用户注册时调用函数创建用户文件目录
	     * @param user_email账号
	     * @return true or false
	     */
	    public static boolean addUserCatalogue(String user_email)
	    {
	    	//创建目录在WebRoot/LIBRARY/下
	    	String basepath=SetBase.FILE_UPPATH;
	    	String userNumber=user_email.substring(0, user_email.indexOf("@"));
	    	//截取@之前的字符串
	    	toolsUtil.createCatalogue(basepath+userNumber+"/userbase");
	    	toolsUtil.createCatalogue(basepath+userNumber+"/datafile");
	    	toolsUtil.createCatalogue(basepath+userNumber+"/bloggerfile");
	    	toolsUtil.createCatalogue(basepath+userNumber+"/dynamicfile");
	    	return true;
	    }
	    
	    
	    public static String Convert(String target) {  
	    	String charset="utf-8";
	        try {  
	            return new String(target.trim().getBytes("ISO-8859-1"), charset);  
	        } catch (UnsupportedEncodingException e) {  
	            return target;  
	        }  
	    }  
	    
	    public static void main(String[] args) {
	    	//addUserCatalogue("l2b@qq.com");
	    	//System.out.println(createCatalogue("WebRoot/LIBRARY/2768559446/01"));
	    	/*//System.out.println("2768559446@qq.com".substring(0, "2768559446@qq.com".indexOf("@")));
		   System.out.println(System.getProperty("user.dir"));
		   //addUserCatalogue("2768559446@qq.com");
		   System.out.println("E:/JavaEE/GuessWEB1.0/WebRoot/LIBRARY/2768559446/datafile/background_body.jpg".substring("E:/JavaEE/GuessWEB1.0/WebRoot/LIBRARY/2768559446/datafile/background_body.jpg".lastIndexOf("LIBRARY")));*/
		}
	    
}
