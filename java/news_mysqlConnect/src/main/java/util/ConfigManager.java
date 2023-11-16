package util;

import java.io.InputStream;
import java.util.Properties;

// 读取属性文件的类
public class ConfigManager {
	// 懒汉模式
	private static ConfigManager configManager;
	// 读取属性文件
	private static Properties properties;

	// 初始化读取属性文件
	private ConfigManager() {
		String configFile = "database.properties";
		properties = new Properties();
		// 输入流对象
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConfigManager Instance() {
		if (configManager == null) {
			configManager = new ConfigManager();
		}
		return configManager;
	}

	// 根据key获取value
	public String getVaule(String key) {
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		ConfigManager manger = new ConfigManager();
		System.out.println(manger.getVaule("jdbc.driver"));

	}
}
