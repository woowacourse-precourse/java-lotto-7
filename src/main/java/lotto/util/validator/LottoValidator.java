package lotto.util.validator;

import java.util.List;

public class LottoValidator extends Validator<List<Integer>> {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    @Override
    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    public void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonusNumbers(numbers, bonusNumber);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + "로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isOutOfRange)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM;
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateBonusNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
