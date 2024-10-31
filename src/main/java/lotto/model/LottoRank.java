package lotto.model;

public enum LottoRank {
    RANK_1(2_000_000_000),
    RANK_2(30_000_000),
    RANK_3(1_500_000),
    RANK_4(50_000),
    RANK_5(5_000),
    LOSE(0);

    final int prizeMoney;

    LottoRank(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
}
