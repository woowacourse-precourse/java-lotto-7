package lotto.system.utils.constants;

public interface MessageConstants {

    String getMessage();

    default String getMessage(Object... args) {
        return String.format(getMessage(), args);
    }

}
