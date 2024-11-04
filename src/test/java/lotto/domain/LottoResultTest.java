package lotto.domain;

import lotto.constants.Ranking;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @Test
    void 수익률_계산_기능_테스트() {
        List<Ranking> rankings = Arrays.asList(Ranking.FIFTH);
        LottoResult lottoResult = LottoResult.from(rankings);

        double profit = lottoResult.calculateProfit(8000);

        assertThat(profit).isEqualTo(62.5);
    }

    @Test
    void 로또_당첨_결과_생성_테스트() {
        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.SECOND, Ranking.SECOND, Ranking.THIRD);

        LottoResult lottoResult = LottoResult.from(rankings);

        EnumMap<Ranking, Integer> expectedRankingMap = new EnumMap<>(Ranking.class);
        expectedRankingMap.put(Ranking.FIRST, 1);
        expectedRankingMap.put(Ranking.SECOND, 2);
        expectedRankingMap.put(Ranking.THIRD, 1);

        assertEquals(expectedRankingMap, lottoResult.getRankingMap());
    }
}
