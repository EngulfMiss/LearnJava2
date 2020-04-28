package LearnReflect.Reflect;

/*
    * 获取Class对象的方式：
        1.Class.forName("全类名"); 将字节码文件加载进内存，返回Class对象
        2.类名.class ： 通过类名的属性class获取
        3.对象.getClass() : getClass()方法在Object类中定义
 */

import LearnReflect.domain.Person;
import LearnReflect.domain.Student;

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        Class cls1 = Class.forName("LearnReflect.domain.Person");
        System.out.println(cls1);

        Class cls2 = Person.class;
        System.out.println(cls2);

        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //== 比较三个对象
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);

        Class C = Student.class;
        System.out.println(C == cls1);
    }
}
