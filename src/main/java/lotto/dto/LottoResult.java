package lotto.dto;

import java.math.BigDecimal;
import java.util.Map;
import lotto.model.LottoRank;

public record LottoResult(
        Map<LottoRank, Integer> ranks,
        BigDecimal profitRate
) {
}
