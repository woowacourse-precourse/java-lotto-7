package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<String> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .toList();
    }

    protected boolean contains(LottoNumber number) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber == number);
    }

    protected boolean contains(int number) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.getNumber() == number);
    }

    private void validate(List<String> numbers) {
        validateNumberCount(numbers);
        validateInteger(numbers);
        validateUnique(numbers);
    }

    private void validateNumberCount(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateInteger(List<String> numbers) {
        if (!isInteger(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수여야 합니다.");
        }
    }

    private boolean isInteger(List<String> numbers) {
        try {
            numbers.forEach(Integer::parseInt);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateUnique(List<String> numbers) {
        if (containsDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private boolean containsDuplicates(List<String> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() != lottoNumbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }
}
