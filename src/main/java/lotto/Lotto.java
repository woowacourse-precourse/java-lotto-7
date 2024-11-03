package lotto;

import java.util.List;
import lotto.Constants.Error;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 보너스 번호 유효성 검사
     * 1. 로또 번호 리스트에 포함되어 있으면 안된다.
     * 2. 1부터 45 사이여야 한다.
     *
     * @param bonusNumber 보너스 번호
     */
    public void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBERS_DUPLICATED.getText());
        }
        numberInRange(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void numberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBERS_OUT_OF_RANGE.getText());
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBERS_DUPLICATED.getText());
        }
        numbers.forEach(this::numberInRange);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
