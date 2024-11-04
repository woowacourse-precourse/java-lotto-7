package lotto.service;

import lotto.domain.LottoRank;
import lotto.dto.WinningRankCountDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.common.Constants.DECIMAL_SCALE;
import static lotto.common.Constants.LOTTO_PRICE_UNIT;
import static lotto.domain.LottoRank.getLottoRanksWithoutNoRank;

public class LottoRankCounter {

    public WinningRankCountDto countWinningRanks(List<LottoRank> lottoRanks) {
        List<LottoRank> allLottoRanks = getLottoRanksWithoutNoRank();

        Map<LottoRank, Long> rankCounts = allLottoRanks.stream()
                .collect(Collectors.toMap(rank -> rank, rank -> 0L));

        for (LottoRank lottoRank : lottoRanks) {
            rankCounts.merge(lottoRank, 1L, Long::sum);
        }

        return new WinningRankCountDto(rankCounts);
    }

    public void getProfitRate(WinningRankCountDto winningRankCountDto, Integer lottoTicketCount) {
        Long winningPrize = getWinningPrize(winningRankCountDto);

        Double profitRate = getProfitRate(winningPrize, lottoTicketCount);
    }

    public long getWinningPrize(WinningRankCountDto winningRankCountDto) {
        List<LottoRank> availableRanks = getLottoRanksWithoutNoRank();

        long winningPrize = 0L;

        for (LottoRank lottoRank : availableRanks) {
            winningPrize += getWinningPrizePerRank(lottoRank, winningRankCountDto);
        }

        return winningPrize;
    }

    public Double getProfitRate (Long winningPrize, Integer lottoTicketCount) {
        Long purchaseAmount = ((long) lottoTicketCount * LOTTO_PRICE_UNIT);

        double profitRate = (double) winningPrize / purchaseAmount;

        BigDecimal bdProfitRate = BigDecimal.valueOf(profitRate);
        bdProfitRate = bdProfitRate.setScale(DECIMAL_SCALE, RoundingMode.DOWN);

        return bdProfitRate.doubleValue();
    }

    private Long getWinningPrizePerRank (LottoRank lottoRank, WinningRankCountDto winningRankCountDto) {
        Integer prizeMoney = lottoRank.getPrizeMoney();

        Long winningCount = winningRankCountDto.getRankCount(lottoRank);

        return prizeMoney * winningCount;
    }
}
