package lotto.domain.winning;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static final String ERROR_INPUT = "[ERROR] 정수를 입력하세요.";
    private static final String ERROR_RANGE = "[ERROR] 1~45 사이의 숫자를 입력해주세요.";
    private static final String ERROR_DUPLICATE = "[ERROR] 중복된 숫자를 입력할 수 없습니다.";
    private static final String ERROR_SIX_NUMBER = "[ERROR] 당첨 번호의 갯수는 6개의 숫자와 ,로 입력되어야 합니다.";
    private static final String SPLIT_WORD = ",";

    private final List<Integer> numbers = new ArrayList<>();
    private final int bonusNumber;

    public WinningNumber(String numbers, String bonusNumber) {
        setWinningNumber(numbers);

        validateInput(bonusNumber);
        validateRange(Integer.parseInt(bonusNumber));
        validateDuplicateNumber(Integer.parseInt(bonusNumber));

        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setWinningNumber(String input) {
        validateSixNumber(input);

        List<String> numbers = List.of(input.split(SPLIT_WORD));

        for (String number : numbers) {
            validateInput(number);
            validateRange(Integer.parseInt(number));
            validateDuplicateNumber(Integer.parseInt(number));
            this.numbers.add(Integer.parseInt(number));
        }
    }

    private void validateInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT);
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private void validateDuplicateNumber(int number) {
        if (this.numbers.contains(number)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private void validateSixNumber(String input) {
        String[] number = input.split(SPLIT_WORD);

        if (number.length != 6) {
            throw new IllegalArgumentException(ERROR_SIX_NUMBER);
        }
    }
}
