package lotto.message;

public enum OutputMessage {
    REQUEST_INPUT_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_LOTTO_NUMBER("개를 구매했습니다."),
    REQUEST_INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    MATCH_THREE("3개 일치 (5,000원) - "),
    MATCH_FOUR("4개 일치 (50,000원) - "),
    MATCH_FIVE("5개 일치 (1,500,000원) - "),
    MATCH_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_SIX("6개 일치 (2,000,000,000원) - "),
    TOTAL_PROFIT_RATE("총 수익률은 ");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
