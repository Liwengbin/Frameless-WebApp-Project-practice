/**
 * 
 */
package com.guess.util;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author ���ı�
 *
/*
 * Copyright (c) 2014, ShiXiaoyong. All rights reserved.
/**
 * ������GetHttpServletRequestWrapper
 * 
 * <pre>
 * HISTORY 
 * **************************************************************** 
 *  ID   DATE           PERSON          REASON 
 * 1	 2015-3-6		Shixy			Create 
 * 2	 2015-3-23		Shixy			���Ӷ�post��ϴ��η�ʽ��֧�� 
 * ****************************************************************
 * </pre>
 * 
 * @author Shixy
 * @since 1.0
 */
public class GetHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private String charset = "UTF-8";

	private static final String ENCODED = "__encoded";

	private Map<String, String> urlParamNames = null;

	/**
	 * @param request
	 */
	public GetHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		initUrlParameterNames();
	}

	/**
	 * ��ñ�װ�ζ�������úͲ��õ��ַ�����
	 * 
	 * @param request
	 * @param charset
	 */
	public GetHttpServletRequestWrapper(HttpServletRequest request, String charset) {
		super(request);
		this.charset = charset;
		initUrlParameterNames();
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return super.getParameterNames();
	}

	/**
	 * ʵ���Ͼ��ǵ��ñ���װ����������getParameter������ò�����Ȼ���ٽ��б���ת��
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		// ����urlParamNames�Ƿ������ֵ���ж��Ƿ���Ҫ�������get��ʽת��
		if (!urlParamNames.containsKey(name)) {
			return value;
		}
		if (null != value) {
			value = convert(value);
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		// valuesҲ�Ǵ�ֵ
		String[] values = super.getParameterValues(name);
		if ((!urlParamNames.containsKey(name))) {
			return values;
		}
		for (int i = 0; i < values.length; i++) {
			values[i] = convert(values[i]);
		}

		return values;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = super.getParameterMap();
		// �Ƿ��Ѿ�ת��ı�ʶλ
		// ��Ϊmap�Ǵ����õģ���˶�ε���ʱ��ԭֵ�ᱻת��ת����ת�룬���Ҫ���ô˱�־λ����ֹ���ת��
		if ("1".equals(this.getAttribute(ENCODED))) {
			return map;
		}

		// ��map�����е�url���ν��б���
		// ����map�еĲ�����ת��������
		for (String key : urlParamNames.keySet()) {
			String[] value = map.get(key);
			if (value != null) {
				for (int i = 0; i < value.length; i++) {
					value[i] = convert(value[i]);
				}
			}
		}

		this.setAttribute(ENCODED, "1");
		return map;
	}

	/**
	 * ���ַ���ת��
	 * ISO-8859-1Ϊ����ͨ��url����
	 * @param target
	 * @return
	 */
	private String convert(String target) {
		try {
			return new String(target.trim().getBytes("ISO-8859-1"), charset);
		} catch (UnsupportedEncodingException e) {
			return target;
		}
	}
	
	/**
	 * ��ʼ������url��ֵ�Ĳ�����
	 */
	private void initUrlParameterNames() {
		if (null != urlParamNames) {
			return;
		}
		// ��ȡ���е�url���εĲ�����
		urlParamNames = new HashMap<String, String>();
		String st = this.getQueryString();
		if (null == st || 0 == st.length()) {
			return;
		}
		String[] params = this.getQueryString().split("&");
		for (String p : params) {
			if (!p.contains("=")) {
				continue;
			}
			urlParamNames.put(p.substring(0, p.indexOf("=")), null);
		}
	}

}
