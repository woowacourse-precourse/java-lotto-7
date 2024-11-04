package lotto.domain.lotto;

import static lotto.infrastructure.exception.ErrorCode.*;

import java.util.List;
import java.util.UUID;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT_CRITERION = 6;
    public final static int LOTTO_NUMBER_MINIMUM_CRITERION = 1;
    public final static int LOTTO_NUMBER_MAXIMUM_CRITERION = 45;
    private final List<Integer> numbers;
    private final UUID id;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.id = UUID.randomUUID();
    }

    public static Lotto from(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateNoDuplicatedNumber(numbers);
        validateProperNumberRange(numbers);

        return new Lotto(numbers);
    }

    private static void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT_CRITERION) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateNoDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT_CRITERION) {
            throw new IllegalArgumentException(INVALID_LOTTO_DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateProperNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_NUMBER_MINIMUM_CRITERION
            || number > LOTTO_NUMBER_MAXIMUM_CRITERION)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public UUID getId() {
        return this.id;
    }
}
