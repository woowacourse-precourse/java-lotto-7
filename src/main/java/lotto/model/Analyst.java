package lotto.model;

import static lotto.constant.LottoValue.LOTTO_PRICE;
import static lotto.constant.LottoValue.LOTTO_RANK_GRADE;

import java.util.List;

public class Analyst {
    public int[] calculateWinLottoCount(List<LottoResult> LottoResults) {
        int[] winLottoCount = new int[LOTTO_RANK_GRADE.getValue()];
        for (LottoResult lottoResult : LottoResults) {
            int winLottoIndex = Integer.parseInt(lottoResult.getLottoRank());
            winLottoCount[winLottoIndex]++;
        }
        return winLottoCount;
    }

    public double calculateYield(List<LottoResult> LottoResults) {
        int totalEarn = calculateTotalEarn(LottoResults);
        return ((double) totalEarn / (LottoResults.size() * LOTTO_PRICE.getValue()) * 100);
    }

    private int calculateTotalEarn(List<LottoResult> results) {
        return results.stream()
                .mapToInt(LottoResult::getWinnings)
                .sum();
    }
}
