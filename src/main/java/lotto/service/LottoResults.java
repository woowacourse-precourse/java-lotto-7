package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

import java.util.EnumMap;
import java.util.Map;

public class LottoResults {
    Map<Rank, Integer> lottoResultMap = new EnumMap<>(Rank.class);

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