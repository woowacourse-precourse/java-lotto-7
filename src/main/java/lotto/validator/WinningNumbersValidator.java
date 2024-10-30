package lotto.validator;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersValidator {
    private List<Integer> numbers;

    public boolean isNotValidWinningNumbers(String userInput) {
        if (isNotParsableToNumbers(userInput)) {
            return true;
        }
        if (hasInvalidNumber(numbers)) {
            return true;
        }
        if (isInValidNumberSize(numbers)) {
            return true;
        }
        return false;
    }

    private boolean isNotParsableToNumbers(String userInput) {
        try {
            numbers = Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 숫자형식을 입력해 주세요.");
            return true;
        }
        return false;
    }

    private boolean hasInvalidNumber(List<Integer> numbers) {
        try {
            numbers.forEach(number -> {
                if (number < 1 || 45 < number) {
                    throw new IllegalArgumentException();
                }
            });
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return true;
        }
        return false;
    }

    private boolean isInValidNumberSize(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호는 6개 입니다.");
            return true;
        }
        return false;
    }
}
