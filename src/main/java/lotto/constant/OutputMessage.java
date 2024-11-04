package lotto.constant;

public enum OutputMessage {

    LOTTO_PURCHASED_OUTPUT_MESSAGE("개를 구매했습니다."),
    LOTTO_RESULT_OUTPUT_MESSAGE("\n" + "당첨 통계" + "\n" + "---"),
    FIFTH_PLACE_OUTPUT_MESSAGE("3개 일치 (5,000원) - %d개 \n"),
    FOURTH_PLACE_OUTPUT_MESSAGE("4개 일치 (50,000원) - %d개 \n"),
    THIRD_PLACE_OUTPUT_MESSAGE("5개 일치 (1,500,000원) - %d개 \n"),
    SECOND_PLACE_OUTPUT_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개 \n"),
    FIRST_PLACE_OUTPUT_MESSAGE("6개 일치 (2,000,000,000원) - %d개 \n"),
    PROFIT_RATE_OUTPUT_MESSAGE("총 수익률은 %.1f%%입니다.")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
