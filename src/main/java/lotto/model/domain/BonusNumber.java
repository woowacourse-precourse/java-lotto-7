package lotto.model.domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        bonusNumberRangeValidator(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumberRangeValidator(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}