package lotto.enums;

import java.text.MessageFormat;

public enum ViewMessages {
    // Input
    PROMPT_MONEY("구입 금액을 입력해 주세요. (최소 단위: {0}원)"),
    PROMPT_WINNING_NUMBERS("{0}개의 당첨 번호를 입력해주세요. 번호는 쉼표(,)를 기준으로 구분됩니다."),

    // Output
    PRINT_BLANK("\n"),
    PRINT_LOTTO_AMOUNT("{0}개를 구매했습니다."),
    ;
    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format(this.message, params);
    }
}