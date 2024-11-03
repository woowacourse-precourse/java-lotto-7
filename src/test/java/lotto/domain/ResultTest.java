package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.factory.ResultFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultTest {
    LottoMachine lottoMachine;
    List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
        lottoMachine.assignWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoMachine.assignBonusNumber(7);

        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),        // 6개 일치 (1등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),        // 5개 + 보너스 일치 (2등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),        // 5개 일치 (3등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)),      // 4개 일치 (4등)
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),      // 3개 일치 (5등)
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13))     // 0개 일치 (꽝)
        );
    }

    @Test
    void 당청금_조회() {
        Result result = ResultFactory.generateResult(lottoMachine, lottos);

        long expectedPrize =
                Rank.FIRST_PRIZE.getPrize()
                        + Rank.SECOND_PRIZE.getPrize()
                        + Rank.THIRD_PRIZE.getPrize()
                        + Rank.FOURTH_PRIZE.getPrize()
                        + Rank.FIFTH_PRIZE.getPrize();

        assertThat(result.getTotalPrize().getMoney()).isEqualTo(expectedPrize);
    }
}