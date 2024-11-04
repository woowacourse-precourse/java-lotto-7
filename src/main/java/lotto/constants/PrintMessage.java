package lotto.constants;

public enum PrintMessage {

    PURCHASE_MESSAGE("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),

    LOTTO_PURCHASE_MESSAGE("개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
    PROFIT_RATE_MESSAGE("총 수익률은")
    ;

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println(message);
    }
}
