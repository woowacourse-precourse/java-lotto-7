package lotto.domain.gameManager;


import java.util.List;
import lotto.controller.LottoPolicy;
import lotto.controller.LottoTierPolicy;
import lotto.controller.Policy;
import lotto.controller.TierPolicy;
import lotto.domain.lottery.Lotteries;
import lotto.domain.statistics.Statistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameManagerTest {

    @DisplayName("로또를 발행한다.")
    @Test
    void initLottery() {
        //given
        GameManager gameManager = new LottoGameManager();
        Policy policy = new LottoPolicy();

        //when
        Lotteries lotteries = gameManager.initLottery(policy, 5000);

        //then
        Assertions.assertThat(lotteries.getLottery().size()).isEqualTo(5);
    }

    @DisplayName("구입하려는 복권의 개수를 반환한다.")
    @Test
    void calculateBuyCount() {
        //given
        GameManager gameManager = new LottoGameManager();
        //when
        int boughtLotteryCount = gameManager.calculateBuyCount(1000, 5000);

        //then
        Assertions.assertThat(boughtLotteryCount).isEqualTo(5);

    }

    @DisplayName("당첨통계 인스턴스를 초기화한다.Lotto의 당첨 순위는 5개이다.")
    @Test
    void initStatistics() {
        //given
        TierPolicy tierPolicy = new LottoTierPolicy();
        GameManager gameManager = new LottoGameManager();
        //when
        List<Statistics> statistics = gameManager.initStatistics(tierPolicy);
        //then
        Assertions.assertThat(statistics.size()).isEqualTo(5);
    }
    @DisplayName("초기화되었을때 당첨복권의 개수는 모두 0개이다.")
    @Test
    void initStatistics2() {
        //given
        TierPolicy tierPolicy = new LottoTierPolicy();
        GameManager gameManager = new LottoGameManager();
        //when
        List<Statistics> statistics = gameManager.initStatistics(tierPolicy);
        List<Long> initWinningCounts = statistics.stream().map(Statistics::getWinningLottoCount).toList();
        //then
        Assertions.assertThat(initWinningCounts).containsOnly(0L);

    }
}