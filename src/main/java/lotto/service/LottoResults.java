package lotto.service;

import java.util.LinkedHashMap;
import java.util.SequencedMap;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.Map;

public class LottoResults {
    Map<Rank, Integer> lottoResultMap = new LinkedHashMap<>();

    public Map<Rank, Integer> calculateResult(LottoTickets tickets, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        refineValue(lottoResultMap);
        result(tickets, winningNumbers, bonusNumber, lottoResultMap);
        return lottoResultMap;
    }

    private void refineValue(Map<Rank, Integer> lottoResultMap) {
        for (Rank rank : Rank.values()) {
            lottoResultMap.put(rank, 0);
        }
    }

    private void result(LottoTickets tickets, WinningNumbers winningNumbers, BonusNumber bonusNumber, Map<Rank, Integer> lottoResultMap) {
        for (Lotto lotto : tickets.getLottoTickets()) {
            Rank rank = calculateRank(winningNumbers, bonusNumber, lotto);
            lottoResultMap.put(rank, lottoResultMap.get(rank) + 1);
        }
    }

    private Rank calculateRank(WinningNumbers winningNumbers, BonusNumber bonusNumber, Lotto lotto) {
        int matchCount = calculateMatchCount(winningNumbers, lotto);
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
        Rank matchRank = Rank.matchLotto(matchCount, bonusMatch);
        return matchRank;
    }

    private int calculateMatchCount(WinningNumbers winningNumbers, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getWinningNumbers()::contains)
                .count();
    }

    public long calculateTotalEarnings(Map<Rank, Integer> rankMap) {
        return rankMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculateTotalEarnings(entry.getValue()))
                .sum();
    }
}