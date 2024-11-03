package lotto;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoHost {

    List<Lotto> lottos;
    LinkedHashMap<LottoResult, Integer> winningResult = new LinkedHashMap<>();

    public LottoHost(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LinkedHashMap<LottoResult, Integer> getWinningResults(List<Integer> winningNumbers, int bonusNumber) {
        winningResult = initializeWinningResults();
        for (Lotto lotto : lottos) {
            LottoResult result = new LottoResult(countSameNumbers(lotto, winningNumbers), haveBonusNumber(lotto,
                    bonusNumber));
            if (result.getRankName().equals("NONE_RANK")) {
                continue;
            }
            winningResult.put(result, winningResult.get(result) + 1);
        }
        return winningResult;
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

    public float calcEarningRate(String inputCash) {
        BigInteger earningPrice = calcEarningPrice();
        BigInteger inputPrice = new BigInteger(inputCash);
        return earningPrice.divide(inputPrice).floatValue();
    }

    public BigInteger calcEarningPrice() {
        BigInteger earningPrice = BigInteger.ZERO;
        for (LottoResult result : winningResult.keySet()) {
            String prizeAmount = Integer.toString(result.getPrize());
            for (int count = 0; count < winningResult.get(result); count++) {
                earningPrice = earningPrice.add(new BigInteger(prizeAmount));
            }
        }
        return earningPrice;
    }
}
