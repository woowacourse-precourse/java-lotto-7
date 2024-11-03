package lotto.domain.statistics;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import lotto.controller.LottoPolicy;
import lotto.controller.view.OutputView;
import lotto.domain.gameManager.LottoGameManager;
import lotto.domain.lottery.Lotteries;
import lotto.domain.tier.LottoTier;
import lotto.domain.tier.Tier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDrawStatisticsTest {

    @DisplayName("당첨로또 개수가 인스턴스를 처음 생성할때 0으로 초기화된다. ")
    @Test
    void initStatistics() {
        //given
        Tier tier5 = LottoTier.initWinningTier(3, false, 5_000L);
        //when
        Statistics lottoDrawStatistics = LottoDrawStatistics.initStatistics(tier5);
        //then
        Assertions.assertThat(lottoDrawStatistics.getWinningLottoCount()).isEqualTo(0);
    }

    @DisplayName("로또 당첨 개수를 업데이트 한다.")
    @Test
    void updateWinningLottoCount() {
        //given
        Tier tier5 = LottoTier.initWinningTier(3, false, 5_000L);
        Statistics lottoDrawStatistics = LottoDrawStatistics.initStatistics(tier5);
        //when
        Statistics statistics = lottoDrawStatistics.updateWinningLottoCount(2L);

        //then
        Assertions.assertThat(statistics.getWinningLottoCount()).isEqualTo(2);
    }

    @DisplayName("해당등수의 당첨금 합계를 구한다.")
    @Test
    void calculateWinningAmount() {
        //given
        Tier tier5 = LottoTier.initWinningTier(3, false, 5_000L);
        Statistics lottoDrawStatistics = LottoDrawStatistics.initStatistics(tier5);
        Statistics statistics = lottoDrawStatistics.updateWinningLottoCount(2L);
        //when
        BigInteger bigInteger = statistics.calculateWinningAmount();
        //then
        Assertions.assertThat(bigInteger).isEqualTo(10000);
    }
}