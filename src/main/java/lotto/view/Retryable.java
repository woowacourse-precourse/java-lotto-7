package lotto.view;

@FunctionalInterface
public interface Retryable<T> {
    T execute() throws Exception;
}
