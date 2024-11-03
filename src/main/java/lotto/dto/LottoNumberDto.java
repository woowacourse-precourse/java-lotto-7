package lotto.dto;

import java.util.List;

public record LottoNumberDto(List<Integer> numbers) {
    public LottoNumberDto(List<Integer> numbers) {
        this.numbers = numbers.stream().sorted().toList();
    }
}
