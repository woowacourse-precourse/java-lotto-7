package lotto.constant;

public enum OutPutMessage {
    PURCHASE_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    NEW_LINE("\n"),
    PURCHASE_QUANTITY_MESSAGE("개를 구매했습니다."),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n" + "---"),
    MATCHING_AMOUNT_MESSAGE("개 일치"),
    MATCHING_BONUS_MESSAGE(", 보너스 볼 일치"),
    LEFT_PARENTHESIS(" ("),
    RIGHT_PARENTHESIS(") - "),
    AMOUNT("개"),
    TOTAL_PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutPutMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
