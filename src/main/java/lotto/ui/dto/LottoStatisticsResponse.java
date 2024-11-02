package lotto.ui.dto;

import java.math.BigDecimal;
import java.util.List;

public record LottoStatisticsResponse(
        List<WinningCountByPrize> winningCountByPrizes,
        BigDecimal profitRate
) {

    public static LottoStatisticsResponse of(List<WinningCountByPrize> winningCountByPrize, BigDecimal profitRate) {
        return new LottoStatisticsResponse(winningCountByPrize, profitRate);
    }

}
