package lotto.enums;

import java.text.MessageFormat;

public enum ViewMessages {
    // Input
    PROMPT_MONEY("구입금액을 입력해 주세요. (단위: 1,000원)"),

    // Output
    ;
    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format(this.message, params);
    }
}