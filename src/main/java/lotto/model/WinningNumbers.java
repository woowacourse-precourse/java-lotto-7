package lotto.model;

import static lotto.model.constant.LottoRule.MAX_NUMBER;
import static lotto.model.constant.LottoRule.MIN_NUMBER;
import static lotto.model.constant.LottoRule.NUMBER_COUNT;

import java.util.List;
import lotto.dto.WinningNumberRequestDTO;

public class WinningNumbers {
    private static final String INVALID_COUNT_MESSAGE = "[ERROR] 로또 번호는 6개이어야 합니다.";
    private static final String OVER_RANGE_MESSAGE = "[ERROR] 로또 번호의 범위를 초과했습니다.";
    private static final String DUPLICATE_MESSAGE = "[ERROR] 중복된 로또 번호가 있습니다.";

    private final List<Integer> winningNumbers;

    public WinningNumbers(WinningNumberRequestDTO winningNumberRequestDTO) {
        List<Integer> numbers = winningNumberRequestDTO.getNumbers();
        validate(numbers);
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getConstant()) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (distinctCount != NUMBER_COUNT.getConstant()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER.getConstant() || number > MAX_NUMBER.getConstant())) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
    }

    public boolean isWinningNumber(Integer number) {
        return winningNumbers.contains(number);
    }
}
