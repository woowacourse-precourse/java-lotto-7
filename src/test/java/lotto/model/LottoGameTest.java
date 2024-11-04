package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @DisplayName("금액 입력 시 1000원 단위가 아니면 예외가 발생해야 한다.")
    @Test
    void 금액_입력_시_1000원_단위가_아니면_예외가_발생해야_한다() {
        assertThatThrownBy(() -> lottoGame.purchaseTicket(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위로 입력 해야 합니다.");
    }

    @DisplayName("정상적인 금액 입력으로 로또 티켓이 발행되는지 테스트")
    @Test
    void 정상적인_금액_입력으로_로또_티켓이_발행되는지_테스트() {
        lottoGame.purchaseTicket(3000);

        assertThat(lottoGame.getTickets().size()).isEqualTo(3);
    }

    @DisplayName("당첨 번호를 설정할 수 있는지 테스트")
    @Test
    void 당첨_번호를_설정할_수_있는지_테스트() {
        lottoGame.setWinningNumber(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoGame.calculateResult().getResults()).isNotNull();
    }

    @DisplayName("보너스 번호를 설정할 수 있는지 테스트")
    @Test
    void 보너스_번호를_설정할_수_있는지_테스트() {
        lottoGame.setBonusNumber(7);

        assertThat(lottoGame.calculateResult().getResults()).isNotNull();
    }

    @DisplayName("정확한 당첨 결과를 계산하는지 테스트")
    @Test
    void 정확한_당첨_결과를_계산하는지_테스트() {
        lottoGame.purchaseTicket(2000);

        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoGame.setWinningNumber(winningNumber);
        lottoGame.setBonusNumber(bonusNumber);

        // 구매한 티켓 중 1등, 2등, 3등이 될 수 있도록 강제 설정 (테스트 용도)
        lottoGame.getTickets().clear();
        lottoGame.getTickets().add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lottoGame.getTickets().add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등 (보너스)
        lottoGame.getTickets().add(new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 3등

        LottoResult result = lottoGame.calculateResult();

        Map<WinningRank, Integer> resultMap = result.getResults();
        assertThat(resultMap.getOrDefault(WinningRank.FIRST, 0)).isEqualTo(1);
        assertThat(resultMap.getOrDefault(WinningRank.SECOND, 0)).isEqualTo(1);
        assertThat(resultMap.getOrDefault(WinningRank.THIRD, 0)).isEqualTo(1);
        assertThat(resultMap.getOrDefault(WinningRank.FOURTH, 0)).isEqualTo(0);
        assertThat(resultMap.getOrDefault(WinningRank.FIFTH, 0)).isEqualTo(0);
    }
}