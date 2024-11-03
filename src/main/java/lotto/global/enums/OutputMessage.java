package lotto.global.enums;

public enum OutputMessage {
    LOTTO_PURCHASE("%d개를 구매했습니다."),
    LOTTO_WINNING_STAT("당첨 통계\n---"),
    SECOND_PLACE_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OTHER_PLACE_RESULT("%d개 일치 (%s원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
