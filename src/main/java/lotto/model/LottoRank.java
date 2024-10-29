package lotto.model;

public enum LottoRank {

    FIRST(6, 2_000_000_000), // 6개 번호 일치 - 1등
    SECOND(5, 30_000_000),   // 5개 번호 + 보너스 번호 일치 - 2등
    THIRD(5, 1_500_000),     // 5개 번호 일치 - 3등
    FOURTH(4, 50_000),       // 4개 번호 일치 - 4등
    FIFTH(3, 5_000),         // 3개 번호 일치 - 5등
    NONE(0, 0);              // 2개 이하 - 낙첨

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
