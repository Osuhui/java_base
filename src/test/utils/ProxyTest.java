package test.utils;

import base.utils.ProxyUtil;
import org.junit.jupiter.api.Test;

public class ProxyTest {

    public interface ProxyHandler {
        void execute();
    }

    public static class JDKProxyHandler implements ProxyHandler {
        @Override
        public void execute() {
            System.out.println("execute..");
        }
    }

    @Test
    public void testJDK() {
        ProxyUtil.JDKProxy jdkProxy = new ProxyUtil.JDKProxy();
        ProxyHandler jdkProxyHandler = (ProxyHandler) jdkProxy.newJDKProxy(new JDKProxyHandler());
        jdkProxyHandler.execute();
    }
}
