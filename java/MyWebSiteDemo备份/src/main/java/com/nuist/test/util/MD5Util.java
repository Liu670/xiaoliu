package com.nuist.test.util;
// MD5Util.java

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// md5加密
public class MD5Util {
	public static String encrypt(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte[] digest = md.digest();

			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
