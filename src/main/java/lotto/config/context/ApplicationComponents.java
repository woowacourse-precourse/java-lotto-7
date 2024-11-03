package lotto.config.context;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lotto.config.context.annotation.Component;
import lotto.config.context.scanner.ClassPathScanner;

/**
 * 클래스 컴포넌트를 관리하는 클래스
 */
public class ApplicationComponents {

    private static final Class<? extends Annotation> COMPONENT_ANNOTATION = Component.class;

    private final List<Class<?>> components;

    public ApplicationComponents(Class<?> baseClass) {
        this.components = scan(baseClass);
    }

    public Optional<Class<?>> findImplementation(Class<?> cls) {
        return components.stream()
                .filter(cls::isAssignableFrom)
                .findFirst();
    }

    private List<Class<?>> scan(Class<?> baseClass) {
        return ClassPathScanner.getInstance(baseClass)
                .scan(this::isComponent);
    }

    private boolean isComponent(Class<?> cls) {
        return Arrays.stream(cls.getAnnotations())
                .map(Annotation::annotationType)
                .anyMatch(it -> it.isAnnotationPresent(COMPONENT_ANNOTATION) || it.equals(COMPONENT_ANNOTATION));
    }
}
