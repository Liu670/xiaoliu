package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// 加载配置文件的工具类
public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;

	// 构造方法初始化读取文件
	private ConfigManager() {
		String configFile = "database.properties";
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		properties = new Properties();
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
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
	public String getValue(String key) {
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(ConfigManager.Instance().getValue("driver"));
		System.out.println(ConfigManager.Instance().getValue("url"));
		System.out.println(ConfigManager.Instance().getValue("username"));
		System.out.println(ConfigManager.Instance().getValue("password"));
	}
}
