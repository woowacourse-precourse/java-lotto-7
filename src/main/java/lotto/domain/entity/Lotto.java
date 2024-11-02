package lotto.domain.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.validator.InputValidator;
import lotto.domain.validator.LottoValidator;
import lotto.domain.validator.NonBlankValidator;
import lotto.domain.vo.LottoNumbers;

public class Lotto {
    private static final InputValidator nonBlankValidator = new NonBlankValidator();
    private static final InputValidator validator = new LottoValidator();
    private static final String SHOULD_NOT_BE_END_SEPARATOR = "마지막 글자로 구분자는 허용되지 않습니다";
    private static final String SEPARATOR = ",";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validator.validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public Lotto(String input) {
        List<Integer> numbers = validateInputNumbers(input);
        this.numbers = sortNumbers(numbers);
    }

    private List<Integer> validateInputNumbers(String input) {
        nonBlankValidator.validate(input);
        validateEndingSeparator(input);
        List<Integer> numbers = parseInputNumbers(input);
        validator.validate(numbers);
        return numbers;
    }

    private void validateEndingSeparator(String input) {
        if (input.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException(SHOULD_NOT_BE_END_SEPARATOR);
        }
    }

    private List<Integer> parseInputNumbers(String input) {
        return Arrays.stream(input.trim().split(SEPARATOR))
            .map(String::trim)
            .peek(this::validateEachNumber)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    private void validateEachNumber(String splitInput) {
        validator.validate(splitInput);
    }

    public LottoNumbers createLottoNumbers() {
        return new LottoNumbers(List.copyOf(numbers));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
