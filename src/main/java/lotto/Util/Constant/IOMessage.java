package lotto.Util.Constant;

public enum IOMessage {
    INPUT_PAYMENT_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_LOTTO_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    OUTPUT_PRIZE_STATISTICS("\n당첨 통계\n---"),
    OUTPUT_PRIZE_STATISTICS_MATCHED_3("3개 일치 (5,000원) - %d개"),
    OUTPUT_PRIZE_STATISTICS_MATCHED_4("4개 일치 (50,000원) - %d개"),
    OUTPUT_PRIZE_STATISTICS_MATCHED_5("5개 일치 (1,500,000원) - %d개"),
    OUTPUT_PRIZE_STATISTICS_MATCHED_5_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    OUTPUT_PRIZE_STATISTICS_MATCHED_6("6개 일치 (2,000,000,000원) - %d개"),

    OUTPUT_TOTAL_PROFIT("총 수익률은 %.1f%%입니다.");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}