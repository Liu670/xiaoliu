package com.nuist.test.util;
// CaptchaImageUtil.java

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class CaptchaImageUtil {
	public static void writeCaptchaImage(OutputStream outputStream, String captcha) throws IOException {
		int width = 80;
		int height = 40;

		// 创建图像缓冲区
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();

		// 填充背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		// 设置字体
		g.setFont(new Font("Arial", Font.BOLD, 20));

		// 画边框
//		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);

		// 画干扰线
		g.setColor(Color.GRAY);
		for (int i = 0; i < 10; i++) {
			int x1 = (int) (Math.random() * width);
			int y1 = (int) (Math.random() * height);
			int x2 = (int) (Math.random() * width);
			int y2 = (int) (Math.random() * height);
			g.drawLine(x1, y1, x2, y2);
		}

		// 画验证码
//		g.setColor(Color.BLACK);
		g.drawString(captcha, 10, 25);

		// 输出图像
		ImageIO.write(image, "JPEG", outputStream);
	}
}
