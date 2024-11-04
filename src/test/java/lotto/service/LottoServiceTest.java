package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
    @DisplayName("구입 금액이 1000원으로 나누어떨어지지 않으면 예외가 발생한다")
    @Test
    void validatePurchaseAmount() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.purchaseLottos(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액만큼 로또를 발급한다")
    @Test
    void purchaseLottos() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.purchaseLottos(3000);
        assertThat(lottos).hasSize(3);
    }

    @DisplayName("당첨 통계를 정확하게 계산한다")
    @Test
    void calculateStatistics() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8))   // 3등
        );

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        var statistics = lottoService.calculateStatistics(lottos, winningLotto);
        assertThat(statistics.get(PrizeRank.FIRST)).isEqualTo(1);
        assertThat(statistics.get(PrizeRank.SECOND)).isEqualTo(1);
        assertThat(statistics.get(PrizeRank.THIRD)).isEqualTo(1);
    }

    @DisplayName("수익률을 정확하게 계산한다")
    @Test
    void calculateProfitRate() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)) //1등~
        );
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        double profitRate = lottoService.calculateProfitRate(lottos, winningLotto);
        assertThat(profitRate).isEqualTo(200000000.0); //한장으로 당첨일때
    }
}
