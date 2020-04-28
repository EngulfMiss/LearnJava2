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

import java.lang.reflect.Constructor;


public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        //1.获取Person的Class对象
        Class cls1 = Person.class;

        /*2.获取构造方法们
                - Constructor<?>[] getConstructors()
                - Constructor<T> getConstructor(Class<?>... parameterTypes)

                - Constructor<?>[] getDeclaredConstructors()
                - Constructor<T> getDeclaredConstructors(Class<?>... parameterType)*/

        Constructor constructor = cls1.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("Gnar",7);
        System.out.println(person);
        System.out.println("-------------------------------------------");

        Constructor constructor2 = cls1.getConstructor();
        System.out.println(constructor2);
        //创建对象
        Object person2 = constructor2.newInstance();
        System.out.println(person2);

        Object person3 = cls1.newInstance();
        System.out.println(person3);

        //constructor.setAccessible(true);
    }
}
