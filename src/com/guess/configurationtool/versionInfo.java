/**
 * 
 */
package com.guess.configurationtool;

/**
 * @author ��Ȩ��Ϣ
 *
 */
public final class versionInfo {
	public final static String APP_NAME="�²�վ";
    public final static String APP_VERSION="1.0";
    public final static String APP_STATUS="Beta";
    public final static String APP_BUILDATE="2016-12-29";
    public final static String APP_BUILDVER="#2";
    	
    //application author
    public final static String APP_AUTHOR="17805931278@163.com";
    public final static String APP_WORKSTUDIO="�²�վ���˷���ƽ̨";
    
    public final static String buildFooterStr()
    {
    	StringBuffer sb=new StringBuffer();

    	sb.append(APP_NAME);
    	sb.append(" "+"(�汾:"+APP_STATUS+APP_VERSION);
    	sb.append(" &nbsp;&nbsp;Build:"+APP_BUILDVER);
    	sb.append(" "+APP_BUILDATE+")");
    	sb.append("&nbsp;&nbsp;&nbsp;&nbsp;�����Ŷ�:&nbsp;<a href=\"http://www.itart.space:8080\">"+APP_AUTHOR+"</a><br/>");
    	sb.append("(C)&nbsp;"+APP_WORKSTUDIO+"&nbsp;&nbsp;");
    	return sb.toString();	
    }
}
