package cn.edu.cims.sunwa2.aop;

import cn.edu.cims.sunwa2.model.OperationLog;
import cn.edu.cims.sunwa2.service.OperationLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Autowired
    private OperationLogService operationLogService;
    @Pointcut("@annotation(cn.edu.cims.sunwa2.aop.MyLog)")
    public void MyLog() {
        //一个标记方法
    }
//    @Pointcut("execution(public * cn.edu.cims.sunwa2.config.SecurityConfig.*(..))")
//    public void loginLog() {
//        //一个标记方法
//    }

    @Pointcut("execution(public * cn.edu.cims.sunwa2.controller.*.*(..))")
    public void warnLog() {
        //一个标记方法
    }
    @Before("warnLog()&&MyLog()")
    public void print(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();    ////从切面织入点处通过反射机制获取织入点处的方法
        Method method = signature.getMethod();         ////获取切入点所在的方法
        MyLog myLog = method.getAnnotation(MyLog.class);      //获取操作     表示得到该 Target 某个 Annotation 的信息，因为一个 Target 可以被多个 Annotation 修饰  得到注解信息
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String value = myLog.value();
        OperationLog operationLog =new OperationLog();
        operationLog.setEvents(value);
        operationLog.setTime(date);
        operationLog.setOperator(username);
        operationLogService.save(operationLog);
        System.out.println("执行方法:" +value + "--执行时间："+simpleDateFormat.format(date));
    }
//    @Before("loginLog()&&MyLog()")
//    public void print1(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();    ////从切面织入点处通过反射机制获取织入点处的方法
//        Method method = signature.getMethod();         ////获取切入点所在的方法
//        MyLog myLog = method.getAnnotation(MyLog.class);      //获取操作     表示得到该 Target 某个 Annotation 的信息，因为一个 Target 可以被多个 Annotation 修饰  得到注解信息
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        String value = myLog.value();
//        OperationLog operationLog =new OperationLog();
//        operationLog.setEvents(value);
//        operationLog.setTime(date);
//        operationLog.setOperator("admin");
//        operationLogService.save(operationLog);
//        System.out.println("执行方法:" +value + "--执行时间："+simpleDateFormat.format(date));
//    }
}
