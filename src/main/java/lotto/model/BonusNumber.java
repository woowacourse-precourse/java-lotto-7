package lotto.model;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber){
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        checkBonusNumberRange(bonusNumber);
    }

    private void checkBonusNumberRange(Integer bonusNumber){
        if (bonusNumber <= 1 || bonusNumber >= 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
