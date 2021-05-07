package base.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static class JDKProxy implements InvocationHandler {
        private Object target;

        public Object newJDKProxy(Object target) {
            this.target = target;
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            before();
            Object obj = method.invoke(target);
            after();
            return obj;
        }

        private void before() {
            System.out.println("before..");
        }

        private void after() {
            System.out.println("after..");
        }
    }

}
