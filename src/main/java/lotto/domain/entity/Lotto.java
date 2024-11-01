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
    private static final String SEPARATOR = ",";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validator.validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public static Lotto from(String input) {
        nonBlankValidator.validate(input);
        return new Lotto(parseInputNumbers(input));
    }

    private static List<Integer> parseInputNumbers(String input) {
        return Arrays.stream(input.trim().split(SEPARATOR))
            .map(String::trim)
            .peek(Lotto::validateEachNumber)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    private static void validateEachNumber(String splitInput) {
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
