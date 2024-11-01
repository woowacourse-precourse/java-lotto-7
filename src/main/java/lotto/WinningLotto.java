package lotto;

import java.util.List;
import lotto.common.LottoNumber;
import lotto.common.LottoResult;
import lotto.exception.LottoArgumentException;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(final List<Integer> numbers, final int bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult getResult(final Lotto lotto) {
        final int matchedCount = getMatchedNumberCount(lotto);
        final boolean bonusNumberMatched = bonusNumberMatched(lotto);
        return LottoResult.getWinningStatus(matchedCount, bonusNumberMatched);
    }

    private int getMatchedNumberCount(final Lotto lotto) {
        int matchedCount = 0;
        for (int winningNumber : this.getNumbers()) {
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

    private void validate(final int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateAlreadyExistsNumber(bonusNumber);
    }

    private void validateBonusNumberRange(final int bonusNumber) {
        if (bonusNumber < LottoNumber.START.getNumber() || bonusNumber > LottoNumber.END.getNumber()) {
            throw new LottoArgumentException("잘못된 BonusNumber");
        }
    }

    private void validateAlreadyExistsNumber(final int bonusNumber) {
        if (super.containsNumber(bonusNumber)) {
            throw new LottoArgumentException("보너스 번호가 이미 로또 번호에 포함되어 있습니다.");
        }
    }
}
