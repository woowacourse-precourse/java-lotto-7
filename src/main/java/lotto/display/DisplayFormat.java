package lotto.display;

public enum DisplayFormat {
    PURCHASE_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_INPUT_RESULT("%d개를 구매했습니다.\n"),
    GAP("\n"),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요\n"),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요\n"),
    STATISTICS_START("당첨 통계\n---\n"),
    WINNING_RANK_FIFTH("3개 일치 (5,000원) - %d개\n"),
    WINNING_RANK_FOURTH("4개 일치 (50,000원) - %d개\n"),
    WINNING_RANK_THIRD("5개 일치 (1,500,000원) - %d개\n"),
    WINNING_RANK_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    WINNING_RANK_FIRST("6개 일치 (2,000,000,000원) - %d개\n"),
    STATISTICS("총 수익률은 %s%%입니다."),
    ERROR("[ERROR] %s");

    private final String displayFormat;

    DisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    public String displayDefault() {
        return displayFormat;
    }

    public String displayWithOneValue(int value) {
        return String.format(displayFormat, value);
    }

    public String displayWithOneValue(String value) {
        return String.format(displayFormat, value);
    }
}
