package lotto.util;

@FunctionalInterface
public interface ValidateFunction<T> {
    void validate(final T value);
}
