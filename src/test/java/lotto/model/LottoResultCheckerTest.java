package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCheckerTest {

    @Test
    @DisplayName("등수와 상금으로 수익률 계산 테스트, 수익률 소수점 둘째 자리에서 반올림")
    void profitCalculationTest() {
        Ranking rank = Ranking.FIRST;
        int purchaseCount = 5;
        int winningPrize = rank.getPrize();
        double profit = LottoResultChecker.calculateProfit(purchaseCount, winningPrize);

        assertThat(profit).isEqualTo(40000000.0);
    }

    @Test
    @DisplayName("당첨 번호와 발행된 로또 번호 일치하는지 비교, 1등")
    void lottoNumberMatchTest1() {
        Set<Integer> winningLotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> issuedLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Map<Ranking, Integer> rankingCountMap = LottoResultChecker.calculateRankingCount(winningLotto, issuedLotto, bonusNumber);
        Ranking ranking = rankingCountMap.keySet().iterator().next();

        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @Test
    @DisplayName("당첨 번호와 발행된 로또 번호 일치하는지 비교, 2등, 보너스 번호 포함")
    void lottoNumberMatchTest2() {
        Set<Integer> winningLotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> issuedLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        Map<Ranking, Integer> rankingCountMap = LottoResultChecker.calculateRankingCount(winningLotto, issuedLotto, bonusNumber);
        Ranking ranking = rankingCountMap.keySet().iterator().next();

        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @Test
    @DisplayName("당첨 번호와 발행된 로또 번호 일치하는지 비교, 3등, 보너스 번호 미포함")
    void lottoNumberMatchTest3() {
        Set<Integer> winningLotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> issuedLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        Map<Ranking, Integer> rankingCountMap = LottoResultChecker.calculateRankingCount(winningLotto, issuedLotto, bonusNumber);
        Ranking ranking = rankingCountMap.keySet().iterator().next();

        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @Test
    @DisplayName("당첨 번호와 발행된 로또 번호 일치하는지 비교, 4등")
    void lottoNumberMatchTest4() {
        Set<Integer> winningLotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> issuedLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)));

        Map<Ranking, Integer> rankingCountMap = LottoResultChecker.calculateRankingCount(winningLotto, issuedLotto, bonusNumber);
        Ranking ranking = rankingCountMap.keySet().iterator().next();

        assertThat(ranking).isEqualTo(Ranking.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호와 발행된 로또 번호 일치하는지 비교, 5등")
    void lottoNumberMatchTest5() {
        Set<Integer> winningLotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> issuedLotto = List.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        Map<Ranking, Integer> rankingCountMap = LottoResultChecker.calculateRankingCount(winningLotto, issuedLotto, bonusNumber);
        Ranking ranking = rankingCountMap.keySet().iterator().next();

        assertThat(ranking).isEqualTo(Ranking.FIFTH);
    }

    @Test
    @DisplayName("당첨 번호와 발행된 로또 번호 일치하는지 비교, 등수없음")
    void lottoNumberMatchTest6() {
        Set<Integer> winningLotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> issuedLotto = List.of(new Lotto(List.of(1, 2, 8, 9, 10, 11)));

        Map<Ranking, Integer> rankingCountMap = LottoResultChecker.calculateRankingCount(winningLotto, issuedLotto, bonusNumber);
        Ranking ranking = rankingCountMap.keySet().iterator().next();

        assertThat(ranking).isEqualTo(Ranking.NONE);
    }
}
