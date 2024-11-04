package lotto.format;

@FunctionalInterface
public interface MessageFormatter<T> {

    String format(T data);
}
