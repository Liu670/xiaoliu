package com.nuist.test.util;
// CaptchaUtil.java

import java.util.Random;

public class CaptchaUtil {
	public static String generateCaptcha() {
		// 生成随机验证码，这里简化为4位数字
		Random random = new Random();
		int captchaNumber = 1000 + random.nextInt(9000);
		return String.valueOf(captchaNumber);
	}

}
