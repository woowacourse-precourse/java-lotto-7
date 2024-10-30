package lotto.modelTest;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoStatistics;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void shouldgeneratedLotto() {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> purchasedLotto = lottoGame.generateLotto(5);
        assertThat(purchasedLotto).hasSize(5);
        for (Lotto lotto : purchasedLotto) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @Test
    public void shouldCheckResults() {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> purchasedLotto = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        List<Integer> usersLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoStatistics statistics = lottoGame.checkResults(purchasedLotto, usersLotto, bonusNumber);

        assertThat(statistics.getStatistics().get("6개 일치 (2,000,000,000원)")).isEqualTo(1);
        assertThat(statistics.getStatistics().get("5개 일치, 보너스 볼 일치 (30,000,000원)")).isEqualTo(0);
    }
}
