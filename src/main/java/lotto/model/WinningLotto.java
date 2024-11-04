package lotto.model;

import lotto.constants.Error_Messages;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(Lotto lotto) {
        super(lotto.getNumbers());
        this.bonusNumber = 0;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = checkBonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int checkBonusNumber(String number){
        int num = Integer.parseInt(number);
        checkRange(num);
        if (this.numbers.contains(num)) {
            throw new IllegalArgumentException(Error_Messages.DUPLICATE_ERROR);
        }
        return num;
    }
}
