package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoMatch, Integer> lottoResults;

    public LottoResult() {
        this.lottoResults = new EnumMap<>(LottoMatch.class);
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            lottoResults.put(lottoMatch, 0);
        }
    }

    public void addLottoResult(LottoMatch lottoMatch) {
        lottoResults.put(lottoMatch, lottoResults.get(lottoMatch) + 1);
    }

    public int getLottoResult(LottoMatch lottoMatch) {
        return lottoResults.get(lottoMatch);
    }

    public void calculateLottoResult(LottoCreate lottoCreate, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoCreate.getLottos()) {
            int matchCount = countMatchCount(lotto.getNumbers(), winningNumbers.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
            LottoMatch lottoMatch = LottoMatch.getLottoMatch(matchCount, bonusMatch);
            if (lottoMatch != LottoMatch.NONE)
                addLottoResult(lottoMatch);
        }
    }

    private int countMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number))
                matchCount++;
        }
        return matchCount;
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (Map.Entry<LottoMatch, Integer> entry : lottoResults.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }

    public double calculateYield(LottoCreate lottoCreate) {
        return (double) calculateTotalPrize() / lottoCreate.getLottoCount() * 100;
    }
}
