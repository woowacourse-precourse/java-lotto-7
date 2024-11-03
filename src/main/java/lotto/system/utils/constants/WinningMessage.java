package lotto.system.utils.constants;

public enum WinningMessage {

    HEADER("당첨 통계\n---\n"),
    CONTENT("%s개 일치 (%s원)- %s개\n총 수익률은 %.1f%%입니다.");

    private final String message;

    WinningMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
