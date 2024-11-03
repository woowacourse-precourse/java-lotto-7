package lotto.dto;

import java.util.EnumMap;
import lotto.domain.LottoPrize;
import lotto.domain.LottoStatics;

public record PrizeStatics(
        EnumMap<LottoPrize, Long> prizeCount
) {
    public static PrizeStatics from(LottoStatics lottoStatics) {
        return new PrizeStatics(lottoStatics.getPrizeCount());
    }
}
