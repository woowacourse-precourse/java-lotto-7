package lotto.util;

import lotto.domain.JackpotNumbers;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankingEvaluatorTest {

    @Test
    void initMapTest() {
        // given
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1,2,3,4,5,6)));
        JackpotNumbers jackpotNumbers = new JackpotNumbers();
        jackpotNumbers.setLotto(new Lotto(List.of(7,8,9,10,11,12)));
        jackpotNumbers.setBonusNumber(13);
        // when
        Map<Ranking, Integer> map = RankingEvaluator.evaluateAll(purchasedLottos, jackpotNumbers);
        // then
        // 아무것도 맞지 않음, Map의 value들이 다 0이어야 함.
        assertThat(map.get(Ranking.FIRST)).isEqualTo(0);
        assertThat(map.get(Ranking.SECOND)).isEqualTo(0);
        assertThat(map.get(Ranking.THIRD)).isEqualTo(0);
        assertThat(map.get(Ranking.FOURTH)).isEqualTo(0);
        assertThat(map.get(Ranking.FIFTH)).isEqualTo(0);
    }

    @Test
    void evaluateAllTest() {
        // given
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)), // 1등
                new Lotto(List.of(1,2,3,4,5,7)), // 2등
                new Lotto(List.of(1,2,3,8,9,10)) // 5등
        );
        JackpotNumbers jackpotNumbers = new JackpotNumbers();
        jackpotNumbers.setLotto(new Lotto(List.of(1,2,3,4,5,6)));
        jackpotNumbers.setBonusNumber(7);

        // when
        Map<Ranking, Integer> rankingMap = RankingEvaluator.evaluateAll(purchasedLottos, jackpotNumbers);
        
        // then
        assertThat(rankingMap.get(Ranking.FIRST)).isEqualTo(1);
        assertThat(rankingMap.get(Ranking.SECOND)).isEqualTo(1);
        assertThat(rankingMap.get(Ranking.FIFTH)).isEqualTo(1);
    }
}