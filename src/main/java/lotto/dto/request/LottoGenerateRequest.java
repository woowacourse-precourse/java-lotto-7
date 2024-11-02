package lotto.dto.request;

import lotto.domain.Money;

public record LottoGenerateRequest(
        Money money
) {
    public static LottoGenerateRequest from(Money money) {
        return new LottoGenerateRequest(money);
    }
}
