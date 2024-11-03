package lotto.common;

public enum ErrorMessage {
    NULL_OR_EMPTY("구입 금액을 입력해 주세요."),
    NOT_POSITIVE("양의 정수를 입력해 주세요."),
    INVALID_NUMBER("올바른 금액을 입력해 주세요."),
    NOT_DISABLE_BY_1000("1000원 단위로 입력해 주세요."),
    INVALID_NUMBER_COUNT("로또 번호는 %d개의 숫자로 구성되어야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 %d부터 %d 사이여야 합니다."),
    UTILITY_CLASS_INSTANTIATION("유틸리티 클래스는 인스턴스화할 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return ERROR_PREFIX + String.format(message, args);
    }
}
