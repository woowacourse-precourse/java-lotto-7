package lotto.model;

import lotto.exception.BonusNumberException;

import static lotto.common.constant.ErrorMessage.WINNING_NUMBER_CONTAINS_BONUS_NUMBER;

public class WinningLotto {
    private final WinningLottoNumber winningLottoNumber;
    private final BonusNumber bonusNumber;

    private WinningLotto(WinningLottoNumber winningLottoNumber, BonusNumber bonusNumber) {
        this.winningLottoNumber = winningLottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(WinningLottoNumber winningLottoNumber, BonusNumber bonusNumber) {
        if(winningLottoNumber.isContainInWinningLottoNumber(bonusNumber)){
            throw new BonusNumberException(WINNING_NUMBER_CONTAINS_BONUS_NUMBER);
        }
        return new WinningLotto(winningLottoNumber, bonusNumber);
    }
}
