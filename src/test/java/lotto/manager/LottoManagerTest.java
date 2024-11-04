package lotto.manager;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    LottoManager lottoManager = new LottoManager();
    int firstPrize = 2000000000;
    int secondPrize = 30000000;
    int thirdPrize = 1500000;
    int fourthPrize = 50000;
    int fifthPrize = 5000;

    @Test
    void 당첨_확인() {
        // given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 10;
        List<Lotto> lotteries = List.of(
                new Lotto(List.of(1,4,5,10,20,30)), // 5등
                new Lotto(List.of(6,20,31,39,41,43)), // X
                new Lotto(List.of(1,3,4,5,6,10)), // 2등
                new Lotto(List.of(1,3,4,5,6,41)) // 3등
        );
        UserLotto userLotto = new UserLotto(lotteries);

        // when
        lottoManager.executeWinningProcess(userLotto,winningNumbers,bonusNumber);

        // then
        Assertions.assertThat(userLotto.getWinningCount(1)).isEqualTo(0);
        Assertions.assertThat(userLotto.getWinningCount(2)).isEqualTo(1);
        Assertions.assertThat(userLotto.getWinningCount(3)).isEqualTo(1);
        Assertions.assertThat(userLotto.getWinningCount(4)).isEqualTo(0);
        Assertions.assertThat(userLotto.getWinningCount(5)).isEqualTo(1);
    }

    @Test
    void 총_수익률_계산(){
        // given
        int purchaseAmount = 500 * 1000;
        UserLotto userLotto = new UserLotto(List.of());
        userLotto.updateWinningCount(1);
        userLotto.updateWinningCount(3);
        userLotto.updateWinningCount(5);
        userLotto.updateWinningCount(5);

        // when
        float result = lottoManager.calculateTotalPrizeRate(userLotto,purchaseAmount);

        // then
        int expectedTotalPrize = firstPrize + thirdPrize + fifthPrize*2;
        float expectedTotalPrizeRate = (float) expectedTotalPrize / purchaseAmount * 100;
        Assertions.assertThat(result).isEqualTo(expectedTotalPrizeRate);
    }
}