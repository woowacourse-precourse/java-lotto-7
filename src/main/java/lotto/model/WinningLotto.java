package lotto.model;

import lotto.Constants.ErrorMessages;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(Lotto lotto) {
        super(lotto.getNumbers());
        this.bonusNumber = 0;
    }

    private int checkBonusNumber(String number){
        int num = Integer.parseInt(number);
        checkRange(num);
        if (this.numbers.contains(num)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_ERROR.getMessage());
        }
        return num;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = checkBonusNumber(bonusNumber);
    }
}
