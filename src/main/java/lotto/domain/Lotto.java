package lotto.domain;

import lotto.validate.ValidateInput;

import java.util.List;

import static lotto.validate.LottoConstants.LOTTO_NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        ValidateInput.validateWinningNumbers(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
