package lotto.domain;

import static lotto.exception.constants.ErrorMessage.WINNING_NUMBER_DUPLICATE;

import lotto.exception.LottoException;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(final Lotto winningLotto, final LottoNumber bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Integer matchCount(final Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
    }

    public Boolean isBonusMatch(final Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private void validateBonusNumber(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new LottoException(WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
