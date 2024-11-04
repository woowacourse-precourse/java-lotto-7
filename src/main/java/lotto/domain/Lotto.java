package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoExceptionMessage;

public class Lotto {

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = toLottoNumberList(numbers);
    }

    public String represent() {
        return numbers.stream()
            .map(LottoNumber::toString)
            .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    private static List<LottoNumber> toLottoNumberList(List<Integer> numbers) {
        return numbers.stream()
            .sorted()
            .map(LottoNumber::valueOf).toList();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers.stream().map(LottoNumber::toInteger).toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBERS_COUNT_LIMIT);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LottoExceptionMessage.UNIQUE_LOTTO_NUMBERS);
        }
    }
}
