package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.exception.LottoException;

public class WinningResult {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningResult(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<Prize, Integer> calculateResult(Lottos lottos) {
        Map<Prize, Integer> result = initializeResultMap();
        for(Lotto lotto : lottos.getLottos()) {
            result.merge(calculatePrize(lotto), 1, Integer::sum);
        }
        return result;
    }

    public Prize calculatePrize(Lotto lotto) {
        int matchCount = countMatchLotto(lotto.getNumbers());
        boolean isMatchBonus = false;
        if (matchCount == 5) {
            isMatchBonus = matchBonusNumber(lotto);
        }
        return Prize.from(matchCount, isMatchBonus);
    }

    public double calculateReturnRate(Lottos lottos) {
        long totalPrize = calculateTotalPrize(calculateResult(lottos));
        long totalPurchaseAmount = calculateTotalPurchaseAmount(lottos);
        return formatReturnRate((double) totalPrize / totalPurchaseAmount * 100);
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(LottoException.INVALID_BONUS_NUMBER_RANGE);
        }

        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoException.DUPLICATE_BONUS_NUMBER);
        }

    }

    private Map<Prize, Integer> initializeResultMap() {
        Map<Prize, Integer> result = new HashMap<>();
        for(Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
        return result;
    }

    private int countMatchLotto(List<Integer> lottoNumbers) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int matchCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningLottoNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private long calculateTotalPrize(Map<Prize, Integer> result) {
        long totalPrize = 0;
        for (Prize prize : result.keySet()) {
            totalPrize += prize.getPrizeAmount() * result.get(prize);
        }
        return totalPrize;
    }

    private long calculateTotalPurchaseAmount(Lottos lottos) {
        return lottos.size()* 1_000L;
    }

    private double formatReturnRate(double rate) {
        return Math.round(rate * 10) / 10.0;
    }
}
