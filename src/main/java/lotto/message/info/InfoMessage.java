package lotto.message.info;

public enum InfoMessage {
    REQUEST_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WRITE_WINNING_STATISTICS("당첨 통계\n" + "---"),
    RESPONSE_CNT_LOTTO("개를 구매했습니다."),
    FIRST("6개 일치 (2,000,000,000원)"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD("5개 일치 (1,500,000원)"),
    FOURTH("4개 일치 (50,000원)"),
    FIFTH("3개 일치 (5,000원)"),
    RESPONSE_TOTAL_YIELD("총 수익률은 %.1f%%입니다.%n");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
