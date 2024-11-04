package lotto.util;

@FunctionalInterface
public interface InputSupplier<T> {
    T get() throws IllegalArgumentException;
}
