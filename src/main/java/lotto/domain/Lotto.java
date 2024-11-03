package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    private static List<LottoNumber> convertToLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public int calculateMatchCount(final List<LottoNumber> winNumbers) {
        return winNumbers.stream()
                .filter(numbers::contains)
                .mapToInt(number -> 1)
                .sum();
    }

    public boolean isContainNumber(final LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getNumberValues() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
