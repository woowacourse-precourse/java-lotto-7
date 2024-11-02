package lotto.common;

@FunctionalInterface
public interface InputSupplier<T> {
    T get() throws RuntimeException;
}
