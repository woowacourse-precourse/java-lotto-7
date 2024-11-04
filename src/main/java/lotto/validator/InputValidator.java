package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");
    private static final Pattern WINNING_NUMBERS_FORMAT = Pattern.compile("\\d+(,\\d+)*");

    public void validateAmount(String input) {
        validateNotBlank(input);
        validateNumeric(input);
        validateDivisibleBy1000(input);
    }

    public void validateWinningNumbers(String input) {
        validateNotBlank(input);
        validateWinningNumbersFormat(input);
        validateNumberRange(input);
        validateDuplicateNumbers(input);
        validateNumberCount(input);
    }

    public void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateNotBlank(input);
        validateNumeric(input);
        int number = Integer.parseInt(input);
        validateNumberInRange(number);
        validateNotDuplicate(number, winningNumbers);
    }

    private void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    private void validateNumeric(String input) {
        if (!NUMBER_FORMAT.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateDivisibleBy1000(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private void validateWinningNumbersFormat(String input) {
        if (!WINNING_NUMBERS_FORMAT.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
    }

    private void validateNumberRange(String input) {
        Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .forEach(this::validateNumberInRange);
    }

    private void validateNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void validateNumberCount(String input) {
        if (input.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateNotDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}