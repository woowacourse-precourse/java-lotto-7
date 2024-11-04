package lotto.handler;

public interface Operation<T> {
    T execute() throws IllegalArgumentException;
}
