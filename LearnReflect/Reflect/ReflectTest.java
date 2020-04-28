package LearnReflect.Reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 假设的框架类
 */

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，可以执行任意方法
       /* Person p = new Person();
        p.show();*/



        //1.加载配置文件pro.peopertise
        //1.1创建Properties 对象
        Properties pro = new Properties();

        //1.2加载配置文件，转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("pro.properties");
        pro.load(in);


        //2.获取配置中定义的数据
        String className = pro.getProperty("className");
        String classMethod = pro.getProperty("methodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);

        //4.创建对象
        Object obj = cls.getDeclaredConstructor().newInstance();

        //5.获取方法对象
        Method method = cls.getMethod(classMethod);

        //6.执行方法
        method.invoke(obj);
    }
}