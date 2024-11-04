package lotto.enums;

// 출력 메세지를 관리하는 열거 클래스
public enum OutputMessage {
    LOTTO_COUNT("\n%d개를 구매했습니다.\n"),
    WINNING_HISTORY_TITLE("\n당첨 통계\n---"),
    WINNING_HISTORY("%d개 일치 (%,d원) - %d개\n"),
    SECOND_PRIZE_WINNING_HISTORY("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    TOTAL_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    private OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
