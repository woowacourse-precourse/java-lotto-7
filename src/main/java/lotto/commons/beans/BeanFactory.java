package lotto.commons.beans;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private static final ConcurrentHashMap<Class<?>, Object> beanContextHolder = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> T findBean(Class<T> clazz) {
        return (T) beanContextHolder.computeIfAbsent(clazz, BeanFactory::newInstance);
    }

    @SuppressWarnings("unchecked")
    private static <T> T newInstance(Class<T> clazz) {
        try {
            Constructor<?>[] constructors = clazz.getConstructors();

            if (constructors.length == 0) {
                throw new IllegalStateException(clazz.getName() +"에 해당하는 생성자를 찾을 수 없습니다.");
            }

            Constructor<?> constructor = constructors[0];
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            if (parameterTypes.length == 0) {
                return (T) constructor.newInstance();
            }

            Object[] parameters = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                parameters[i] = BeanFactory.newInstance(parameterTypes[i]);
            }

            return (T) constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new IllegalStateException(clazz.getName() + "에 해당하는 bean 을 생성하는 과정에서 오류가 발생하였습니다.", e);
        }
    }
}
