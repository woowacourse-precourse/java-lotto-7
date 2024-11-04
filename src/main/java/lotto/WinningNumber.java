package lotto;

import lotto.exception.ErrorCode;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import java.util.List;

import lotto.BonusNumber;
import lotto.Lotto;


public class WinningNumber {

    private final Lotto winningRegularLotto;

    private final BonusNumber bonusNumber;

    public WinningNumber(final Lotto winningRegularLotto,final BonusNumber bonusNumber) {
        this.winningRegularLotto = winningRegularLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(final BonusNumber bonusNumber) {

        if(winningRegularLotto.getNumbers().contains(bonusNumber.getNumber())){
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_LOTTO_NUMBERS_NOT_ALLOWED.getMessage());
        }
    }

    public Lotto getWinningRegularLotto(){
        return this.winningRegularLotto;
    }

    public BonusNumber getBonusNumber(){
        return this.bonusNumber;
    }

}

