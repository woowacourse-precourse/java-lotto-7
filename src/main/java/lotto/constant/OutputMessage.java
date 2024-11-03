package lotto.constant;

public enum OutputMessage {

    PURCHASE_GUIDE("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT("%d개를 구매했습니다."),
    NEW_LINE("\n"),
    COMMA(", "),
    WINNING_NUMBER_GUIDE("당첨 번호를 입력해 주세요."),
    BONUS_GUID("보너스 번호를 입력해 주세요."),
    MATCH_COUNT("%d개 일치"),
    PRIZE(" (%,d원)"),
    MATCH_BONUS(", 보너스 볼 일치"),
    RANKING_COUNT(" - %d개"),
    RESULT_GUIDE("당첨 통계"),
    LINE("---"),
    RETURN_OF_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
