package lotto.domain;

import java.util.List;

public class Winning extends Lotto {
    private Integer bonusNumber;

    public Winning(List<Integer> numbers) {
        super(numbers);
    }

    public List<Integer> getNumbers() {
        return super.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Winning validateBonusNumber(Integer bonusNumber) {
        List<Integer> numbers = super.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복될 수 없습니다.");
        }
        this.bonusNumber = bonusNumber;
        return this;
    }

}
