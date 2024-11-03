package lotto.front.builder;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.global.enums.WinningLottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningResultOutputBuilderTest {

    @Test
    @DisplayName("결과로 받은 LottoWinningRank와, 수익률을 받아 출력하기 위한 문자열로 반환")
    void 당첨_통계_문자열_테스트() {
        //given
        List<WinningLottoRank> ranks = Arrays.stream(WinningLottoRank.values()).toList();
        Map<WinningLottoRank, Integer> lottoWinningRankCount = new EnumMap<>(WinningLottoRank.class);
        ranks.forEach(lottoWinningRank -> lottoWinningRankCount.put(lottoWinningRank, 0));
        lottoWinningRankCount.put(WinningLottoRank.SECOND_PLACE,
                lottoWinningRankCount.get(WinningLottoRank.SECOND_PLACE) + 1);
        Double rateOfReturn = 65.5;
        //when
        String winningStatsOutput = LottoWinningResultOutputBuilder.build(lottoWinningRankCount, rateOfReturn);
        //then
        assertThat(winningStatsOutput).contains(
                "당첨 통계",
                "---", "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 65.5%입니다.");
    }
}