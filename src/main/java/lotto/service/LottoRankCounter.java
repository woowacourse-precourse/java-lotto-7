package lotto.service;

import lotto.domain.LottoRank;
import lotto.dto.LottoRankCountDto;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoRankCounter {

    public static LottoRankCountDto countRanks(List<LottoRank> lottoRanks) {
        Map<LottoRank, Long> rankCounts = EnumSet.allOf(LottoRank.class).stream()
                .collect(Collectors.toMap(rank -> rank, rank -> 0L));

        for (LottoRank lottoRank : lottoRanks) {
            rankCounts.merge(lottoRank, 1L, Long::sum);
        }

        return new LottoRankCountDto(rankCounts);
    }
}
