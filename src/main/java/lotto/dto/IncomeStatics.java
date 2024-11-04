package lotto.dto;

import lotto.domain.LottoStatics;

public record IncomeStatics(
        double incomePercent
) {
    public static IncomeStatics from(LottoStatics lottoStatics) {
        return new IncomeStatics(lottoStatics.getIncomePercent());
    }
}
