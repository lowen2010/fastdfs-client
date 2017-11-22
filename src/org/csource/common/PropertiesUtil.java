package org.csource.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * 加载配置文件工具类
 * @author chengw
 *
 */
public class PropertiesUtil {
	
	private Properties properties;

	/**
	 * 加载fastdfs配置文件，如加载src下fdfs_clinet.properties,configName='/fdfs_client.properties'
	 * @param configName
	 */
	public void loadProperties(String configName){
		Properties prop = new Properties();
		try {
			InputStream is=this.getClass().getResourceAsStream(configName);
			prop.load(is);
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setProperties(prop);
	}

	public Properties getProperties() {
		return properties;
	}

	private void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	/**
	 * 取出Property，取不到返回空字符串.
	 */
	private String getValue(String key) {
		if (properties.containsKey(key)) {
	        return properties.getProperty(key);
	    }
	    return "";
	}
	
	/**
	 * 取出String类型的Property.如果都为Null则抛出异常.
	 */
	public String getProperty(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return value;
	}
	
	/**
	 * 取出String类型的Property.如果都为Null则返回Default值.
	 */
	public String getProperty(String key, String defaultValue) {
		String value = getValue(key);
		return value != null ? value : defaultValue;
	}
	
	/**
	 * 取出Integer类型的Property.如果都为Null或内容错误则抛出异常.
	 */
	public Integer getInteger(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Integer.valueOf(value);
	}
	
	/**
	 * 取出Integer类型的Property.如果都为Null则返回Default值，如果内容错误则抛出异常
	 */
	public Integer getInteger(String key, Integer defaultValue) {
		String value = getValue(key);
		return value != null ? Integer.valueOf(value) : defaultValue;
	}
	
	/**
	 * 取出Double类型的Property.如果都为Null或内容错误则抛出异常.
	 */
	public Double getDouble(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Double.valueOf(value);
	}
	
	/**
	 * 取出Double类型的Property.如果都为Null则返回Default值，如果内容错误则抛出异常
	 */
	public Double getDouble(String key, Integer defaultValue) {
		String value = getValue(key);
		return value != null ? Double.valueOf(value) : defaultValue;
	}
	
	/**
	 * 取出Boolean类型的Property.如果都为Null抛出异常,如果内容不是true/false则返回false.
	 */
	public Boolean getBoolean(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Boolean.valueOf(value);
	}
	
	/**
	 * 取出Boolean类型的Property.如果都为Null则返回Default值,如果内容不为true/false则返回false.
	 */
	public Boolean getBoolean(String key, boolean defaultValue) {
		String value = getValue(key);
		return value != null ? Boolean.valueOf(value) : defaultValue;
	}
	
	/**
	 * 读取以逗号分隔的参数，返回一个string数组
	 * @param key
	 * @return
	 */
	public String[] getStrArray(String key){
		String value = getValue(key);
		return value.split(",");
	}
	
}
