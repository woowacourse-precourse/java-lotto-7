package lotto.exception;

import static lotto.domain.Lotto.NUMBER_COUNT;

public enum ExceptionCode {

    REMAINDER_EXISTED("구매 금액이 로또 금액으로 나누어 떨어지지 않습니다."),
    BUDGET_TOO_SMALL("구매 금액이 로또 금액보다 작습니다."),
    IS_NOT_NUMBER("입력이 수가 아닙니다."),
    DUPLICATED_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    INCORRECT_NUMBER_COUNTS("로또 번호는 %d개여야 합니다.".formatted(NUMBER_COUNT)),
    NUMBER_OUT_OF_RANGE("입력된 수가 가능한 범위를 초과하였습니다.");

    final String message;

    static final String messageHeader = "[ERROR] ";

    ExceptionCode(String message) {
        this.message = messageHeader + message;
    }

    public String message() {
        return this.message;
    }
}
