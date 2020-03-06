package cn.qianfg.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    static Properties properties = null;

    //定义一个Map,用于存放我们要创建的对象。我们称之为容器
    private static Map<String, Object> beans;

    static {
        try {
            //实例化对象
            properties = new Properties();
            //加载properties配置文件
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(inputStream);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器
                beans.put(key, value);

            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化工厂失败！");
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

//    public static Object getBean(String beanName) {
//        Object bean = null;
//        try {
//            //根据beanName从配置文件获取权限定类名
//            String beanPath = properties.getProperty(beanName);
////            System.out.println("【bean对象】：" + beanName + "，【全限定类名】：" + beanPath);
//            //每次都会调用默认构造函数创建对象
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
