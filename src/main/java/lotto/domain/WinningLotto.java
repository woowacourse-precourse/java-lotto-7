package lotto.domain;

import java.util.List;
import lotto.common.LottoResults;
import lotto.exception.LottoArgumentException;

public class WinningLotto extends Lotto {
    private static final String BONUS_NUMBER_DUPLICATED_MESSAGE = "보너스 번호가 이미 로또 번호에 포함되어 있습니다.";
    private final LottoNumber bonusNumber;

    public WinningLotto(final List<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        super(lottoNumbers);
        validateAlreadyExistsNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(final Lotto lotto, final LottoNumber bonusNumber) {
        super(lotto.getNumbers());
        validateAlreadyExistsNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoResults getResult(final Lotto lotto) {
        final int matchedCount = getMatchedNumberCount(lotto);
        final boolean bonusNumberMatched = bonusNumberMatched(lotto);
        return LottoResults.getWinningStatus(matchedCount, bonusNumberMatched);
    }

    private int getMatchedNumberCount(final Lotto lotto) {
        int matchedCount = 0;
        for (final LottoNumber winningNumber : this.getNumbers()) {
            if (lotto.containsNumber(winningNumber)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }

    private boolean bonusNumberMatched(final Lotto lotto) {
        if (lotto.containsNumber(this.bonusNumber)) {
            return true;
        }
        return false;
    }

    private void validateAlreadyExistsNumber(final LottoNumber bonusNumber) {
        if (super.containsNumber(bonusNumber)) {
            throw new LottoArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }
    }
}
