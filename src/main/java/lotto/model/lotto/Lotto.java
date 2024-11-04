package lotto.model.lotto;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionHandler.throwIllegalArgException(ErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    // 로또 번호 범위 검사
    private void validateNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            ExceptionHandler.throwIllegalArgException(ErrorMessage.INVALID_NUMBER);
        }
    }

    // 중복 검사
    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            ExceptionHandler.throwIllegalArgException(ErrorMessage.DUPLICATE_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
