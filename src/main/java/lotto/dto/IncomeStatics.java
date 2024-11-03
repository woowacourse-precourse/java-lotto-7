package lotto.dto;

import lotto.domain.LottoStatics;

public record IncomeStatics(
        float incomeRate
) {
    public static IncomeStatics from(LottoStatics lottoStatics) {
        return new IncomeStatics(lottoStatics.getIncomeRate());
    }
}
