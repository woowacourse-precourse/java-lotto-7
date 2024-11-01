package lotto.model.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicated(final List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
    }

    private void validateRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다. 로또 번호를 입력해주세요.");
        }
    }

    private void validateInput(final String lottoNumber) {
        if (!VALID_NUMBER_PATTERN.matcher(lottoNumber).matches()) {
            throw new IllegalArgumentException("[ERROR] 입력에 숫자와 쉼표만 포함되어야 합니다.");
        }
    }

    protected boolean isContain(final int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
