package lotto.model;

import static lotto.constants.ErrorMessage.LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateHasDuplicatedNumbers(numbers);
    }

    private void validateHasDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED.get());
        }
    }

    public List<Integer> get() {
        return numbers;
    }
}
