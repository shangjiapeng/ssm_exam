package com.shang.controller;

import com.shang.domain.SysLog;
import com.shang.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;//开始时间
    private Class clazz;//访问的类
    private Method method;//访问的方法

    //前置通知 只要是获取开始的时间,执行的类是哪一个,执行的是哪一个方法
    @Before("execution(* com.shang.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {

        try {
            visitTime = new Date();//当前时间就是当前的访问时间
            clazz = joinPoint.getTarget().getClass();//具体要访问的类
            String methodName = joinPoint.getSignature().getName();//获取访问的方法
            Object[] args = joinPoint.getArgs();//获取访问的方法的参数

            //获取具体执行的方法的Method对象
            if (args == null || args.length==0){
                method=clazz.getMethod(methodName);//只能获取无参的方法名
            }else {
                Class[] classArgs= new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    classArgs[i]=args[i].getClass();//此处难理解
                }
                method=clazz.getMethod(methodName,classArgs);//获取有参方法名
            }
        } catch (Exception e) {
            System.out.println("***********"+e.getMessage());//打印输出异常信息
        }
    }

    //后置通知
    @After("execution(* com.shang.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        try {
            long time =new Date().getTime()-visitTime.getTime();//获取访问的总时长
            String url="";
            //获取url
            if (clazz!= null&&method!=null&clazz!=LogAop.class){
                //1获取类上的@RequestMapping("/..)
                RequestMapping classAnnotation=(RequestMapping)clazz.getAnnotation(RequestMapping.class);
                if (classAnnotation!=null){
                    String[] classValue=classAnnotation.value();
                    //2获取方法上的@RequestMapping("/xxx)
                    RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                    if (methodAnnotation!=null){
                        String[] methodValue = methodAnnotation.value();
                        url=classValue[0]+methodValue[0];

                        //获取访问的IP
                        String ip = request.getRemoteAddr();

                        //获取当前操作的用户
                        //可以通过securityContext获取,也可以从request.getSession 中获取
                        SecurityContext context = SecurityContextHolder.getContext();
                        String username = ((User) context.getAuthentication().getPrincipal()).getUsername();

                        //将日志的相关信息封装到SysLog 对象中
                        SysLog sysLog = new SysLog();
                        sysLog.setExecutionTime(time);//执行时长
                        sysLog.setIp(ip);
                        sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                        sysLog.setUrl(url);
                        sysLog.setUsername(username);
                        sysLog.setVisitTime(visitTime);

                        //调用service层完成存储日志的操作
                        sysLogService.addSysLog(sysLog);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("************"+e.getMessage());
        }
    }
}
