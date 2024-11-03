package lotto.service;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {
    private static final Integer WINNING_NUMBERS_COUNT=6;
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        validateNull(numbers);
        validateWinningNumbersCount(numbers);
        validateWinningNumbersDuplicates(numbers);
        validateWinningNumbersRange(numbers);
    }

    private void validateNull(List<Integer> numbers) {
        if(numbers==null){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
        }
    }

    private void validateWinningNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 범위를 벗어납니다.");
            }
        }
    }

    private void validateWinningNumbersCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateWinningNumbersDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
