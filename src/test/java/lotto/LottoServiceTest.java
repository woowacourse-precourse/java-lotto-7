package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void validatePurchaseAmount() {
        assertThatThrownBy(() -> lottoService.purchaseLottos(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("구입 금액만큼 로또를 발행한다.")
    @Test
    void purchaseLottos() {
        List<Lotto> lottos = lottoService.purchaseLottos(5000);
        assertThat(lottos).hasSize(5);
    }

    @DisplayName("당첨 통계가 정확히 계산된다.")
    @Test
    void checkWinningStatistics() {
        // 테스트용 로또 생성
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등 (보너스 번호 7)
                new Lotto(List.of(1, 2, 3, 4, 5, 8))   // 3등
        );

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Map<LottoRank, Integer> result = lottoService.checkWinning(purchasedLottos, winningLotto, bonusNumber);

        assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(1);
    }

    @DisplayName("수익률이 정확히 계산된다.")
    @Test
    void calculateReturnRate() {
        Map<LottoRank, Integer> result = Map.of(
                LottoRank.FIFTH, 1,    // 5,000원
                LottoRank.NONE, 7
        );

        double returnRate = lottoService.calculateReturnRate(result, 8000);
        assertThat(returnRate).isEqualTo(62.5);
    }
}