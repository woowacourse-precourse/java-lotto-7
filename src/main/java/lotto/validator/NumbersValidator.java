package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.*;

public class NumbersValidator {
    private enum ErrorMessage {
        MUST_BE_TARGET_LENGTH("%s %s 번호는 %d개이어야 합니다."),
        MUST_BE_NUMBER("%s 로또 번호는 숫자 형식이어야 합니다."),
        MUST_BE_UNIQUE("%s 로또 번호가 중복되었습니다."),
        MUST_BE_NO_SPACE("%s 공백은 허용되지 않습니다."),
        MUST_BE_BETWEEN("%s 로또 번호는 1 ~ 45 사이 숫자이어야 합니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return String.format(message, ERROR_MESSAGE_BEGINNING);
        }

        public String getMessage(String type, int length) {
            return String.format(message, ERROR_MESSAGE_BEGINNING, type, length);
        }
    }

    private List<Integer> winningNumbers = new ArrayList<>();

    private List<Integer> parseNumbersToList(String numbersInput) {
        return Arrays.stream(numbersInput.split(","))
                .peek(this::validateNoSpace)
                .peek(this::validateIsNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMBER.getMessage());
        }
    }

    public void validateWinningNumbers(String input) {
        this.winningNumbers = parseNumbersToList(input);
        validateLength("당첨", winningNumbers);
        validateUnique(winningNumbers);
        validateBetweenList(winningNumbers);
    }

    public void validateBonusNumber(String input) {
        List<Integer> bonusNumber = parseNumbersToList(input);
        validateLength("보너스", bonusNumber);
        validateBetweenList(bonusNumber);
        validateBonusNumber(bonusNumber);
    }

    private void validateLength(String type, List<Integer> numbers) {
        int targetLength = LENGTH_BY_NUMBER_TYPE.get(type);
        if (numbers.size() != targetLength) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_TARGET_LENGTH.getMessage(type, targetLength));
        }
    }

    private void validateUnique(List<Integer> numbers) {
        int beforeSize = numbers.size();
        int afterSize = new HashSet<>(numbers).size();

        if (beforeSize != afterSize) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_UNIQUE.getMessage());
        }
    }

    private void validateNoSpace(String number) {
        int beforeLength = number.length();
        int afterLength = number.strip().length();

        if (beforeLength != afterLength) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NO_SPACE.getMessage());
        }
    }

    private void validateBetweenList(List<Integer> numbers) {
        for (int number : numbers) {
            validateBetween(number);
        }
    }

    private void validateBetween(int number) {
        if (number < RANDOM_MIN || RANDOM_MAX < number) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_BETWEEN.getMessage());
        }
    }

    private void validateBonusNumber(List<Integer> numbers) {
        List<Integer> copyWinningNumbers = getWinningNumbers();
        copyWinningNumbers.addAll(numbers);

        validateUnique(copyWinningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return getNumbers(winningNumbers);
    }

    public List<Integer> getBonusNumber() {
        return getNumbers(winningNumbers);
    }

    private List<Integer> getNumbers(List<Integer> numbers) {
        return new ArrayList<>(numbers);
    }
}
