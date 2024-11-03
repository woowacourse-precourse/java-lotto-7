package lotto.dto.request;

import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.Money;

public record LottoCalculateRequest(
        Lottoes lottoes,
        Lotto lotto,
        int bonusNumber,
        Money money
) {
    public static LottoCalculateRequest of(Lottoes lottoes, Lotto lotto, int bonusNumber, Money money) {
        return new LottoCalculateRequest(lottoes, lotto, bonusNumber, money);
    }
}
