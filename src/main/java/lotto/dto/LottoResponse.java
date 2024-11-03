package lotto.dto;

import lotto.domain.Lotto;
import java.util.List;

public record LottoResponse(List<Integer> numbers) {
    public LottoResponse(Lotto lotto) {
        this(lotto.getNumbers());
    }
}
