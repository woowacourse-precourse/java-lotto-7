package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

        Ranking matchCount = LottoResultChecker.matchCount(winningLotto, issuedLotto, bonusNumber);

        assertThat(matchCount).isEqualTo(Ranking.FIRST);
    }
}
