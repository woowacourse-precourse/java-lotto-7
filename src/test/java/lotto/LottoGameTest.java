package lotto;

import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @DisplayName("이미 로또 티켓을 구매한 상태에서 추가로 구매하려고 하면 예외가 발생한다")
    @Test
    void 이미_로또_티켓을_구매한_상태에서_추가로_구매하려고_하면_예외가_발생한다() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.buyLottos(5); // 첫 구매

        assertThatThrownBy(() -> lottoGame.buyLottos(3)) // 두 번째 구매 시도
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 이미 로또 티켓을 구매한 상태입니다.");
    }
}
