package lotto.domain;

import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 로또_결과를_만든다() {
        //given
        Map<Ranking, Integer> expectedResults = Map.of(
                Ranking.FIRST, 1,
                Ranking.SECOND, 1,
                Ranking.THIRD, 1,
                Ranking.FOURTH, 1,
                Ranking.FIFTH, 1,
                Ranking.MISS, 2
        );
        
        //when

        //then

    }
}