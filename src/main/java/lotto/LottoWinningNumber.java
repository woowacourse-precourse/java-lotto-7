package lotto;

import java.util.List;

public class LottoWinningNumber {
    private List<Integer> lottoNumbers;
    private int bonusNumber;

    public LottoWinningNumber(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        Validator.checkWinningNumber(lottoNumbers, bonusNumber);
    }

    public LottoResultCounter countMatchingNumbers(List<Lotto> lottos) {
        LottoResultCounter resultCounter = new LottoResultCounter();

        for (Lotto lotto : lottos) {
            LottoResult result = LottoWinningNumber.checkResult(lotto);
            resultCounter.add(result);
        }

        return resultCounter;
    }

    private static LottoResult checkResult(Lotto lotto) {
        return null;
    }
}
