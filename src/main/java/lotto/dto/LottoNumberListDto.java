package lotto.dto;

import java.util.List;

import lotto.model.Lotto;

public record LottoNumberListDto(
        List<Integer> numbers
) {
    public static LottoNumberListDto from(final Lotto lotto) {
        return new LottoNumberListDto(lotto.getNumbers());
    }
}