package com.pyramid.utils.file.gz;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.log4j.Logger;

import com.pyramid.utils.file.FileUtil;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:25:29<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file.gz<br>
 * @File: GZFileUtil.java<br>
 * @Description: <br>
 */
public class GZFileUtil extends FileUtil {

	private static Logger logger = Logger.getLogger(GZFileUtil.class);

	private static String path = null;

	private static Map<String, List<String>> map = null;

	/**
	 * 
	 * @param targzFile
	 */
	public Map<String, List<String>> visitTARGZ(String strTarGZFile) {
		//
		//
		File targzFile = new File(strTarGZFile);
		if (targzFile.isFile()) {
			FileInputStream fileIS = null;
			BufferedInputStream bufIS = null;
			GZIPInputStream gzipIS = null;
			final TarArchiveInputStream tarIS;
			try {
				/**
				 * initialize variables
				 */
				// 1.
				fileIS = new FileInputStream(targzFile);
				// 2.
				bufIS = new BufferedInputStream(fileIS);
				// 3.first unzip the input file
				gzipIS = new GZIPInputStream(bufIS);
				// 4. tar file
				tarIS = new TarArchiveInputStream(gzipIS);

				/**
				 * get each file from a loop
				 */
				map = new HashMap<String, List<String>>();
				ArchiveEntry entry;
				while ((entry = tarIS.getNextEntry()) != null) {
					if (entry.isDirectory()) {
						continue;
					}
					// logger.info("----- " + entry);
					// File file = entry.getFile(); // file is null
					logger.info("----- " + entry.getName() + ", "
							+ (entry.getSize() / (1024 * 1024) + "MB") + ", ");

					// byte[] b = new byte[(int) entry.getSize()];
					// taris.read(b);
					// taris.read(b, 0, (int) entry.getSize());

					/**
					 * GZ文件中每一子文件都会使用一个线程来处理
					 */
					final String strFileName = entry.getName();
					new Thread() {
						public void run() {
							/**
							 * 输出GZ文件中各个文件的内容
							 */
							List<String> list = readByStream(tarIS);
							// list.stream().forEach(
							// line -> logger.info(this.getId() + ". "
							// + strFileName + " --- " + line));

							/**
							 * 以子文件名称为key，存储GZ文件中包含的子文件的内容为value
							 */
							map.put(strFileName, list);
						}
					}.start();

					// Thread.sleep(3000);
				}

				/**
				 * close the inputstream
				 */
				tarIS.close();
				gzipIS.close();
				bufIS.close();
				fileIS.close();
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return map;
		} else {
			logger.error(strTarGZFile + " is not a file...");
			return map;
		}
	}

	/**
	 * Singleton
	 */
	private static GZFileUtil gzFileUtil;

	private GZFileUtil() {
		super();
		path = this.getClass().getClassLoader().getResource("").getPath();
	}

	public static GZFileUtil getInstance() {
		return gzFileUtil == null ? new GZFileUtil() : gzFileUtil;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		GZFileUtil gzFileUtil = GZFileUtil.getInstance();

		System.out.println(path);

		// File root = new File(path);
		// Arrays.asList(root.listFiles()).forEach(System.out::println);

		gzFileUtil.visitTARGZ(path + "WordAnalyseDataset.tar.gz");

	}

}
