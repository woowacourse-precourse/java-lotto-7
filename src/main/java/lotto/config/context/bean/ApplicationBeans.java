package lotto.config.context.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.config.context.ApplicationComponents;
import lotto.config.context.ContextProxy;

/**
 * 빈을 생성하고 관리하는 클래스
 */
public class ApplicationBeans {

    private final Map<Class<?>, Object> beans = new ConcurrentHashMap<>();
    private final ApplicationComponents components;

    public ApplicationBeans(Class<?> baseClass) {
        this.components = new ApplicationComponents(baseClass);
    }

    public <T> T get(Class<T> cls) {
        return cls.cast(beans.computeIfAbsent(cls, this::create));
    }

    private <T> T create(Class<T> cls) {
        try {
            if (cls.isInterface()) {
                return createFromInterface(cls);
            }

            Constructor<?> constructor = extractConstructor(cls);
            List<Object> parameters = extractParameters(constructor);

            return cls.cast(constructor.newInstance(parameters.toArray()));
        } catch (NoSuchMethodException
                 | InvocationTargetException
                 | InstantiationException
                 | IllegalAccessException e) {
            return null;
        }
    }

    private <T> T createFromInterface(Class<T> interfaceClass) {
        return components.findImplementation(interfaceClass)
                .map(this::create)
                .map(it -> ContextProxy.createProxy(it, interfaceClass))
                .orElse(null);
    }

    private <T> Constructor<?> extractConstructor(Class<T> cls) throws NoSuchMethodException {
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        if (constructors.length == 0) {
            return cls.getDeclaredConstructor();
        }

        return constructors[0];
    }

    private List<Object> extractParameters(Constructor<?> constructor) {
        Stream<Object> exits = Stream.of(constructor.getParameterTypes())
                .map(beans::get)
                .filter(Objects::nonNull);

        Stream<Object> created = Stream.of(constructor.getParameterTypes())
                .filter(it -> !beans.containsKey(it))
                .map(this::create);

        return Stream.concat(exits, created)
                .collect(Collectors.toList());
    }
}
