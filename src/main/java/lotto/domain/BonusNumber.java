package lotto.domain;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean same(Integer number) {
        return bonusNumber.equals(number);
    }
}
