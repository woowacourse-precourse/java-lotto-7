package lotto.model;

import java.math.BigDecimal;
import java.util.Map;

public record LottoResult(
        Map<LottoRank, Integer> ranks,
        BigDecimal profitRate
) {
}
