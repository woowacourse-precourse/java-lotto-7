package lotto.config.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.config.context.bean.ApplicationBeans;

/**
 * 어플리케이션의 컨텍스트 상태를 관리하는 클래스
 */
public class ApplicationContext {

    private static final Map<Class<?>, ApplicationContext> instances = new ConcurrentHashMap<>();

    private final ApplicationBeans beans;

    private ApplicationContext(Class<?> baseClass) {
        this.beans = new ApplicationBeans(baseClass);
    }

    public static ApplicationContext getInstance(Class<?> baseClass) {
        return instances.computeIfAbsent(baseClass, ApplicationContext::new);
    }

    public <T> T getBean(Class<T> cls) {
        return beans.get(cls);
    }
}