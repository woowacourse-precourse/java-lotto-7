package lotto.enums;

public enum LottoMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_SUFFIX("%s개를 구매했습니다."),
    TOTAL_PROFIT_RATE("총 수익률은 %s%%입니다."),
    ERROR_PREFIX("[ERROR] "),
    WINNING_STATISTICS_HEADLINE("당첨 통계\n---"),
    LOTTO_RANK_STATISTICS_FORMAT("%s - %d개%n"),
    PROFIT_RATE_FORMAT("#,##0.0");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
