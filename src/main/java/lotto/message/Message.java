package lotto.message;

public interface Message {

    String message();

    default String format(Object... args) {
        return String.format(message(), args);
    }
}
