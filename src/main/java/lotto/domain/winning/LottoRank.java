package lotto.domain.winning;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum LottoRank {

    RANK_1(1, BigDecimal.valueOf(2_000_000_000), 6, false),
    RANK_2(2, BigDecimal.valueOf(30_000_000), 5, true),
    RANK_3(3, BigDecimal.valueOf(1_500_000), 5, false),
    RANK_4(4, BigDecimal.valueOf(50_000), 4, false),
    RANK_5(5, BigDecimal.valueOf(5_000), 3, false),
    RANK_NONE(Integer.MAX_VALUE, BigDecimal.ZERO, 0, false);

    private final int rank;
    private final BigDecimal price;
    private final int matchCount;
    private final boolean matchBonus;

    LottoRank(final int rank, final BigDecimal price, final int matchCount, final boolean matchBonus) {
        this.rank = rank;
        this.price = price;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static LottoRank findByMatchCountAndMatchBonus(final int matchCount, final boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isMatchBonus(lottoRank, matchBonus))
                .filter(lottoRank -> isMatchCount(lottoRank, matchCount))
                .findAny()
                .orElse(RANK_NONE);
    }

    public static List<LottoRank> findAllLottoRankWithOutRankNone() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isNotRankNone)
                .sorted((l1, l2) -> l2.rank - l1.rank)
                .toList();
    }

    public int getRank() {
        return rank;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    private static boolean isNotRankNone(final LottoRank lottoRank) {
        return !Objects.equals(lottoRank, RANK_NONE);
    }

    private static boolean isMatchBonus(final LottoRank lottoRank, final boolean matchBonus) {
        return Objects.equals(lottoRank.matchBonus, matchBonus);
    }

    private static boolean isMatchCount(final LottoRank lottoRank, final int matchCount) {
        return lottoRank.matchCount == matchCount;
    }
}
