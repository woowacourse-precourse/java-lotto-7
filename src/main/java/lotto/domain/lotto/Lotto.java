package lotto.domain.lotto;

import static lotto.exception.message.LottoExceptionMessage.DUPLICATE_NUMBER_INPUT;
import static lotto.exception.message.LottoExceptionMessage.INVALID_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoException;
import lotto.ui.dto.LottoNumbersResponse;

public class Lotto {

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplication(numbers);

        return new Lotto(numbers.stream()
                .map(LottoNumber::from)
                .toList());
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(INVALID_NUMBER_COUNT);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);

        if (distinctNumbers.size() != 6) {
            throw new LottoException(DUPLICATE_NUMBER_INPUT);
        }
    }

    public int match(Lotto otherLotto) {
        int count = 0;
        for (LottoNumber number: otherLotto.numbers) {
            if (contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public LottoNumbersResponse toResponse() {
        return LottoNumbersResponse.from(numbers);
    }

}
