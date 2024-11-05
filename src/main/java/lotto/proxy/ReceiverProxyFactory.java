package lotto.proxy;

import java.lang.reflect.Proxy;

public class ReceiverProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new RetryInvocationHandler(target)
        );
    }
}
