package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

public record LottoDto(List<Integer> numbers) {
    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}