package lotto.model;

import java.util.List;
import lotto.dummy.LottoDummy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticTest {
    private LottoMachine lottoMachine;
    private LottoDummy lottoDummy;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
        lottoDummy = new LottoDummy();
    }

    @DisplayName("당첨 로또와 구입한 로또들로 통계를 생성할 수 있다.")
    @Test
    void 당첨_로또와_구입한_로또들로_통계를_생성할_수_있다() {
        // given
        WinningLotto winningLotto = lottoDummy.winningLotto;
        List<Lotto> boughtLottoList = lottoDummy.getLottoList();
        Double expectedProfitRatio = lottoDummy.profitRatio;

        // when
        LottoStatistic lottoStatistic = lottoMachine.generateLottoStatistic(winningLotto, boughtLottoList);
        double actualProfitRatio = lottoStatistic.getProfitRatio();

        // then
        Assertions.assertThat(actualProfitRatio).isEqualTo(expectedProfitRatio);
    }
}