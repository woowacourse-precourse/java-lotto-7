package lotto.config.context;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import lotto.config.validation.Validation;
import lotto.config.validation.annotation.Valid;

/**
 * 프록시 객체를 생성하는 클래스
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
        validation(method, args);

        return method.invoke(target, args);
    }

    private void validation(Method method, Object[] arguments) {
        List<Parameter> parameters = List.of(method.getParameters());

        for (int index = 0; index < parameters.size(); index++) {
            Parameter parameter = parameters.get(index);
            Object argument = arguments[index];

            if (parameter.isAnnotationPresent(Valid.class)) {
                validParameter(parameter, argument);
            }
        }
    }

    private void validParameter(Parameter parameter, Object argument) {
        List<Annotation> annotations = Arrays.stream(parameter.getAnnotations())
                .filter(it -> !it.annotationType().equals(Valid.class))
                .toList();

        for (final Annotation annotation : annotations) {
            Validation.valid(annotation, argument);
        }
    }
}
