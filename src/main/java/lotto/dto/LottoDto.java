package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public record LottoDto(List<Integer> numbers) {

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
