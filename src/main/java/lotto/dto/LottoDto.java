package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public record LottoDto(List<Integer> numbers) {

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
