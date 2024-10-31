package lotto.messages;

public enum WinningMessage {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, 50000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, 5000, "3개 일치 (5,000원) - %d개");

    private final int matchCount;
    private final int winningAmount;
    private final String message;

    WinningMessage(int matchCount, int winningAmount, String message) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public long getWinningAmount(int count) {
        return (long) winningAmount * count;
    }

    public int getMatchCount() {
        return matchCount;
    }
    public int getWinningAmount() {
        return winningAmount;
    }
    public String getMessage() {
        return message;
    }
}
