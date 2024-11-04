package lotto.dto;

import java.util.List;
import lotto.domain.number.Lotto;

public record LottoNumber(
        List<Integer> values
) {
    public static LottoNumber of(final Lotto lotto) {
        return new LottoNumber(lotto.getNumbers());
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
