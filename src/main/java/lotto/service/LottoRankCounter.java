package lotto.service;

import lotto.domain.LottoRank;
import lotto.dto.LottoRankCountDto;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.LottoRank.getLottoRanksWithoutNoRank;

public class LottoRankCounter {

    public static LottoRankCountDto countRanks(List<LottoRank> lottoRanks) {
        List<LottoRank> allLottoRanks = getLottoRanksWithoutNoRank();

        Map<LottoRank, Long> rankCounts = allLottoRanks.stream()
                .collect(Collectors.toMap(rank -> rank, rank -> 0L));

        for (LottoRank lottoRank : lottoRanks) {
            rankCounts.merge(lottoRank, 1L, Long::sum);
        }

        return new LottoRankCountDto(rankCounts);
    }
}
