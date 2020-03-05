package cn.qianfg.factory;

import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    static Properties properties = null;

    static {
        try {
            //实例化对象
            properties = new Properties();
            //加载properties配置文件
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化工厂失败！");
        }
    }

    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            //根据beanName从配置文件获取权限定类名
            String beanPath = properties.getProperty(beanName);
            System.out.println("【bean对象】：" + beanName + "，【全限定类名】：" + beanPath);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
