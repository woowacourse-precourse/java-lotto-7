package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Lottos lottos;
    private final WinNumber winNumber;

    private LottoResult(Lottos lottos, WinNumber winNumber) {
        this.lottos = lottos;
        this.winNumber = winNumber;
    }

    public static LottoResult of(Lottos lottos, WinNumber winNumber) {
        return new LottoResult(lottos, winNumber);
    }

    public Map<Rank, Integer> calculateRankDistribution() {
        List<Rank> ranks = collectMatchResults();
        return countRank(ranks);
    }

    private List<Rank> collectMatchResults() {
        return lottos.getLottos().stream()
                .map(this::determineRank)
                .collect(Collectors.toList());
    }

    private Rank determineRank(Lotto lotto) {
        int matchCount = winNumber.matchWithLotto(lotto);
        boolean bonusMatch = (matchCount == 5) && winNumber.matchWithBonusNumber(lotto);
        return Rank.getRank(matchCount, bonusMatch);
    }

    private Map<Rank, Integer> countRank(List<Rank> ranks) {
        Map<Rank, Integer> rankResult = initializeRankCount();
        ranks.forEach(rank -> rankResult.put(rank, rankResult.get(rank) + 1));
        return rankResult;
    }

    private Map<Rank, Integer> initializeRankCount() {
        Map<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> rankResult.put(rank, 0));
        return rankResult;
    }
}
