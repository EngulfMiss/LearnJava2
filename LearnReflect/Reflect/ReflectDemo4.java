package LearnReflect.Reflect;

/*
    1.获取成员变量们
                - Field[] getFields()
                - Field getField(String name)

                - Field[] getDeclaredFields()
                - Field getDeclaredField(String name)

            2.获取构造方法们
                - Constructor<?>[] getConstructors()
                - Constructor<T> getConstructor(Class<?>... parameterTypes)

                - Constructor<?>[] getDeclaredConstructors()
                - Constructor<T> getDeclaredConstructors(Class<?>... parameterType)

            3.获取成员方法们
                - Method[] getMethods()
                - Method getMethod(String name,Class<?>... parameterTypes)

                - Method[] getDeclaredMethods()
                - Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 */

import LearnReflect.domain.Person;
import java.lang.reflect.Method;


public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        //1.获取Person的Class对象
        Class cls1 = Person.class;

        /*3.获取成员方法们
                - Method[] getMethods()
                - Method getMethod(String name,Class<?>... parameterTypes)

                - Method[] getDeclaredMethods()
                - Method getDeclaredMethod(String name,Class<?>... parameterTypes)*/

        Method Amethod = cls1.getMethod("show");
        Person p = new Person();
        Amethod.invoke(p);

        Method Amethod2 = cls1.getMethod("say",String.class);
        Amethod2.invoke(p,"Hello");

        System.out.println("---------------------------");

        //获取类名
        String str = cls1.getName();
        System.out.println(str);



        //获取所有public修饰的方法
//        Method[] methods = cls1.getMethods();
//        for(Method m:methods){
//            System.out.println(m);
//            String name = m.getName();
//            System.out.println(name);
//        }

        //System.out.println("---------------------------");
//        Method[] methods = cls1.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }


        /* 暴力反射
        Method Am = cls1.getDeclaredMethod("eat");
        Am.setAccessible(true);
        Am.invoke(p);*/
    }
}
