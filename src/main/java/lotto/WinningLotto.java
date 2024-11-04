package lotto;

import java.util.List;
import lotto.common.LottoNumber;
import lotto.common.LottoResult;
import lotto.exception.LottoArgumentException;

public class WinningLotto extends Lotto {
    private final LottoNum bonusNumber;

    public WinningLotto(final List<LottoNum> lottoNumbers, final LottoNum bonusNumber) {
        super(lottoNumbers);
        validateAlreadyExistsNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(final Lotto lotto, final LottoNum bonusNumber) {
        super(lotto.getNumbers());
        validateAlreadyExistsNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult getResult(final Lotto lotto) {
        final int matchedCount = getMatchedNumberCount(lotto);
        final boolean bonusNumberMatched = bonusNumberMatched(lotto);
        return LottoResult.getWinningStatus(matchedCount, bonusNumberMatched);
    }

    private int getMatchedNumberCount(final Lotto lotto) {
        int matchedCount = 0;
        for (final LottoNum winningNumber : this.getNumbers()) {
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

    private void validateAlreadyExistsNumber(final LottoNum bonusNumber) {
        if (super.containsNumber(bonusNumber)) {
            throw new LottoArgumentException("보너스 번호가 이미 로또 번호에 포함되어 있습니다.");
        }
    }
}
