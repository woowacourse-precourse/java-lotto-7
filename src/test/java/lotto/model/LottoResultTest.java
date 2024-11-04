package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("당첨 통계를 정상적으로 생성한다")
    void createLottoResult() {
        // given
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))
        );

        // when
        LottoResult result = LottoResult.createResult(winningLotto, purchasedLottos);
        Map<WinningStatus, Integer> statistics = result.getResult();

        // then
        assertThat(statistics.get(WinningStatus.SIX_MATCHES)).isEqualTo(1);
        assertThat(statistics.get(WinningStatus.FIVE_MATCHES_WITH_BONUS)).isEqualTo(1);
        assertThat(statistics.get(WinningStatus.FIVE_MATCHES)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 정상적으로 계산한다")
    void calculateProfit() {
        // given
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        // when
        LottoResult result = LottoResult.createResult(winningLotto, purchasedLottos);
        double profit = result.calculateProfit(1000);

        // then
        assertThat(profit).isEqualTo(200000000.0);
    }
}