package com.zyc.annotation.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect  //该注解表名告诉spring该类为一个切面类
public class LogAspectJ {

    /**
     * 抽取公共的切入点表达式
     * 1、本类引用：@Pointcut("public int MathTest.*(..)")
     * 2、其他切面引用：@Pointcut("execution(public int MathTest.*(..))")
     * 3、可以使用不带修饰符域返回值： @Pointcut("execution(* com.spring.one.chapterFour.aspectOrientedProgramming.Performance.perfrom(..))")
     */
    @Pointcut("execution(public int com.zyc.annotation.spring.aop.MathTest.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] objs = joinPoint.getArgs();//得到切点参数
        System.out.println(""+joinPoint.getSignature().getName()+"运行。。。@Before:参数列表是：{"+ Arrays.asList(objs)+"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"结束。。。@After");
    }

    //JoinPoint一定要出现在参数表的第一位,可以得到返回值
    @AfterReturning(value="pointCut()",returning="result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning:运行结果：{"+result+"}");
    }

    @AfterThrowing(value="pointCut()",throwing="exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
    }
    //
    ////环绕通知方法
    //@Around("pointCut()")
    //public void watchPerformance (ProceedingJoinPoint joinPoint) {
    //    try {
    //        System.out.println("silenceCellPhones");
    //        System.out.println("takeSeats");
    //        joinPoint.proceed();//手动调用
    //        System.out.println("applause");
    //    } catch (Throwable e) {
    //        System.out.println("demandRefund");
    //    }
    //}


}