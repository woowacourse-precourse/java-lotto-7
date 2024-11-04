package lotto;

import javax.swing.SwingConstants;
import lotto.exception.ErrorCode;

public class WinningNumber {

    private final Lotto winningRegularLotto;

    private final BonusNumber bonusNumber;

    public WinningNumber(final Lotto winningRegularLotto,final BonusNumber bonusNumber) {
        this.winningRegularLotto = winningRegularLotto;
        validateSpecialNumber(bonusNumber);
        this.BonusNumber = bonusNumber;
    }

    private void validateSpecialNumber(final BonusNumber bonusNumber) {

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