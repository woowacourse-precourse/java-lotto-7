package lotto.model;

import lotto.util.ErrorMessages;

public class User {

    private Lotto lotto;
    private int bonusNumber;
    private int price;

    public Lotto getLotto() {
        return lotto;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        if (bonusNumber < Lotto.NUMBER_MIN || bonusNumber > Lotto.NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
        if (lotto.matchBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER.getMessage());
        }
        this.bonusNumber = bonusNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price % Lotto.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_PRICE.getMessage());
        }
        this.price = price;
    }
}
