package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryStatisticsTest {

    @DisplayName("소숫점 둘째 자리에서 반올림한 수익률을 계산한다.")
    @Test
    void 소숫점_둘째_자리에서_반올림한_수익률을_계산한다() {
        Budget budget = Budget.of(3000L);

        Lotties lotties = Lotties.of(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new Lotto(List.of(13, 14, 15, 16, 17, 18))
                )
        );

        WinningLotto winningLotto = WinningLotto.of(
                new Lotto(List.of(1, 2, 3, 42, 43, 44)),
                45
        );

        LotteryStatistics statistics = LotteryStatistics.of(lotties, winningLotto, budget);
        assertEquals((double) Math.round(5.0 * 1000 / 3.0) / 10, statistics.computeReturnOfInvestment());
    }
}