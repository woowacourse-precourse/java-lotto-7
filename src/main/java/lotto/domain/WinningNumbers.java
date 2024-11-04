package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ValidatorFactory;
import lotto.validation.Validator;

public class WinningNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public WinningNumbers(String input) {
        Validator<String> stringValidator = ValidatorFactory.createStringValidator("[ERROR] 당첨 번호는 올바른 형식이어야 합니다.");
        stringValidator.validate(input);

        List<Integer> parsedNumbers = parseNumbers(input);
        validateWinningNumbers(parsedNumbers);
        this.numbers = List.copyOf(parsedNumbers);
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        Validator<List<Integer>> uniqueNumberValidator =
                ValidatorFactory.createUniqueNumberValidator("[ERROR] 당첨 번호는 중복되지 않는 숫자여야 합니다.");
        Validator<Integer> rangeValidator =
                ValidatorFactory.createNumberRangeValidator(MIN_NUMBER, MAX_NUMBER, "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        Validator<List<Integer>> countValidator =
                ValidatorFactory.createNumberCountValidator(NUMBER_COUNT, "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");

        uniqueNumberValidator.validate(numbers);
        countValidator.validate(numbers);
        numbers.forEach(rangeValidator::validate);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
