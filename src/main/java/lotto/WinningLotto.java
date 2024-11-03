package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        containBonusNumber(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber < lowerBound || bonusNumber > upperBound) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 숫자만 가능합니다.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
