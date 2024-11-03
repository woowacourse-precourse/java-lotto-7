package lotto.interfaces.lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public record LottoResponse(
        List<Integer> lotto
) {
    public static LottoResponse from(Lotto lotto) {
        return new LottoResponse(
                lotto.getLottoNumbers()
                        .stream()
                        .map(LottoNumber::getLottoNumber)
                        .toList()
        );
    }
    @Override
    public String toString() {
        return lotto.toString();
    }
}
