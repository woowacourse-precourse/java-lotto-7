package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Container {
    private static final Map<Class<?>, Supplier<?>> registry = new HashMap<>();
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