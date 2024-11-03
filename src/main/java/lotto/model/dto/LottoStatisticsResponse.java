package lotto.model.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public record LottoStatisticsResponse(
        Map<String, Integer> statistics,
        BigDecimal rateOfRevenue
) {

    public LottoStatisticsResponse(Map<String, Integer> statistics, BigDecimal rateOfRevenue) {
        this.statistics = new HashMap<>(statistics); // 깊은 복사
        this.rateOfRevenue = rateOfRevenue;
    }

    public static LottoStatisticsResponse of(Map<String, Integer> customerStatistics, BigDecimal rateOfRevenue) {
        return new LottoStatisticsResponse(new HashMap<>(customerStatistics), rateOfRevenue);
    }
}
