package com.pyramid.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:26:37<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file<br>
 * @File: FileUtil.java<br>
 * @Description: <br>
 */
public class FileUtil {
	// public class FileUtil implements IFileUtil {

	private static Logger logger = Logger.getLogger(FileUtil.class);

	private String path = null;

	// ----- read ----- //

	/**
	 * 读取文件内容
	 * 
	 * @param filePath
	 *            要读取的文件的路径
	 * @return
	 */
	public List<String> readAllLines(String filePath) {
		return readAllLines(new File(filePath));
	}

	/**
	 * 读取文件内容
	 * 
	 * @param file
	 *            要读取的文件
	 * @return
	 */
	public List<String> readAllLines(File file) {
		logger.info("function: readFile");
		List<String> list = null;
		try {
			list = new ArrayList<String>();
			FileReader fr = new FileReader(file);
			BufferedReader bw = new BufferedReader(fr);
			String line = null;
			while ((line = bw.readLine()) != null) {
				list.add(line);
			}
			bw.close();
			fr.close();
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * 读取文件的内容，并把内容拼成字符串
	 * 
	 * @param filePath
	 *            文件路径的字符串对象
	 * @return
	 */
	public List<String> readByPath(String filePath) {
		List<String> list = null;
		File file = new File(filePath);
		if (file.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				list = readByStream(fis);
			} catch (FileNotFoundException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			}
		}
		return list;
	}

	/**
	 * 使用二进制流的方式读取文件的内容，并把内容拼成字符串
	 * 
	 * @param is
	 *            文件路径的二进制流
	 * @return
	 */
	public List<String> readByStream(InputStream is) {
		List<String> list = null;
		try {
			list = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					"utf-8"));
			String tmp = null;
			while ((tmp = br.readLine()) != null) {
				list.add(tmp);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * To read sth
	 * 
	 * @param destination
	 */
	public String readBytesFromFile(String destination) {
		StringBuilder strBuilder = null;
		try {
			/**
			 * method_1: BufferReader读取文件内容OK，无乱码
			 */
			// InputStreamReader read = new InputStreamReader(new
			// FileInputStream(
			// destination), "utf8");
			// BufferedReader br = new BufferedReader(read);
			// String str = null;
			// while ((str = br.readLine()) != null) {
			// System.out.println(str);
			// }
			/**
			 * method_2: FileChannel读取文件内容乱码
			 */
			ByteBuffer dst = ByteBuffer.allocate(1024);
			FileChannel fc = new FileInputStream(destination).getChannel();
			fc.read(dst);
			dst.flip();

			strBuilder = new StringBuilder();
			while (dst.hasRemaining()) {
				logger.info("char: " + dst.getChar());
				strBuilder.append((char) dst.get());
			}

			logger.info(strBuilder.toString()
					+ "\n"
					+ new String(strBuilder.toString().getBytes("gb2312"),
							"utf8"));
			fc.close();
			return strBuilder.toString();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	// ----- write ----- //

	/**
	 * use channel to copy file
	 */
	public boolean copyFileWithChannel(String strSourcePath,
			String strDestinationPath) {
		try {
			// FileInputStream fis = new
			// FileInputStream("E:/z-tmp/06_txt/abc.txt");
			// FileOutputStream fos = new FileOutputStream(
			// "E:/z-tmp/06_txt/123.txt");
			FileInputStream fis = new FileInputStream(strSourcePath);
			FileOutputStream fos = new FileOutputStream(strDestinationPath);
			FileChannel fc1 = fis.getChannel();
			FileChannel fc2 = fos.getChannel();
			fc2.transferFrom(fc1, 0, fc1.size());
			fc1.close();
			fc2.close();
			fis.close();
			fos.close();
			return true;
		} catch (FileNotFoundException e) {
			logger.error(e);
			return false;
		} catch (IOException e) {
			logger.error(e);
			return false;
		}
	}

	/**
	 * To write sth into a file using java.io.FileChannel
	 * 
	 * @param bytes
	 * @param destination
	 */
	public void writeBytesToFile(byte[] bytes, String destination) {
		try {
			// FileOutputStream(目标地址，追加(可选))
			FileChannel fc = new FileOutputStream(destination, true)
					.getChannel();
			logger.info("position: " + fc.size());
			fc.write(ByteBuffer.wrap(bytes));
			fc.close();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	// ----- delete ----- //

	/**
	 * To delete a directory
	 * 
	 * @param folder
	 * @return
	 */
	public boolean deleteFolder(File folder) {
		return deleteFolder(folder, true);
	}

	public boolean deleteFolder(File folder, boolean isDelete) {
		if (folder.isDirectory()) {
			return false;
		}
		return true;
	}

	/**
	 * To delete a file
	 * 
	 * @param folder
	 * @param isDelete
	 * @return
	 */
	public boolean deleteFolder(File folder, Boolean isDelete) {
		logger.info("Deleting content of: " + folder.getAbsolutePath());
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				if (!file.delete()) {
					return false;
				}
			} else {
				if (!deleteFolder(file)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @param srcFile
	 * @param destFile
	 */
	public void readFile(File srcFile, File destFile) {
		try {
			FileReader fr = new FileReader(srcFile);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while ((str = br.readLine()) != null) {
				// System.out.println(str);
				String[] strs = str.split(",");
				int n = strs.length;
				String tmp = "";
				for (int i = 0; i < n; i++) {
					if (i != n - 1) {
						if (i == 1) {
							tmp += strs[i] + ", " + strs[3] + ", ";
						} else {
							tmp += strs[i] + ", ";
						}
					} else if (i == n - 1) {
						tmp += strs[i] + ", ";
					}
				}
				logger.info(tmp);
			}
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	/**
	 * Singleton
	 */
	public static FileUtil rwFile;

	protected FileUtil() {
		path = this.getClass().getClassLoader().getResource("").getPath();
	}

	public static FileUtil getInstance() {
		return rwFile == null ? new FileUtil() : rwFile;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileUtil rwFile = FileUtil.getInstance();

		// List<String> list = rwFile.readByStream(FileUtil.class
		// .getResourceAsStream("/com/test/java/avro/demo01/user.avro"));
		// list.stream().forEach(System.out::println);

		/**
		 * 4.
		 */
		// File srcFile = new File("C:\\Users\\lm8212\\Desktop\\guangdong.sql"),
		// // srcFile
		// destFile = null; // destFile
		//
		// rwFile.readFile01(srcFile, destFile);

		/**
		 * 3.
		 */
		// System.out.println("path: " + rwFile.path);
		// // String destination = path + "/TestCrawler4j.txt";
		// String destination = "E:/z-tmp/06_txt/a.txt";
		// File destinationFile = new File(destination);
		// if (!destinationFile.exists()) {
		// destinationFile.createNewFile();
		// }
		/**
		 * 2. To write something into file
		 */
		// byte[] bytes = "测试Test".getBytes();
		// rwFile.writeBytesToFile(bytes, destination);
		/**
		 * 1. To read something from file
		 */
		// rwFile.readBytesFromFile(destination);

	}
}
