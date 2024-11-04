package lotto.validator;

import java.util.List;

public class LottoNumberValidator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public void validateWinningNumbers(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateDuplicates(numbers);
    }

    public void validateBonusNumber(String bonusNumber) {
        int parsedBonusNumber = Integer.parseInt(bonusNumber);
        validateNumberRange(parsedBonusNumber);
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + " 이상 " + MAX_NUMBER + " 이하의 양수여야 합니다.");
            }
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 " + MIN_NUMBER + " 이상 " + MAX_NUMBER + " 이하의 양수여야 합니다.");
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("보너스 숫자 입력이 비어있습니다.");
        }
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                throw new IllegalArgumentException("보너스 숫자 입력은 양수만 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 숫자 입력은 숫자만 가능합니다.");
        }
    }
}
