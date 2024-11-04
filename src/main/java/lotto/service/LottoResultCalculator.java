package lotto.service;

import lotto.model.*;
import java.util.*;

public class LottoResultCalculator {
    private final Map<Rank, Integer> rankCounts;

    public LottoResultCalculator() {
        this.rankCounts = new EnumMap<>(Rank.class);
        initializeRankCounts();
    }

    private void initializeRankCounts() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankCounts.put(rank, 0));
    }

    public Map<Rank, Integer> calculateResults(List<Lotto> lottos,
                                               WinningNumbers winningNumbers,
                                               BonusNumber bonusNumber) {
        validateInputs(lottos, winningNumbers, bonusNumber);

        lottos.stream()
                .map(lotto -> calculateSingleLottoRank(lotto, winningNumbers, bonusNumber))
                .forEach(this::updateRankCount);

        return new EnumMap<>(rankCounts);
    }

    private Rank calculateSingleLottoRank(Lotto lotto,
                                          WinningNumbers winningNumbers,
                                          BonusNumber bonusNumber) {
        int matchCount = calculateMatchCount(lotto, winningNumbers);
        boolean matchBonus = checkBonusMatch(lotto, bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }

    private int calculateMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private boolean checkBonusMatch(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private void updateRankCount(Rank rank) {
        rankCounts.merge(rank, 1, Integer::sum);
    }

    private void validateInputs(List<Lotto> lottos,
                                WinningNumbers winningNumbers,
                                BonusNumber bonusNumber) {
        if (lottos == null || winningNumbers == null || bonusNumber == null) {
            throw new IllegalStateException("당첨 결과 계산에 필요한 데이터가 없습니다.");
        }
    }
}
