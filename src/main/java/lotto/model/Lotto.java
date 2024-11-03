package lotto.model;

import java.util.List;
import lotto.enums.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (!validateSizeLottoNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
        if (!validateDuplicateLottoNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
        if (!validateRangeLottoNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean validateRangeLottoNumbers (List<Integer> numbers) {
        // 1 ~ 45 사이 수 체크
        for (int num: numbers) {
            if (num < 1 || num > 45) {
                return false;
            }
        }
        return true;
    }

    public boolean validateSizeLottoNumbers (List<Integer> numbers) {
        if (numbers.size() != 6) {
            return false;
        }
        return true;
    }

    public boolean validateDuplicateLottoNumbers (List<Integer> numbers) {
        // 중복 수 체크
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            return false;
        }
        return true;
    }
}
