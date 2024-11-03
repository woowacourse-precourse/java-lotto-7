package lotto;

import javax.swing.SwingConstants;
import lotto.exception.ErrorCode;

public class WinningNumber {

    private final Lotto winningRegularLotto;

    private final SpecialNumber specialNumber;

    public WinningNumber(final Lotto winningRegularLotto,final SpecialNumber specialNumber){
        this.winningRegularLotto = winningRegularLotto;
        validateSpecialNumber(specialNumber);
        this.specialNumber = specialNumber;
    }

    private void validateSpecialNumber(final SpecialNumber specialNumber){

        if(winningRegularLotto.getNumbers().contains(specialNumber.getNumber())){
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_MUST_NOT_DUPLICATE.getMessage());
        }
    }

    public Lotto getWinningRegularLotto(){
        return this.winningRegularLotto;
    }

    public SpecialNumber getSpecialNumber(){
        return this.specialNumber;
    }


}
