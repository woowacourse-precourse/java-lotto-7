package lotto.util;

public enum PrintVariable {
    FIRST_BUY_MONEY_INPUT("구입금액을 입력해 주세요."),
    BUY_STATUS_STRING("개를 구매했습니다."),
    LOTTO_NUM_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUM_INPUT("보너스 번호를 입력해 주세요."),
    OUTPUT_START("당첨 통계"),
    ;

    private final String value;

    PrintVariable(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
