package lotto.dto;

import lotto.domain.lotto.Lotto;
import java.util.List;

public record LottoResponse(List<Integer> numbers) {
    public LottoResponse(Lotto lotto) {
        this(lotto.getNumbers());
    }
}
