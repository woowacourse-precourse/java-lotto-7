package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public record LottoResponse(List<Integer> numbers) {
    public static LottoResponse of(Lotto lotto) {
        return new LottoResponse(lotto.getSortedAscendingNumbers());
    }
}
