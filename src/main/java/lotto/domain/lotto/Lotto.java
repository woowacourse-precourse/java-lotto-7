package lotto.domain.lotto;

import static lotto.exception.message.LottoExceptionMessage.DUPLICATE_NUMBER_INPUT;
import static lotto.exception.message.LottoExceptionMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.message.LottoExceptionMessage.INVALID_NUMBER_RANGE;

import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoException;
import lotto.ui.dto.LottoNumbersResponse;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplication(numbers);

        return new Lotto(numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(INVALID_NUMBER_COUNT);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        boolean hasInvalidNumber = numbers.stream().anyMatch(Lotto::checkRange);

        if (hasInvalidNumber) {
            throw new LottoException(INVALID_NUMBER_RANGE);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);

        if (distinctNumbers.size() != 6) {
            throw new LottoException(DUPLICATE_NUMBER_INPUT);
        }
    }

    private static boolean checkRange(Integer number) {
        return number < 1 || number > 45;
    }

    public int match(Lotto otherLotto) {
        int count = 0;
        for (int number: otherLotto.numbers) {
            if (contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public LottoNumbersResponse toResponse() {
        return LottoNumbersResponse.from(this.numbers);
    }

}
