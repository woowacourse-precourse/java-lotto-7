package lotto.model.lotto;

import static lotto.exception.LottoErrorStatus.LOTTO_NUMBER_DUPLICATED;
import static lotto.exception.LottoErrorStatus.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.model.constant.LottoRules.MAX_LOTTO_VALUE;
import static lotto.model.constant.LottoRules.MIN_LOTTO_VALUE;

import java.util.List;
import lotto.exception.LottoException;

public class PrizeLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public PrizeLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    public int countWinningLottoMatched(Lotto lotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public static PrizeLotto from(List<Integer> lottoNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(lottoNumbers);
        return new PrizeLotto(winningLotto, bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_VALUE || bonusNumber > MAX_LOTTO_VALUE) {
            throw new LottoException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATED);
        }
    }
}
