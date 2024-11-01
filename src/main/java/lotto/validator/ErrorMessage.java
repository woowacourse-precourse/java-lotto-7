package lotto.validator;

import static lotto.constants.LottoConstants.ERROR_MESSAGE_BEGINNING;

public enum ErrorMessage {
    MUST_BE_TARGET_LENGTH("%s %s 번호는 %d개이어야 합니다."),
    MUST_BE_NUMBER("%s %s은(는) 숫자 형식이어야 합니다."),
    MUST_BE_UNIQUE("%s 로또 번호가 중복되었습니다."),
    MUST_BE_NO_SPACE("%s %s에 공백을 허용하지 않습니다."),
    MUST_BE_BETWEEN("%s 로또 번호는 1 ~ 45 사이 숫자이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(message, ERROR_MESSAGE_BEGINNING);
    }

    public String getMessage(String input) {
        return String.format(message, ERROR_MESSAGE_BEGINNING, input);
    }

    public String getMessage(String type, int length) {
        return String.format(message, ERROR_MESSAGE_BEGINNING, type, length);
    }
}
