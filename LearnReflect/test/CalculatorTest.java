package LearnReflect.test;

import LearnReflect.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化方法:
     *      用于资源申请，所有测试方法执行之前都会先执行该方法
     * 注解 @Before
     */
    @Before
    public void init(){
        System.out.println("init...");
    }


    /**
     * 释放资源的方法
     *      在所有测试方法执行完后，自动执行该方法
     * 注解 @After
     */
    @After
    public void close(){
        System.out.println("close...");
    }



    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){
        //创建计算器对象调用add方法
        Calculator calc = new Calculator();
        int result = calc.add(2,6);
        //System.out.println(result);

        //断言 ， 我断言这个结果是什么，系统会把我的断言和程序的结果比较
        //正确绿色，失败红色
        Assert.assertEquals(8,result);
    }

    @Test
    public void testSub(){
        Calculator calc = new Calculator();
        int result = calc.sub(4,5);
        System.out.println("sub方法测试...");
        Assert.assertEquals(-1,result);
    }
}
