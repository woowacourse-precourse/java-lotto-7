package lotto.domain;

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

    public static class Builder {
        private List<Integer> numbers;
        private Integer bonusNumber;

        public Builder numbers(List<Integer> numbers) {
            validateSize(numbers);
            validateRange(numbers);
            validateDuplicate(numbers);
            this.numbers = numbers;
            return this;
        }

        public Builder bonusNumber(Integer bonusNumber) {
            this.bonusNumber = bonusNumber;
            return this;
        }

        public WinningLotto build() {
            if (numbers == null || bonusNumber == null) {
                throw new IllegalStateException("[ERROR] 로또 번호와 보너스 번호를 모두 설정해야 합니다.");
            }
            new Lotto(numbers).containBonusNumber(bonusNumber);
            return new WinningLotto(numbers, bonusNumber);
        }

    }
}
