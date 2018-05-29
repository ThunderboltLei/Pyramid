package com.pyramid.utils.file;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:26:44<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file<br>
 * @File: IFileUtil.java<br>
 * @Description: <br>
 */
public interface IFileUtil {

	/**
	 * read
	 * 
	 * @param filePath
	 * @return
	 */
	public String readByPath(String filePath);

	public String readByStream(InputStream is);

	public void readBytesFromFile(String destination);
	
	public List<String> readAllLines(File file);
	
	/**
	 * write
	 * 
	 * @param sourcePath
	 * @param destinationPath
	 */
	public void copyFileWithChannel(String sourcePath, String destinationPath);

	public void writeBytesToFile(byte[] bytes, String destination);

	/**
	 * delete
	 * 
	 * @param folder
	 * @return
	 */
	public boolean deleteFolder(File folder);

}
