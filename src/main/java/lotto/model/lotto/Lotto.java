package lotto.model.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.common.ErrorMessage;

public class Lotto {
    private static final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^\\d+(,\\d+)*$");
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(final String lottoNumbers) {
        List<Integer> numbers = convertStringToLotto(lottoNumbers);
        validate(numbers);
        this.numbers = numbers;
    }

    boolean isContain(final int number) {
        return numbers.contains(number);
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateDuplicated(final List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_CONFLICT_ERROR.getMessage());
        }
    }

    private void validateRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }

    private List<Integer> convertStringToLotto(final String lottoNumber) {
        validateString(lottoNumber);
        return Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateString(final String lottoNumber) {
        validateEmptyInput(lottoNumber);
        validateInput(lottoNumber);
    }

    private void validateEmptyInput(final String lottoNumber) {
        if (lottoNumber == null || lottoNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateInput(final String lottoNumber) {
        if (!VALID_NUMBER_PATTERN.matcher(lottoNumber).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
