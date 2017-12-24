/**
 * 
 */
package com.guess.domain;

/**
 * @author 李文兵
 * 上传文件对象
 */
public class Upload_File {
	private byte[] file_content;
	private String file_name;
	private double file_size;
	
	public Upload_File() {
		super();
	}
	public byte[] getFile_content() {
		return file_content;
	}
	public void setFile_content(byte[] file_content) {
		this.file_content = file_content;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public double getFile_size() {
		return file_size;
	}
	public void setFile_size(double file_size) {
		this.file_size = file_size;
	}
	
}
