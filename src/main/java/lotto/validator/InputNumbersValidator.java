package lotto.validator;

import java.util.List;

public class InputNumbersValidator {
    public void validateInputNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
