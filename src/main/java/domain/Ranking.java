package domain;

public enum Ranking {
    ZERO(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private int matchingCount;
    private int winningMoney;
    private String message;

    Ranking(int matchingCount, int winningMoney, String message) {
        this.matchingCount = matchingCount;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Ranking valueOf(int matchingCount, boolean bonus) {
        // 꽝
        if (matchingCount < 3) {
            return ZERO;
        }
        //2등 조건
        if (SECOND.matchingCount == matchingCount && bonus) {
            return SECOND;
        }
        for (Ranking rank : values()) {
            if (rank.matchingCount == matchingCount && rank != SECOND) {
                return rank;
            }
        }
        return null;
    }


    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        return message;
    }
}
