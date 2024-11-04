package lotto.service;

import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.model.LottoStatistic;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameStatisticService {
    public LottoStatistic calculateLottoResult(LottoTicket ticket, WinningNumbers winningNumbers) {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        List<Lotto> purchasedLotteries = ticket.getLotteries();
        calculateRankCounts(winningNumbers, rankCount, purchasedLotteries);
        double returnRate = calculateRateOfReturn(rankCount, ticket.getPurchase());
        return new LottoStatistic(rankCount, returnRate);
    }

    private void calculateRankCounts(WinningNumbers winningNumbers, Map<Rank, Integer> rankCount, List<Lotto> purchasedLotteries) {
        for (Lotto lottery : purchasedLotteries) {
            updateRanks(winningNumbers, rankCount, lottery);
        }
    }

    private void updateRanks(WinningNumbers winningNumbers, Map<Rank, Integer> rankCount, Lotto lottery) {
        Rank rank = calculateRank(lottery, winningNumbers);
        rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
    }

    private Rank calculateRank(Lotto lottery, WinningNumbers winningNumbers) {
        List<Integer> lottoNumbers = lottery.getNumbers();
        List<Integer> winningNumbersList = winningNumbers.getWinningNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();

        int matchCount = countMatches(lottoNumbers, winningNumbersList);
        boolean hasBonusMatch = lottoNumbers.contains(bonusNumber);

        return Rank.determineRank(matchCount, hasBonusMatch);
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumberList) {
        return (int) lottoNumbers.stream()
                .filter(winningNumberList::contains)
                .count();
    }

    private double calculateRateOfReturn(Map<Rank, Integer> rankCount, int purchaseAmount) {
        long totalPrize = rankCount.entrySet().stream()
                .mapToLong(entry -> entry.getValue() * entry.getKey().getPrize())
                .sum();
        return (totalPrize * 100.0) / purchaseAmount;
    }


}
