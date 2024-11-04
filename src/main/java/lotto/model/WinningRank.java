package lotto.model;

public enum WinningRank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);


    private final int matchCount;
    private final boolean bonusCheck;
    private final int prize;

    WinningRank(int matchCount, boolean bonusCheck, int prize) {
        this.matchCount = matchCount;
        this.bonusCheck = bonusCheck;
        this.prize = prize;
    }

    // 해당 복권에 맞는 당첨 결과 매칭 메소드
    public static WinningRank matchRank(int matchCount, boolean bonusCheck) {
        for (WinningRank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusCheck == bonusCheck) {
                return rank;
            }
        }
        return null;
    }

    // 상금 반환 getter
    public int getPrize() {
        return prize;
    }

    // 일치하는 숫자 개수 반환 getter
    public int getMatchCount() {
        return matchCount;
    }
}
