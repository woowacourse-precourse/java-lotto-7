package lotto.model;

import lotto.model.enums.ErrorMessage;
import lotto.model.enums.LottoConstants;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if ( bonusNumber > LottoConstants.LOTTO_END_NUMBER.getValue() ||
                bonusNumber < LottoConstants.LOTTO_BEGIN_NUMBER.getValue() ) {
            throw new IllegalArgumentException(ErrorMessage.WITHIN_NUMBERS_RANGE.getMessage());
        }
        for ( int number : winningLotto.getNumbers() ) {
            if ( bonusNumber == number ) {
                throw new IllegalArgumentException(ErrorMessage.CANNOT_DUPLICATE.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
