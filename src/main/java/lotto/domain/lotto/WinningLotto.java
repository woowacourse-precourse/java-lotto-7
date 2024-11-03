package lotto.domain.lotto;

import lotto.common.exception.InvalidBonusNumberException;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(LottoNumber bonusNumber) {
        if(winningLotto.getLottoNumbers().stream()
                .anyMatch(bonusNumber::equals)) {
            throw new InvalidBonusNumberException(bonusNumber);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
