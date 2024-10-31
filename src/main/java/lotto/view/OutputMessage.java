package lotto.view;

public enum OutputMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_RESULT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_HEADER("당첨 통계\n---"),
    MATCH_RESULT("%d개 일치%s (%s원) - %d개"),
    MATCH_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");
	
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}