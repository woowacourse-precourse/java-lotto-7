package lotto.domain;

public enum LottoRank {
    SIXTH("", 0, 0),
    FIFTH("3개 일치 (5,000원) - %d개\n", 3, 5_000),
    FOURTH("4개 일치 (50,000원) - %d개\n", 4, 50_000),
    THIRD("5개 일치 (1,500,000원) - %d개\n", 5, 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 5, 30_000_000),
    FIRST("6개 일치 (2,000,000,000원) - %d개\n", 6, 2_000_000_000);

    private final String message;
    private final int count;
    private final int winnings;

    LottoRank(String message, int count, int winnings) {
        this.message = message;
        this.count = count;
        this.winnings = winnings;
    }

    public static LottoRank get(int matchCount, boolean isBonus) {
        for (final LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.THIRD && isBonus) {
                continue;
            }
            if (rank.count == matchCount) {
                return rank;
            }
        }
        return LottoRank.SIXTH;
    }

    public String getMessage() {
        return message;
    }

    public int getWinnings() {
        return winnings;
    }
}
