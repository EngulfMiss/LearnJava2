package LearnReflect.junit;

/*
    Junit单元测试：
    步骤：
        1.定义一个测试类(测试用例)
        建议：测试类名：被测试的类名+Test        例如：CalculatorTest
              包名：xxx.xxx.xx.test

        2.定义测试方法：可以独立运行
        建议：方法名：test+测试的方法名          例如：testAdd()
              返回值：void
              参数列表：空参

        3.给方法加@Test
        4.导入junit的依赖环境(点下小灯泡)

    结果：
        绿色：成功
        红色：失败
        一般我们会采用断言的方式来判断结果
     断言类：Assert 中的很多静态方法
     例如：Assert.assertEquals(8,result);   前者为期望的结果，后者为运算的结果


     补充：
        @Before 修饰的方法会在测试方法之前自动执行
        @After  修饰的方法会在测试方法执行之后自动被执行
 */

public class Test {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = calc.add(3,4);
        System.out.println(result);
    }
}
