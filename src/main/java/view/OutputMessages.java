package view;

public enum OutputMessages {

    INPUT_INITIAL_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS__NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    OUTPUT_LOTTO_STATISTICS_MESSAGE("당첨 통계\n---"),
    OUTPUT_EARN_RATE_MESSAGE("총 수익률은 %.1f%%입니다."),
    OUTPUT_RANK_STATISTICS_MESSAGE("%s - %d개");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
