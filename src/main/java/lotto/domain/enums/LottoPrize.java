package lotto.domain.enums;

public enum LottoPrize {
    FIFTH_PRIZE(LottoRank.FIFTH, 5_000),
    FOURTH_PRIZE(LottoRank.FOURTH, 50_000),
    THIRD_PRIZE(LottoRank.THIRD, 1_500_000),
    SECOND_PRIZE(LottoRank.SECOND, 30_000_000),
    FIRST_PRIZE(LottoRank.FIRST, 2_000_000_000),
    NONE_PRIZE(LottoRank.NONE, 0);

    private final LottoRank rank;
    private final int prize;

    LottoPrize(LottoRank rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrize fromRank(LottoRank rank) {
        for (LottoPrize result : values()) {
            if (result.rank == rank) {
                return result;
            }
        }
        return NONE_PRIZE;
    }
}
