package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.Message;

public class WinningNumber {
    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto winningNumber, BonusNumber bonusNumber) {
        validateDuplication(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplication(Lotto winningNumber, BonusNumber bonusNumber){
        if(winningNumber.getNumbers().contains(bonusNumber.getBonusNumber())){
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.UNIQUE_BONUS_NUMBER.getError());
        }
    }

}
