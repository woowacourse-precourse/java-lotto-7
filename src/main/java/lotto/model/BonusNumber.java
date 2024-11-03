package lotto.model;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber){
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45사이의 숫자만 입력 가능합니다.");
        }
    }
}
