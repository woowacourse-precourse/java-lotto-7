package lotto.modelTest;
import lotto.model.Lotto;
import lotto.model.LottoMatchEnum;
import lotto.model.LottoStatistic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {

    @Test
    @DisplayName("통계 업데이트가 올바르게 이루어지는지 테스트")
    void testUpdateStatistics() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> randomLotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5개 일치, 보너스 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)), // 4개 일치
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))  // 3개 일치
        );
        int bonusNumber = 7; // 보너스 번호

        LottoStatistic statistic = new LottoStatistic(4000, randomLotteries.size());
        statistic.updateStatistics(randomLotteries, userLotto, bonusNumber);

        assertThat(statistic.getStatistics().get("6개 일치 (2,000,000,000원)")).isEqualTo(1); // 6개 일치
        assertThat(statistic.getStatistics().get("5개 일치, 보너스 볼 일치 (30,000,000원)")).isEqualTo(1); // 보너스 포함 5개 일치
        assertThat(statistic.getStatistics().get("5개 일치 (1,500,000원)")).isEqualTo(0); // 보너스 미포함 5개 일치
        assertThat(statistic.getStatistics().get("4개 일치 (50,000원)")).isEqualTo(1); // 4개 일치
        assertThat(statistic.getStatistics().get("3개 일치 (5,000원)")).isEqualTo(1); // 3개 일치
    }

    @Test
    @DisplayName("수익률 계산이 올바르게 이루어지는지 테스트")
    void testCalculateYield() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> randomLotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5개 일치 + 보너스 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)), // 4개 일치
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))  // 3개 일치
        );
        int bonusNumber = 7;

        LottoStatistic statistic = new LottoStatistic(4000, randomLotteries.size()); // 금액을 4000원으로 수정
        statistic.updateStatistics(randomLotteries, userLotto, bonusNumber);

        statistic.updateLottoYield();
        System.out.println(statistic.getStatistics());

        double expectedEarnings = LottoMatchEnum.MATCH_6.getPrize()                   // 6개 일치
                + LottoMatchEnum.MATCH_5_WITH_BONUS.getPrize()                       // 5개 일치 + 보너스 일치
                + LottoMatchEnum.MATCH_4.getPrize()                                  // 4개 일치
                + LottoMatchEnum.MATCH_3.getPrize();                                 // 3개 일치
        double expectedYield = Math.round((expectedEarnings / 4000) * 10000.0) / 100.0;

        assertThat(statistic.toDTO().yield()).isEqualTo(expectedYield);
    }
}
