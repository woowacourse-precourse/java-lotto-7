package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

public class Lotto {

    private static final int LOTTO_COMBINATION_LENGTH = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private <T> void validate(List<T> numbers) {
        if (numbers.size() != LOTTO_COMBINATION_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %개여야 합니다.", LOTTO_COMBINATION_LENGTH));
        }
    }

}
