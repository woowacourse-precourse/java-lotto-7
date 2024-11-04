package lotto.message;

public enum WinningNumMessage {
    MATCHES_3_WINNING("3개 일치 (5,000원) - %d개\n"),
    MATCHES_4_WINNING("4개 일치 (50,000원) - %d개\n"),
    MATCHES_5_WINNING("5개 일치 (1,500,000원) - %d개\n"),
    MATCHES_BONUS_WINNING("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    MATCHES_6_WINNING("6개 일치 (2,000,000,000원) - %d개\n");

    private String message;

    private WinningNumMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
