package lotto.model;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45사이의 숫자여야 합니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
