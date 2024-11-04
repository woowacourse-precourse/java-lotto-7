package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRankSummary {
    public static List<LottoWinningRanks> summarizeLottoRanks(List<Integer> lottoResults, List<Boolean> bonusResults) {
        List<LottoWinningRanks> lottoWinningRanks = new ArrayList<>();
        for (int i = 0; i < lottoResults.size(); i++) {
            lottoWinningRanks.add(getRank(lottoResults.get(i), bonusResults.get(i)));
        }
        return lottoWinningRanks;
    }

    public static Map<LottoWinningRanks, Integer> summarizeRanksToCounts(List<LottoWinningRanks> lottoWinningRanks) {
        Map<LottoWinningRanks, Integer> lottoRankMap = new HashMap<>();
        for (LottoWinningRanks rank : lottoWinningRanks) {
            lottoRankMap.put(rank, lottoRankMap.getOrDefault(rank, OutputMessage.NO_COUNT) + 1);
        }
        return lottoRankMap;
    }

    public static double calculateRateOfReturn(List<LottoWinningRanks> prizeResults, LottoBuyer lottoBuyer) {
        double finalAmount = calculateTotalPrize(prizeResults);
        double investment = lottoBuyer.getPurchaseAmount();
        return calculateReturnRate(finalAmount, investment);
    }

    private static LottoWinningRanks getRank(int sameCount, boolean isBonusMatched) {
        return LottoWinningRanks.getRank(sameCount, isBonusMatched);
    }

    private static double calculateTotalPrize(List<LottoWinningRanks> prizeResults) {
        return prizeResults.stream()
                .mapToDouble(LottoWinningRanks::getMoney)
                .sum();
    }

    private static double calculateReturnRate(double finalAmount, double investment) {
        return (finalAmount / investment) * 100;
    }
}
