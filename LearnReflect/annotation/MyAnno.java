package LearnReflect.annotation;
@SuppressWarnings("all")



public @interface MyAnno {
    String show() default "Gnar";
    int age();
    Person per();
    //注解名 属性名();
    String[] strs();
}
