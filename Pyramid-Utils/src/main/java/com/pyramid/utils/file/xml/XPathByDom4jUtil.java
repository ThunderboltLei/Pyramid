package com.pyramid.utils.file.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:25:54<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file.xml<br>
 * @File: XPathByDom4jUtil.java<br>
 * @Description: 使用org.dom4j包解析XML<br>
 */
public class XPathByDom4jUtil {

	// logger
	private final static Logger logger = Logger.getLogger(XPathByDom4jUtil.class);

	private static String strXML;

	/**
	 * SAXReader读取XML文件
	 * 
	 * @param String
	 *            strFilePath XML文件路径
	 * @param String
	 *            expression 节点表达式
	 * @return
	 */
	public List<Element> getNodes(String strFilePath, String expression) {
		try {
			File file = new File(strFilePath);
			return getNodes(file, expression);
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * SAXReader读取XML文件
	 * 
	 * @param File
	 *            file XML文件
	 * @param String
	 *            expression 节点表达式
	 * @return
	 */
	public List<Element> getNodes(File file, String expression) {
		try {
			FileInputStream fis = new FileInputStream(file);
			return getNodes(fis, expression);
		} catch (FileNotFoundException e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * SAXReader读取XML文件
	 * 
	 * @param InputStream
	 *            is 数据流
	 * @param String
	 *            expression 节点的表达式
	 * @return
	 */
	public List<Element> getNodes(InputStream is, String expression) {
		try {
			SAXReader saxReader = new SAXReader();
			saxReader.setEncoding("UTF-8");
			org.dom4j.Document document = saxReader.read(is);
			List<Element> list = document.selectNodes(expression);
			return list;
		} catch (DocumentException e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * org.w3c.dom
	 * 
	 * @param filePath
	 * @param xPath
	 */
	@Deprecated
	public void getNodes(String filePath, String xPath, String str) {
		try {
			// document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(false);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(filePath);
			int length01 = doc.getChildNodes().getLength();
			logger.info("length01: " + length01);

			// xpath
			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();
			XPathExpression expr = xpath.compile(xPath);
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			int length02 = nodes.getLength();
			logger.info("length02: " + length02);
			for (int i = 0; i < nodes.getLength(); i++) {
				logger.info(i + "." + nodes.item(i));
			}

		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void test01() {
	}

	/**
	 * Singleton
	 */
	private static XPathByDom4jUtil xpathUtil;

	private XPathByDom4jUtil() {
		strXML = "/com/pyramidDB/util/file/Log.xml";
	}

	public static XPathByDom4jUtil getInstance() {
		return xpathUtil == null ? new XPathByDom4jUtil() : xpathUtil;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// XPathByDom4jUtil xpathUtil = XPathByDom4jUtil.getInstance();
		//
		// String strFilePath = XPathByDom4jUtil.class.getClass()
		// .getResource(strXML).getPath(), //
		// // expression = "//logQueryResult//log//logId";
		// // expression = "//logId[@id='2']";
		// expression = "//logId";
		// xpathUtil.getNodes(strFilePath, expression).forEach(
		// node -> logger.info(node.getName() + ", " + node.getText()));
		//
		// // // org.w3c.dom.*
		// // String filePath = XPathUtil.class.getClass()
		// // .getResource("/com/pyramidDB/util/Log.xml").getPath(), // 要读取的文件
		// // xPath = "//logQueryResult//log//logId"; // 节目路径
		// // // xPath = "//log//logId[@id='2']";
		// // xpathUtil.getNodes(filePath, xPath);
		//
		// // // org.dom4j.dom.*
		// // xpathUtil.test01();

	}
}
