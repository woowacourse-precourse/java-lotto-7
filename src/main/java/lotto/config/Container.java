package lotto.config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Container 클래스는 객체 생성을 관리하는 간단한 DI(Dependency Injection) 컨테이너 역할을 한다.
 * 이 클래스는 등록된 객체 타입의 인스턴스를 제공하고, 인스턴스를 싱글톤으로 관리한다.
 */
public class Container {
    // 등록된 타입과 해당 객체를 생성하는 Supplier를 매핑하여 저장하는 맵
    private static final Map<Class<?>, Supplier<?>> registry = new HashMap<>();
    // 생성된 싱글톤 인스턴스를 타입별로 저장하는 맵
    private static final Map<Class<?>, Object> singletons = new HashMap<>();

    private Container() {
    }

    public static void register(Class<?> type, Supplier<?> provider) {
        registry.put(type, provider);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> type) {
        if (singletons.containsKey(type)) {
            return (T) singletons.get(type);
        }

        Supplier<?> provider = registry.get(type);
        if (provider == null) {
            throw new IllegalArgumentException("No provider registered for " + type.getName());
        }

        T instance = (T) provider.get();
        singletons.put(type, instance);
        return instance;
    }

    public static void reset() {
        registry.clear();
        singletons.clear();
    }
}