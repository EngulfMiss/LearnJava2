package LearnReflect.annotation.Reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 假设的框架类
 */
@Pro(className = "LearnReflect.annotation.Reflect.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        /*
            前提：不能改变该类的任何代码，可以创建任意类的对象，可以执行方法
         */
        //1.解析注解
        //1.1 获取该类的字节码文件对象

        Class<ReflectTest> cls = ReflectTest.class;

        //2.获取上面的注解对象
        //下面其实就是在内存中生成了一个该注解接口的子类实现对象
        /*
            public class ProImpl implments Pro{
                public String className(){
                    return "LearnReflect.annotation.Reflect.Demo1";
                }

                public String methodName(){
                    return "show";
                }
            }
         */
        Pro anno = cls.getAnnotation(Pro.class);

        //3.调用注解对象中定义的抽象方法，获取返回值
        String cn = anno.className();
        String mn = anno.methodName();
        System.out.println(cn);
        System.out.println(mn);

        //4.加载该类进内存
        Class clss = Class.forName(cn);

        //5.创建对象
        Object obj = clss.getDeclaredConstructor().newInstance();

        //6.获取方法对象
        Method method = clss.getMethod(mn);

        //7.执行方法
        method.invoke(obj);

    }
}
