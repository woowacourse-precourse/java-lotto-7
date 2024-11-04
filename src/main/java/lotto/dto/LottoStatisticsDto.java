package lotto.dto;

import java.util.Collections;
import java.util.List;
import lotto.domain.LottoRank;

public record LottoStatisticsDto(List<LottoRank> lottoRanks, double lottoRateOfProfit) {
    public static LottoStatisticsDto of(List<LottoRank> lottoRanks, double lottoRateOfProfit) {
        return new LottoStatisticsDto(Collections.unmodifiableList(lottoRanks), lottoRateOfProfit);
    }
}
