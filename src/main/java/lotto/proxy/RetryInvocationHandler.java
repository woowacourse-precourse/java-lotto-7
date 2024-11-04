package lotto.proxy;

import lotto.annotation.Retry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RetryInvocationHandler implements InvocationHandler {

    private final Object target;

    public RetryInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = getTargetMethod(method);
        Retry retry = getRetryAnnotation(targetMethod);

        if (retry == null) {
            return invokeMethod(targetMethod, args);
        }

        return invokeWithRetry(targetMethod, args, retry.delay());
    }

    private Method getTargetMethod(Method method) throws NoSuchMethodException {
        return target.getClass().getMethod(method.getName(), method.getParameterTypes());
    }

    private Retry getRetryAnnotation(Method method) {
        return method.getAnnotation(Retry.class);
    }

    private Object invokeMethod(Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(target, args);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    private Object invokeWithRetry(Method method, Object[] args, long delay) throws Throwable {
        while (true) {
            try {
                return method.invoke(target, args);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (!(cause instanceof IllegalArgumentException)) {
                    throw cause;
                }
                System.out.println(cause.getMessage());
                Thread.sleep(delay);
            }
        }
    }
}
