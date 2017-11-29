package cc.innosoft.thirdchat.Interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author y.ni
 * @Version 1.0.0
 * @Date 2017/4/9
 */
@Aspect
public class UserFlushInterceptor{
    @Pointcut("execution(* cc.innosoft.thirdchat.controller.user.UserController.*(..))")
    private void anyMethod(){}//定义一个切入点

    public UserFlushInterceptor(){
        System.out.println("拦截器已经实例化");
    }

    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name){
        System.out.println(name);
        System.out.println("前置通知");
    }
}
