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
        List<Integer> sortedNumbers = sortNumbers(numbers);
        return new Lotto(
                sortedNumbers.stream()
                        .map(LottoNumber::of)
                        .toList()
        );
    }

    private static void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateDuplicateLottoNumbers(numbers);
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private static void validateDuplicateLottoNumbers(List<Integer> numbers) {
        if(hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted().toList();
    }
}
