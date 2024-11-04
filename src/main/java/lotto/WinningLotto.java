package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. ");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public List<Integer> getNumbers() {
        return super.getNumbers();
    }
}
