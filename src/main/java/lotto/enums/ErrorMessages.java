package lotto.enums;

import java.text.MessageFormat;

public enum ErrorMessages {

    INPUT_NOTHING("입력 문자열은 null이거나 비어있어서는 안 됩니다."),
    MONEY_UNIT("구입 금액의 최소 단위는 {0}원입니다."),
    NUMBER_FORMAT("입력은 숫자만 가능합니다.")

    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format("[ERROR] " + this.message, params);
    }
}