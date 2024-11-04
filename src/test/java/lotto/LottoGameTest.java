package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGameTest {
    @DisplayName("로또 구매부터 당첨 확인까지 전체 흐름을 테스트한다")
    @Test
    void integrationTest() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> purchasedLottos = lottoMachine.purchase(5000);  // 5장 구매

        // when
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        LottoResult result = LottoResult.of(purchasedLottos, winningLotto);

        // then
        assertThat(purchasedLottos).hasSize(5);  // 구매 금액에 맞는 수량
        assertThat(result.getRankCount().values())  // 당첨 내역이 존재
                .isNotEmpty();
        assertThat(result.calculateProfitRate())  // 수익률이 계산됨
                .isNotNegative();
    }

    @DisplayName("잘못된 구매 금액으로 로또를 구매할 수 없다")
    @Test
    void invalidPurchaseAmount() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.purchase(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("잘못된 당첨 번호로 결과를 생성할 수 없다")
    @Test
    void invalidWinningNumbers() {
        assertThatThrownBy(() ->
                new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 5)), 7)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}