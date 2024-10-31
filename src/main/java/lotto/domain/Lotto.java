package lotto.domain;

import lotto.constants.Ranking;
import lotto.validator.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    // TODO: 추가 기능 구현
}
