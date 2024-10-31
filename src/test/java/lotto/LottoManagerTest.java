package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    LottoManager lottoManager = new LottoManager();

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
}