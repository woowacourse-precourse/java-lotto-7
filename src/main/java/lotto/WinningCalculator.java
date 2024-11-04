package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningCalculator {

    public Map<Rank, Integer> calculateWinningCountsByRank(LottoStore lottoStore, WinningLotto winningLotto, Customer customer) {
        Map<Rank, PrizeInfo> rankInfo = lottoStore.getRankInfo();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        List<Lotto> purchasedLotto = customer.getLottos();

        Map<Rank, Integer> winningCountsByRank = new HashMap<>();

        for (Lotto userLotto : purchasedLotto) {
            List<Integer> userLottoNumbers = userLotto.getNumbers();
            Rank rank = calculateRank(rankInfo, winningLottoNumbers, bonusNumber, userLottoNumbers);
            winningCountsByRank.put(rank, winningCountsByRank.getOrDefault(rank, 0) + 1);
        }

        return winningCountsByRank;
    }

    private Rank calculateRank(Map<Rank, PrizeInfo> rankInfo, List<Integer> winningLottoNumbers, int bonusNumber, List<Integer> userLottoNumbers) {
        int matchCountResult = calculateMatchCount(winningLottoNumbers, userLottoNumbers);
        boolean matchBonusResult = isMatchBonusNumber(bonusNumber, userLottoNumbers);

        Set<Rank> ranks = rankInfo.keySet();
        for (Rank rank : ranks) {
            PrizeInfo info = rankInfo.get(rank);
            if (info.getMatchCount() == matchCountResult && info.isMatchBonus() == matchBonusResult) {
                return rank;
            }
        }
        return Rank.NONE;
    }

    private int calculateMatchCount(List<Integer> winningLottoNumbers, List<Integer> userLottoNumbers) {
        int matchCount = 0;
        for (int i = 0; i < userLottoNumbers.size(); i++) {
            if (winningLottoNumbers.contains(userLottoNumbers.get(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isMatchBonusNumber(int bonusNumber, List<Integer> userLottoNumbers) {
        return userLottoNumbers.contains(bonusNumber);
    }

    private int calculateTotalPrizeMoney(Map<Rank, PrizeInfo> rankInfo, Map<Rank, Integer> winningCountsByRank) {
        int totalPrizeMoney = 0;

        Set<Rank> ranks = winningCountsByRank.keySet();
        for (Rank rank : ranks) {
            PrizeInfo prizeInfo = rankInfo.get(rank);
            totalPrizeMoney += prizeInfo.getPrize() * winningCountsByRank.get(rank);
        }

        return totalPrizeMoney;
    }

    public double calculateProfitRate(LottoStore lottoStore, Map<Rank, Integer> winningCountsByRank, int purchasedMoney) {
        int totalPrizeMoney = calculateTotalPrizeMoney(lottoStore.getRankInfo(), winningCountsByRank);
        double result = calculatePercentage(totalPrizeMoney,purchasedMoney);
        return roundToTwoDecimalPlaces(result);
    }

    private double calculatePercentage(double part, double total) {
        if (total == 0) {
            throw new ArithmeticException("[error] Total cannot be zero.");
        }
        return (part / total) * 100;
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100) / 100.0;
    }

}
