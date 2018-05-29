package com.pyramid.utils.file.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:26:08<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file.xml<br>
 * @File: XPathByW3CUtil.java<br>
 * @Description: （没有dom4j好用~~~，推荐dom4j的xpath解析）使用W3C包解析XML<br>
 */
public class XPathByW3CUtil {

	private static Logger logger = Logger.getLogger(XPathByW3CUtil.class);

	/**
	 * W3C解析XML文件
	 * 
	 * @param String
	 *            strFilePath 要解析的文件路径
	 * @param String
	 *            expression 节点表达式
	 * @return
	 */
	public List getNodes(String strFilePath, String expression) {
		File file = new File(strFilePath);
		return getNodes(file, expression);
	}

	/**
	 * W3C解析XML文件
	 * 
	 * @param File
	 *            file 要解析的文件
	 * @param String
	 *            expression 节点表达式
	 * @return
	 */
	public List getNodes(File file, String expression) {
		try {
			FileInputStream fis = new FileInputStream(file);
			return getNodes(fis, expression);
		} catch (FileNotFoundException e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * W3C解析XML文件
	 * 
	 * @param InputStream
	 *            is 数据流
	 * @param String
	 *            expression 节点表达式
	 * @return
	 */
	public List getNodes(InputStream is, String expression) {

		try {
			// // 读取XML文件到内存
			// DocumentBuilderFactory dbf =
			// DocumentBuilderFactory.newInstance();
			// DocumentBuilder dbd = dbf.newDocumentBuilder();
			// Document dom = dbd.parse(is);

			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer transFormer = transFact.newTransformer();
			DOMResult dom = new DOMResult();
			transFormer.transform(new StreamSource(is), dom);

			XPath xpath = XPathFactory.newInstance().newXPath();

			// Node author = (Node) xpath.evaluate(expression, dom,
			// XPathConstants.NODE);
			// logger.info("名称：" + author.getNodeName() + ", 内容："
			// + author.getTextContent());// 如果存在内容则返回内容，不存在则返回空

			// Map<String,String> prefix2uri = new HashMap<String,String>(){{
			//
			// put("foo","http://www.baidu.com");
			// put("bar","http://www.google.com");
			//
			// }};
			//
			// Map<String,String> uri2prefix = new HashMap<String,String>(){{
			// put("http://www.baidu.com","foo");
			// put("http://www.google.com","bar");
			// }};

			// xpath.setNamespaceContext(new NsSolver(prefix2uri,uri2prefix));

			XPathExpression xpathExpression = xpath.compile(expression);

			NodeList nodeList = (NodeList) xpathExpression.evaluate(
					dom.getNode(), XPathConstants.NODESET);

			int length02 = nodeList.getLength();
			logger.info("length: " + length02);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				logger.info((i + 1) + "." + node.getNodeName() + ", "
						+ node.getNodeValue());
				NamedNodeMap nnmap = node.getAttributes();
				for (int j = 0; j < nnmap.getLength(); j++) {
					Node nnnode = nnmap.item(j);
					logger.info(nnnode.getNodeName() + ", "
							+ nnnode.getNodeValue());
				}
			}

		} catch (TransformerConfigurationException e) {
			logger.error(e);
		} catch (XPathExpressionException e) {
			logger.error(e);
		} catch (TransformerFactoryConfigurationError e) {
			logger.error(e);
		} catch (TransformerException e) {
			logger.error(e);
		}

		return null;
	}

	/**
	 * Singleton
	 */
	private static XPathByW3CUtil xpathUtil;

	private XPathByW3CUtil() {

	}

	public static XPathByW3CUtil getInstance() {
		return xpathUtil == null ? new XPathByW3CUtil() : xpathUtil;
	}

	public static void main(String[] args) {

		XPathByW3CUtil xpathUtil = XPathByW3CUtil.getInstance();

		String strFilePath = XPathByW3CUtil.class.getClass()
				.getResource("/com/pyramidDB/util/Log.xml").getPath(), //
		// expression = "//logQueryResult//log//logId";
		expression = "//logId[@id='2']";
		xpathUtil.getNodes(strFilePath, expression);

	}

}
