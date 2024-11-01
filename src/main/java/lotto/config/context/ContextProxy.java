package lotto.config.context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 메서드를 실행하기 이전 특정 작업을 수행하는 프록시 클래스
 */
public class ContextProxy implements InvocationHandler {

    private final Object target;

    public ContextProxy(Object target) {
        this.target = target;
    }

    public static <T> T createProxy(Object target, Class<T> interfaceType) {
        return interfaceType.cast(Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new ContextProxy(target)
        ));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}