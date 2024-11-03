package lotto;

import java.util.List;

public class LottoWinningNumber {
    private final List<Integer> lottoNumbers;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        Validator.checkWinningNumber(lottoNumbers, bonusNumber);
    }

    public LottoResultCounter countMatchingNumbers(List<Lotto> lottos) {
        LottoResultCounter resultCounter = new LottoResultCounter();

        for (Lotto lotto : lottos) {
            LottoResult result = checkResult(lotto);
            resultCounter.add(result);
        }

        return resultCounter;
    }

    public LottoResult checkResult(Lotto lotto) {
        int count = 0;
        boolean isBonusMatched = lotto.hasNumber(bonusNumber);

        for (Integer number : lottoNumbers) {
            if (lotto.hasNumber(number)) {
                count++;
            }
        }

        return LottoResult.getLottoResult(count, isBonusMatched);
    }
}
