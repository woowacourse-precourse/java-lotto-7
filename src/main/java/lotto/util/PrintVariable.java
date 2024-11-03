package lotto.util;

public enum PrintVariable {
    FIRST_BUY_MONEY_INPUT("구입금액을 입력해 주세요."),
    LOTTO_NUM_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUM_INPUT("보너스 번호를 입력해 주세요."),
    OUTPUT_START("당첨 통계"),

    BUY_STATUS_FORMAT("\n%d개를 구매했습니다.\n"),
    RESULT_START_FORMAT("\n%s\n---\n"),
    EARNING_RESULT_FORMAT("총 수익률은 %.1f%%입니다.\n"),
    LOTTO_RESULT_FORMAT("%d개 일치 (%s) - %d개\n"),
    LOTTO_RESULT_WITH_BONUS_FORMAT("%d개 일치, 보너스 볼 일치 (%s) - %d개\n")
    ;

    private final String value;

    PrintVariable(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
