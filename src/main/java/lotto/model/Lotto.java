package lotto.model;

import lotto.view.constant.ErrorConstant;
import lotto.view.constant.ValidatorConstant;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Lotto {
    private static final String DELIMITER_PATTERN = ",\\s*";
    private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile(
            "\\d{1,2},\\s*\\d{1,2},\\s*\\d{1,2},\\s*\\d{1,2},\\s*\\d{1,2},\\s*\\d{1,2}"
    );

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<Integer> lottoNumbers = strToList(numbers);
        validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isInclude(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (isDuplicated(numbers))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_UNIQUE_NUMBER);
        if (!isWithinValidRange(numbers))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_WITHIN_VALID_RANGE);
    }

    private void validateStr(String numbers) {
        if (!isValidFormat(numbers))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_VALID_FORMAT);
    }

    private List<Integer> strToList(String s) {
        validateStr(s);
        return Arrays.stream(s.split(DELIMITER_PATTERN))
                .map(Integer::parseInt)
                .toList();
    }

    private boolean isValidFormat(String s) {
        return LOTTO_NUMBER_PATTERN.matcher(s).matches();
    }

    private boolean isWithinValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < ValidatorConstant.MIN_NUMBER || number > ValidatorConstant.MAX_NUMBER)
                return false;
        }
        return true;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        List<Integer> filteredNumbers = numbers.stream().distinct().toList();
        return filteredNumbers.size() != numbers.size();
    }
}
