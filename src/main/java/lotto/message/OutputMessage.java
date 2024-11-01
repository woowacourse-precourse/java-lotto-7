package lotto.message;

public enum OutputMessage implements Message {

    OUTPUT_PURCHASE_COUNT("%d개를 구매했습니다."),
    OUTPUT_LOTTO_STATISTIC("당첨 통계"),
    OUTPUT_LOTTO_MATCH_COUNT("%d개 일치"),
    OUTPUT_LOTTO_MATCH_BONUS_NUMBER("보너스 볼 일치"),
    OUTPUT_LOTTO_PRIZE_MONEY("(%,d원)"),
    OUTPUT_LOTTO_RANK_COUNT("%d개"),
    OUTPUT_TOTAL_PROFIT("총 수익률은 %.2f%입니다."),
    ;

    public static final String BASIC_DELIMITER = ", ";
    public static final String NEW_LINE = "\n";

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
