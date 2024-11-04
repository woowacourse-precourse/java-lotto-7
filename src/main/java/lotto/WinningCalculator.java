package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCalculator {

    public Map<LottoRank, Integer> calculateWinningCountsByRank(WinningLotto winningLotto, Customer customer) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        List<Lotto> purchasedLotto = customer.getLottos();

        Map<LottoRank, Integer> winningCountsByRank = new HashMap<>();

        for (Lotto userLotto : purchasedLotto) {
            List<Integer> userLottoNumbers = userLotto.getNumbers();
            LottoRank lottoRank = calculateRank(winningLottoNumbers, bonusNumber, userLottoNumbers);
            winningCountsByRank.put(lottoRank, winningCountsByRank.getOrDefault(lottoRank, 0) + 1);
        }

        return winningCountsByRank;
    }

    private LottoRank calculateRank(List<Integer> winningLottoNumbers, int bonusNumber, List<Integer> userLottoNumbers) {
        int matchCountResult = calculateMatchCount(winningLottoNumbers, userLottoNumbers);
        boolean matchBonusResult = isMatchBonusNumber(bonusNumber, userLottoNumbers);

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.getMatchCount() == matchCountResult && lottoRank.isMatchBonus() == matchBonusResult) {
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

    private int calculateTotalPrizeMoney(Map<LottoRank, Integer> winningCountsByRank) {
        int totalPrizeMoney = 0;
        for (LottoRank lottoRank : winningCountsByRank.keySet()) {
            totalPrizeMoney += lottoRank.getPrize() * winningCountsByRank.get(lottoRank);
        }
        return totalPrizeMoney;
    }

    public double calculateProfitRate(Map<LottoRank, Integer> winningCountsByRank, int purchasedMoney) {
        int totalPrizeMoney = calculateTotalPrizeMoney(winningCountsByRank);
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
