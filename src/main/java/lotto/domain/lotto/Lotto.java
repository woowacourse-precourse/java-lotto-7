package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
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

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUnique(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (containsDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private boolean containsDuplicates(List<Integer> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() != lottoNumbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }
}
