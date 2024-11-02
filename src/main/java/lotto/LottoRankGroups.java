package lotto;

import java.util.List;
import java.util.function.Predicate;

public class LottoRankGroups {
    private final List<LottoRank> ranks;

    public LottoRankGroups(List<LottoRank> ranks) {
        this.ranks = ranks;
    }

    public Long getAllPrize() {
        return ranks.stream()
                .mapToLong(LottoRank::getPrice)
                .sum();
    }

    public Long getCount(LottoRank targetRank) {
        return filterCount(rank -> rank.equals(targetRank));
    }

    public Long getPrize(LottoRank targetRank) {
        return filterPrize(rank -> rank.equals(targetRank));
    }

    public int getRankSize() {
        return ranks.size();
    }

    private Long filterCount(Predicate<LottoRank> predicate) {
        return ranks.stream()
                .filter(predicate)
                .count();
    }

    private Long filterPrize(Predicate<LottoRank> predicate) {
        return ranks.stream()
                .filter(predicate)
                .mapToLong(LottoRank::getPrice)
                .sum();
    }
}
