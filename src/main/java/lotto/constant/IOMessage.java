package lotto.constant;

public enum IOMessage {
    BLANK_LINE(""),

    INPUT_ORDER_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_HEAD("당첨 통계\n---"),
    OUTPUT_COUNT("%d개를 구매했습니다."),
    OUTPUT_RATE_OF_RETURN("총 수익률은 %.1f%%입니다."),
    OUTPUT_RESULT("%d개 일치%s (%,d원) - %d개"),
    OUTPUT_BONUS_RESULT(", 보너스 볼 일치");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
