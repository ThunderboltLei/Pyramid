package com.pyramid.utils.file.xml;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import com.pyramid.utils.encrypt.CoderUtil;
import com.pyramid.utils.file.FileUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:26:18<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file.xml<br>
 * @File: XStreamUtil.java<br>
 * @Description: <br>
 */
public class XStreamUtil {

	// logger
	private static Logger logger = Logger.getLogger(XStreamUtil.class);

	// 文件工具类
	private FileUtil fileUtil = FileUtil.getInstance();

	// XML头
	private final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	/**
	 * 读取文件
	 * 
	 * @param String
	 *            filePath 文件路径
	 * @return
	 */
	public String readXML(String filePath) {
		return readXML(new File(filePath));
	}

	/**
	 * 读取文件
	 * 
	 * @param File
	 *            file 文件
	 * @return
	 */
	public String readXML(File file) {
		List<String> list_str = fileUtil.readAllLines(file);
		StringBuffer strBuf = new StringBuffer("");
		for (String str : list_str) {
			strBuf.append(str);
		}
		return strBuf.toString();
		// return list_str.stream().reduce("", (all, line) -> all +=
		// line.trim());
	}

	/**
	 * 将XML转换成对象实例
	 * 
	 * @param String
	 *            xml XML文件内容
	 * @param Class
	 *            clazz 与XML节点对应的类
	 * @return
	 * @throws XmlConvertException
	 */
	public Object convertXmlToObj(String xml, Class<?> clazz) {
		try {
			XStream xStream = new XStream();
			xStream.processAnnotations(clazz);
			return xStream.fromXML(xml);
		} catch (XStreamException e) {
			logger.warn("convert xml to object error!");
			logger.warn(e);
			return null;
		}
	}

	/**
	 * 将对象实例转换成XML
	 * 
	 * @param obj
	 * @return
	 * @throws XmlConvertException
	 */
	public String converObjToXml(Object obj) {
		try {
			XStream xStream = new XStream();
			xStream.processAnnotations(obj.getClass());
			return XML_HEADER + "\n" + xStream.toXML(obj);
		} catch (XStreamException e) {
			logger.warn("convert object to xml error!");
			logger.warn(e);
			return null;
		}
	}

	/**
	 * 
	 * @param String
	 *            xml xml文件内容
	 * @param String
	 *            expression 节点表达式
	 * @return
	 */
	public List<Node> getNodes(String xml, String expression) {
		try {
			Document document = DocumentHelper.parseText(xml);
			return document.selectNodes(expression);
		} catch (DocumentException e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * Singleton
	 */
	private static XStreamUtil xstreamUtil;

	private XStreamUtil() {

	}

	public static XStreamUtil getInstance() {
		return xstreamUtil == null ? new XStreamUtil() : xstreamUtil;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// XStreamUtil xstreamUtil = XStreamUtil.getInstance();
		//
		// String strXML = "/com/pyramidDB/util/file/data01.ds", // xml文件的相对路径
		// strFilePath = XStreamUtil.class.getClass().getResource(strXML)
		// .getPath(), // 转换成xml文件的绝对路径
		// xmlEncode = xstreamUtil.readXML(strFilePath); // xml内容
		// logger.info(xmlEncode);
		//
		// // decode
		// CoderUtil coderUtil = CoderUtil.getInstance();
		// String xmlDecode = coderUtil.ownDecode(xmlEncode), //
		// expression = "//logId"; // expression = "//logId[@id='2']"; // 节点表达式
		// logger.info(xmlDecode);
		// xstreamUtil.getNodes(xmlDecode, expression).stream()
		// .forEach(node -> logger.info(node.getText()));

	}
}
