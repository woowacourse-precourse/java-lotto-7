package view;

public enum Message {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_COUNT("개를 구매했습니다."),
    OPEN_BRACKET("["),
    CLOSE_BRACKET("]"),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    SEPARATOR("---"),
    MATCH_3("3개 일치 (5,000원) - "),
    MATCH_4("4개 일치 (50,000원) - "),
    MATCH_5("5개 일치 (1,500,000원) - "),
    MATCH_5_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_6("6개 일치 (2,000,000,000원) - "),
    UNIT("개"),
    TOTAL_YIELD("총 수익률은 "),
    ENDING("%입니다."),
    COMMA(", "),
    BONUS("보너스 번호를 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
