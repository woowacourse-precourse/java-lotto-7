package lotto.domain;

import java.util.List;
import lotto.domain.vo.LottoNumber;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validate(numbers);
        return new Lotto(
                numbers.stream()
                        .map(LottoNumber::of)
                        .toList()
        );
    }

    private static void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }
}
