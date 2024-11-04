package lotto.model;

import lotto.common.ExceptionConstant;

public record WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {

    public WinningLotto {
        validateDuplicate(winningLotto, bonusNumber);
    }

    private void validateDuplicate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE + ExceptionConstant.BONUS_BALL_DUPLICATION_MESSAGE);
        }
    }

}
