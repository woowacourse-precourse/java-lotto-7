package Model;


import Model.Constant.Constants;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate1to45(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validate1to45(int bonusNumber) {
        if (bonusNumber < Constants.MIN_NUM || bonusNumber > Constants.MAX_NUM) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE);
        }
    }


    public void validateAlreadyExist(Lotto lotto) {
        for (int i = 0; i < lotto.getSize(); i++) {
            if (bonusNumber == lotto.getItem(i)) {
                throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE);
            }
        }
    }

    public int get() {
        return bonusNumber;
    }
}