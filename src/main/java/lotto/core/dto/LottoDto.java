package lotto.core.dto;

import java.util.List;
import lotto.core.model.Lotto;

public record LottoDto(List<Integer> numbers) {

    public static LottoDto modelOf(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
