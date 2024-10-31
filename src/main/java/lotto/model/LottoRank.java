package lotto.model;

public enum LottoRank {
    RANK_1(2_000_000_000, 6, false),
    RANK_2(30_000_000, 5, true),
    RANK_3(1_500_000, 5, false),
    RANK_4(50_000, 4, false),
    RANK_5(5_000, 3, false),
    LOSE(0, 0, false);

    final int prizeMoney;
    final int matchCount;
    final boolean matchBonus;

    LottoRank(int prizeMoney, int matchCount, boolean matchBonus) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }
}
