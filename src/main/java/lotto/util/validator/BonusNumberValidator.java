package lotto.util.validator;

import static lotto.common.Constants.LOTTO_NUMBER_MAX;
import static lotto.common.Constants.LOTTO_NUMBER_MIN;

import java.util.List;
import lotto.util.ErrorMessage;

public class BonusNumberValidator {

    public void validate(String input, List<Integer> winningNumbers) {
        checkNullOrBlank(input);           // 빈 값 검증
        int number = parseNumber(input); // 숫자 형식 검증 및 파싱
        checkNaturalNumber(number);   // 자연수 검증
        checkRange(number);
        checkDuplicate(number, winningNumbers); // 당첨 번호와 중복 여부 검증
    }

    private void checkNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private void checkNaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_NATURAL_NUMBER.getMessage());
        }
    }

    private void checkRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void checkDuplicate(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
