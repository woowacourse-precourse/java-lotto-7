package lotto.service;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.WinningRankCountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankCounterTest {
    private final LottoRankCounter lottoRankCounter = new LottoRankCounter();

    @Test
    @DisplayName("가지고 있는 로또 랭크들의 수를 계산한다.")
    void countRanks () {
        // given
        List<LottoRank> lottoRanks = List.of(
                LottoRank.UN_RANK, LottoRank.UN_RANK, LottoRank.MATCH_3_NUMBERS,
                LottoRank.MATCH_4_NUMBERS, LottoRank.MATCH_5_NUMBERS,
                LottoRank.MATCH_5_NUMBERS_WITH_BONUS_NUMBER);

        // when
        WinningRankCountDto result = lottoRankCounter.countWinningRanks(lottoRanks);

        // then
        Map<LottoRank, Long> rankCounts = result.getRankCounts();

        assertEquals(2L, rankCounts.get(LottoRank.UN_RANK));
        assertEquals(1L, rankCounts.get(LottoRank.MATCH_3_NUMBERS));
        assertEquals(1L, rankCounts.get(LottoRank.MATCH_4_NUMBERS));
        assertEquals(1L, rankCounts.get(LottoRank.MATCH_5_NUMBERS));
        assertEquals(1L, rankCounts.get(LottoRank.MATCH_5_NUMBERS_WITH_BONUS_NUMBER));
        assertEquals(0L, rankCounts.get(LottoRank.MATCH_6_NUMBERS));
    }

    @Test
    @DisplayName("당첨된 로또들의 총 가격을 계산한다.")
    void getWinningPrize () {
        // given
        List<LottoRank> lottoRanks = List.of(
                LottoRank.UN_RANK, LottoRank.UN_RANK, LottoRank.MATCH_3_NUMBERS,
                LottoRank.MATCH_4_NUMBERS, LottoRank.MATCH_5_NUMBERS,
                LottoRank.MATCH_5_NUMBERS_WITH_BONUS_NUMBER);

        WinningRankCountDto winningRankCountDto = lottoRankCounter.countWinningRanks(lottoRanks);

        // when
        Long winningPrize = lottoRankCounter.getWinningPrize(winningRankCountDto);

        // then
        Long expectedPrize = MATCH_3_NUMBERS_PRIZE + MATCH_4_NUMBERS_PRIZE
                + MATCH_5_NUMBERS_PRIZE + MATCH_5_NUMBERS_WITH_BONUS_NUMBER_PRIZE;

        assertEquals(expectedPrize, winningPrize);

    }
}