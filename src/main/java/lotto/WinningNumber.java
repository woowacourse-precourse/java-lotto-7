package lotto;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        validate(bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수가 맞지 않습니다.");
        }
    }

    private void validate(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }


}
