package lotto.system.utils.constants;

public enum WinningMessage {

    HEADER("당첨 통계\n---\n"),
    CONTENT("%s - %d개");

    private final String message;

    WinningMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}