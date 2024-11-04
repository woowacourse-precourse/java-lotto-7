package lotto.domain;

public enum Rank {

    MISS(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"), // 5등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"), // 4등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"), // 3등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"), // 2등
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"), // 1등
    ;

    private final int winningCount;
    private final int winningPrize;
    private final String message;

    Rank(int winningCount, int winningPrize, String message) {
        this.winningCount = winningCount;
        this.winningPrize = winningPrize;
        this.message = message;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public String getMessage() {
        return message;
    }
}
