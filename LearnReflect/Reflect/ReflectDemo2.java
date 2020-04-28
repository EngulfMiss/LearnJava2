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

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        //1.获取Person的Class对象
        Class cls1 = Person.class;

        /*1.获取成员变量们
                - Field[] getFields()
                - Field getField(String name)

                - Field[] getDeclaredFields()
                - Field getDeclaredField(String name)*/

        Field[] field = cls1.getFields();
        for(Field f:field){
            System.out.println(f);
        }

        System.out.println("------------------------------------------");
        //Field getField(String name)
        Field f = cls1.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object o = f.get(p);
        System.out.println(o);

        //设置a的值
        f.set(p,"Gnar");
        System.out.println(p);

        System.out.println("---------------------------------------");
        //Field[] getDeclaredFields()
        Field[] fields = cls1.getDeclaredFields();
        for(Field i:fields){
            System.out.println(i);
        }

        Field fd = cls1.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查，不然直接访问private会抛异常

        //暴力反射
        fd.setAccessible(true);

        Object value = fd.get(p);
        System.out.println(value);
    }
}
