package com.pyramid.utils.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:25:03<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.encrypt<br>
 * @File: CoderUtil.java<br>
 * @Description: <br>
 */
public class CoderUtil {

	// logger
	private static Logger logger = Logger.getLogger(CoderUtil.class);

	private static final String strEncrypt = "123456789912345678991234";

	/**
	 * 
	 * @param str
	 * @return
	 */
	public byte[] getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}
		byte[] byteArray = messageDigest.digest();
		return byteArray;
	}

	/**
	 * 二进制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public String byte2hex(byte[] b) {
		StringBuilder sb = new StringBuilder();
		String tmp = "";
		for (int i = 0; i < b.length; i++) {
			tmp = Integer.toHexString(b[i] & 0XFF);
			if (tmp.length() == 1) {
				sb.append("0" + tmp);
			} else {
				sb.append(tmp);
			}
		}
		return sb.toString();
	}

	/**
	 * 对字符串进行加密
	 * 
	 * @param safeString
	 * @return
	 */
	public String ownEncode(String safeString) {
		byte[] keykey1;
		String keyString = null;
		try {
			byte[] keykey = strEncrypt.getBytes("UTF-8");
			keykey1 = safeString.getBytes("UTF-8");
			byte[] safeStringkey = DESedeCoder.encrypt(keykey1, keykey);
			keyString = String.valueOf(Hex.encodeHex(safeStringkey));
			return keyString;
		} catch (Exception e) {
			logger.error(e);
			return keyString;
		}
	}

	/**
	 * 对字符串进行解密
	 * 
	 * @param code
	 * @return
	 */
	public String ownDecode(String code) {
		String keyString = null;
		try {
			byte[] keykey = strEncrypt.getBytes("UTF-8");
			char[] chars = new char[code.length()];
			code.getChars(0, code.length(), chars, 0);
			byte[] bytes2 = Hex.decodeHex(chars);
			keyString = new String(DESedeCoder.decrypt(bytes2, keykey), "UTF-8");
			return keyString;
		} catch (Exception e) {
			logger.error(e);
			return keyString;
		}
	}

	/**
	 * 对字符串进行加密并MD5
	 */
	public String ownEncodeMd5(String safeString) {
		String safe = ownEncode(safeString);
		safe = byte2hex(getMD5Str(safe));
		return safe;
	}

	/**
	 * Singleton
	 */
	private static CoderUtil coderUtil;

	private CoderUtil() {

	}

	public static CoderUtil getInstance() {
		return coderUtil == null ? new CoderUtil() : coderUtil;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * // System.out.println(ownDecode("71d24c4800445155"));
		 * 
		 * CoderUtil coderUtil = CoderUtil.getInstance();
		 * 
		 * String str = "9999"; String encode = coderUtil.ownEncode(str);
		 * logger.info("encode: " + encode); String decode =
		 * coderUtil.ownDecode(encode); logger.info("decode: " + decode);
		 */
	}
}
