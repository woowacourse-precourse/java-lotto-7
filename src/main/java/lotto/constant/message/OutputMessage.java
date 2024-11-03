package lotto.constant.message;

public enum OutputMessage {

    LOTTO_PURCHASE_AMOUNT_INPUT_MESSAGE("구입 금액을 입력해 주세요."),
    WINNING_TICKET_INPUT_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("\n보너스 번호를 입력해 주세요."),
    PURCHASE_NUMBER_OUTPUT_MESSAGE("\n%d개를 구매했습니다."),
    WINNING_STATISTICS_OUTPUT_START_MESSAGE("\n당첨 통계\n---"),
    FIRST_PLACE_OUTPUT_MESSAGE("%d개 일치 (%,d원) - %d개"),
    SECOND_PLACE_OUTPUT_MESSAGE("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    THIRD_PLACE_OUTPUT_MESSAGE("%d개 일치 (%,d원) - %d개"),
    FOURTH_PLACE_OUTPUT_MESSAGE("%d개 일치 (%,d원) - %d개"),
    FIFTH_PLACE_OUTPUT_MESSAGE("%d개 일치 (%,d원) - %d개"),
    EARNING_RATE_OUTPUT_MESSAGE("총 수익률은 %.1f%%입니다.")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(Integer content) {
        return String.format(message, content);
    }

    public String getMessage(Double content) {
        return String.format(message, content);
    }

    public String getMessage(Integer content1, Integer content2, Integer content3) {
        return String.format(message, content1, content2, content3);
    }
}
