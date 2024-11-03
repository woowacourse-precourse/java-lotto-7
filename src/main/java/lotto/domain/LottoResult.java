package lotto.domain;

import java.util.List;
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
}
