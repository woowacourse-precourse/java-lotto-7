package lotto.constants;

public enum ViewMessage {
    INPUT_BUY_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_BUY_COUNT("개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    PROFIT_PERCENTAGE("총 수익률은 %.1f%%입니다."),
    LOTTO_MATCH("개 일치 ("),
    FIVE_BONUS("개 일치, 보너스 볼 일치 ("),
    HOW_MANY_COUNT("개"),
    SEPARATOR1("---"),
    SEPARATOR2(") - "),
    NEWLINE("\n");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
