package lotto;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoHost {

    private static final int MAKE_PERCENT = 100;

    List<Lotto> lottos;
    LinkedHashMap<LottoResult, Integer> winningResults = new LinkedHashMap<>();

    public LottoHost(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void getWinningResults(List<Integer> winningNumbers, int bonusNumber) {
        winningResults = initializeWinningResults();
        for (Lotto lotto : lottos) {
            int sameNumbersCount = countSameNumbers(lotto, winningNumbers);
            if (sameNumbersCount < 3) {
                continue;
            }
            LottoResult result = new LottoResult(sameNumbersCount, haveBonusNumber(lotto,
                    bonusNumber));
            if (result.getRankName().equals("NONE_RANK")) {
                continue;
            }
            winningResults.put(result, winningResults.get(result) + 1);
        }
    }

    private LinkedHashMap<LottoResult, Integer> initializeWinningResults() {
        LinkedHashMap<LottoResult, Integer> winningResult = new LinkedHashMap<>();
        winningResult.put(new LottoResult(3, false), 0);
        winningResult.put(new LottoResult(4, false), 0);
        winningResult.put(new LottoResult(5, false), 0);
        winningResult.put(new LottoResult(5, true), 0);
        winningResult.put(new LottoResult(6, false), 0);
        winningResult.put(new LottoResult(0, false), 0);
        return winningResult;
    }

    public int countSameNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int sameNumberCount = 0;

        for (Integer winningNumber : winningNumbers) {
            if (lotto.haveNumber(winningNumber)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    public boolean haveBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.haveNumber(bonusNumber);
    }

    public BigDecimal calcEarningRate(String inputCash) {
        BigDecimal earningPrice = calcEarningPrice();
        BigDecimal inputPrice = new BigDecimal(inputCash);
        return earningPrice.divide(inputPrice)
                .multiply(BigDecimal.valueOf(MAKE_PERCENT));
    }

    public BigDecimal calcEarningPrice() {
        BigDecimal earningPrice = BigDecimal.ZERO;
        for (LottoResult result : winningResults.keySet()) {
            String prizeAmount = Integer.toString(result.getPrize());
            for (int count = 0; count < winningResults.get(result); count++) {
                earningPrice = earningPrice.add(new BigDecimal(prizeAmount));
            }
        }
        return earningPrice;
    }

    public LinkedHashMap<LottoResult, Integer> getWinningResults() {
        return winningResults;
    }
}
