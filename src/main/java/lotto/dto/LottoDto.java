package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public record LottoDto(List<Integer> numbers) {
    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_SEPARATOR, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX));
    }
}