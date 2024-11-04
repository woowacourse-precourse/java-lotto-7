package lotto.domain;

import java.util.List;
import lotto.error.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    public void validateBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber);
    }

    private void validateNumberCount(List<Integer> numbers) {
        // 로또 번호의 개수가 6개가 아닌 경우
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        // 로또 번호에 중복된 숫자가 있는 경우
        if (numbers.stream().distinct().count() != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        // 로또 번호가 1부터 45 사이가 아닌 경우
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        // 보너스 번호의 범위가 올바르지 않은 경우
        if (!isValidRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonusNumberDuplication(int bonusNumber) {
        // 보너스 번호가 당첨 번호와 중복된 경우
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().allMatch(this::isValidRange);
    }

    private boolean isValidRange(int number) {
        return number >= LottoConstants.LOTTO_MIN_NUMBER.getValue() &&
                number <= LottoConstants.LOTTO_MAX_NUMBER.getValue();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
