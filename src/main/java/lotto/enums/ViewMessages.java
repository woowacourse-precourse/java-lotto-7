package lotto.enums;

import java.text.MessageFormat;

public enum ViewMessages {
    // Input
    PROMPT_MONEY("구입 금액을 입력해 주세요. (최소 단위: {0}원)"),
    PROMPT_WINNING_NUMBERS("{0}부터 {1}까지 번호들 중에서 중복되지 않는 {2}개의 당첨 번호를 입력해주세요. 번호는 쉼표(,)를 기준으로 구분됩니다."),
    PROMPT_BONUS_NUMBER("{0}부터 {1}까지 번호들 중에서 당첨 번호와 중복되지 않는 보너스 번호 1개를 입력해주세요."),

    // Output
    PRINT_BLANK("\n"),
    PRINT_LOTTO_AMOUNT("{0}개를 구매했습니다."),
    PRINT_RESULT_COMMENT("당첨 통계\n---"),
    PRINT_LOTTO_NORMAL_RESULT("{0}개 일치 ({1}원) - {2}개"),
    PRINT_LOTTO_BONUS_RESULT("{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개"),
    ;
    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format(this.message, params);
    }
}