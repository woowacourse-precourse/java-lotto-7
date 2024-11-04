package lotto.util;

public enum ConstantVariables {
    LOTTO_MONEY_INPUT("구입금액을 입력해 주세요."),
    LOTTO_ANSWER_NUM_INPUT("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS_NUM_INPUT("보너스 번호를 입력해 주세요."),

    RESULT_START_FORMAT("\n%s\n---\n"),
    OUTPUT_START("당첨 통계\n"),
    LOTTO_BUY_COUNT("\n%d개를 구매했습니다.\n"),
    LOTTO_RESULT("%d개 일치 (%s) - %d개\n"),
    LOTTO_RESULT_BONUS("%d개 일치, 보너스 볼 일치 (%s) - %d개\n"),
    LOTTO_PROFIT("총 수익률은 %.1f%%입니다.\n"),

    ;

    private final String value;

    ConstantVariables(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}