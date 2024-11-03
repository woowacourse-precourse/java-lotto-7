package lotto.model;

import lotto.util.LottoResultChecker;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoManager {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoManager(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Long> calculateResults() {
        return lottos.getLottos().stream()
                .map(this::getRank)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private Rank getRank(Lotto lotto) {
        int matchCount = LottoResultChecker.countMatchingNumbers(lotto.getNumbers(), winningNumbers.winningNumbers());
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber.getBonusNumber());

        return Rank.determineRank(matchCount, hasBonus);
    }
}
