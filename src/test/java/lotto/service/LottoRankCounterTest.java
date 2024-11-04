package lotto.service;

import lotto.domain.LottoRank;
import lotto.dto.LottoRankCountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankCounterTest {
    @Test
    @DisplayName("가지고 있는 로또 랭크들의 수를 계산한다.")
    void countRanks () {
        // given
        List<LottoRank> lottoRanks = List.of(
                LottoRank.UN_RANK, LottoRank.UN_RANK, LottoRank.MATCH_3_NUMBERS,
                LottoRank.MATCH_4_NUMBERS, LottoRank.MATCH_5_NUMBERS,
                LottoRank.MATCH_5_NUMBERS_WITH_BONUS_NUMBER);

        // when
        LottoRankCountDto result = LottoRankCounter.countRanks(lottoRanks);

        // then
        Map<LottoRank, Long> rankCounts = result.getRankCounts();

        assertEquals(2L, rankCounts.get(LottoRank.UN_RANK));
        assertEquals(1L, rankCounts.get(LottoRank.MATCH_3_NUMBERS));
        assertEquals(1L, rankCounts.get(LottoRank.MATCH_4_NUMBERS));
        assertEquals(1L, rankCounts.get(LottoRank.MATCH_5_NUMBERS));
        assertEquals(1L, rankCounts.get(LottoRank.MATCH_5_NUMBERS_WITH_BONUS_NUMBER));
        assertEquals(0L, rankCounts.get(LottoRank.MATCH_6_NUMBERS));
    }
}