package lotto.message;

public enum PrintMessage {

    INPUT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE_NUMBER("%d개를 구매했습니다.\n"),
    INPUT_LOTTO_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_WINNING_RESULT_MESSAGE("당첨 통계\n---"),
    LOTTO_FIFTH_PLACE_WINNING("3개 일치 (5,000원) - %d개"),
    LOTTO_FOURTH_PLACE_WINNING("4개 일치 (50,000원) - %d개"),
    LOTTO_THIRD_PLACE_WINNING("5개 일치 (1,500,000원) - %d개"),
    LOTTO_SECOND_PLACE_WINNING("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    LOTTO_FIRST_PLACE_WINNING("6개 일치 (2,000,000,000원) - %d개"),
    LOTTO_PROFIT_RATE("총 수익률은 %.1f%%입니다.\n"),
    LINE_SPACE("");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
