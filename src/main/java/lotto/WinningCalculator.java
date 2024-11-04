package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningCalculator {

    public Map<LottoRank, Integer> calculateWinningCountsByRank(LottoStore lottoStore, WinningLotto winningLotto, Customer customer) {
        Map<LottoRank, PrizeInfo> rankInfo = lottoStore.getRankInfo();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        List<Lotto> purchasedLotto = customer.getLottos();

        Map<LottoRank, Integer> winningCountsByRank = new HashMap<>();

        for (Lotto userLotto : purchasedLotto) {
            List<Integer> userLottoNumbers = userLotto.getNumbers();
            LottoRank lottoRank = calculateRank(rankInfo, winningLottoNumbers, bonusNumber, userLottoNumbers);
            winningCountsByRank.put(lottoRank, winningCountsByRank.getOrDefault(lottoRank, 0) + 1);
        }

        return winningCountsByRank;
    }

    private LottoRank calculateRank(Map<LottoRank, PrizeInfo> rankInfo, List<Integer> winningLottoNumbers, int bonusNumber, List<Integer> userLottoNumbers) {
        int matchCountResult = calculateMatchCount(winningLottoNumbers, userLottoNumbers);
        boolean matchBonusResult = isMatchBonusNumber(bonusNumber, userLottoNumbers);

        Set<LottoRank> lottoRanks = rankInfo.keySet();
        for (LottoRank lottoRank : lottoRanks) {
            PrizeInfo info = rankInfo.get(lottoRank);
            if (info.getMatchCount() == matchCountResult && info.isMatchBonus() == matchBonusResult) {
                return lottoRank;
            }
        }
        return LottoRank.NONE;
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

    private int calculateTotalPrizeMoney(Map<LottoRank, PrizeInfo> rankInfo, Map<LottoRank, Integer> winningCountsByRank) {
        int totalPrizeMoney = 0;

        Set<LottoRank> lottoRanks = winningCountsByRank.keySet();
        for (LottoRank lottoRank : lottoRanks) {
            PrizeInfo prizeInfo = rankInfo.get(lottoRank);
            totalPrizeMoney += prizeInfo.getPrize() * winningCountsByRank.get(lottoRank);
        }

        return totalPrizeMoney;
    }

    public double calculateProfitRate(LottoStore lottoStore, Map<LottoRank, Integer> winningCountsByRank, int purchasedMoney) {
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
