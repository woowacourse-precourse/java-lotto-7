package lotto.message;

public enum OutputMessage implements Message {

    OUTPUT_LOTTO_PURCHASE_MONEY_COUNT("%d개를 구매했습니다."),
    OUTPUT_LOTTO_MATCH_MESSAGE("당첨 통계"),
    OUTPUT_LOTTO_MATCH_DELIMITER("---"),
    OUTPUT_LOTTO_MATCH_COUNT("%d개"),
    OUTPUT_LOTTO_RANK_MATCH_COUNT("%d개 일치"),
    OUTPUT_LOTTO_RANK_IS_BONUS_NUMBER("보너스 볼 일치"),
    OUTPUT_LOTTO_RANK_PRIZE_MONEY("(%,d원)"),
    OUTPUT_LOTTO_TOTAL_PROFIT("총 수익률은 %.1f%%입니다."),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
