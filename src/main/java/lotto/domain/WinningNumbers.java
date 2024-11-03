package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto numbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_NUMBER.getMessage());
        }
        bonusNumber = number;
    }
}
