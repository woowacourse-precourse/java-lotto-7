package lotto.exception;

import static lotto.Lotto.NUMBER_COUNT;

public enum ExceptionCode {

    DUPLICATED_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    INCORRECT_NUMBER_COUNTS("로또 번호는 %d개여야 합니다.".formatted(NUMBER_COUNT)),
    NUMBER_SIZE_NOT_MATCHED("당첨 번호의 개수가 로또 번호의 개수와 다릅니다.");

    final String message;

    static final String messageHeader = "[Error] ";

    ExceptionCode(String message) {
        this.message = messageHeader + message;
    }

    public String message() {
        return this.message;
    }
}
