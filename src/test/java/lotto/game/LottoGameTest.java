package lotto.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    @DisplayName("구매한 로또 개수만큼 로또를 생성한다.")
    @Test
    void getLottoPrize() {
        // given
        LottoGame lottoGame = new LottoGame();
        int lottoCount = 8;

        // when
        int randomLottosCount = lottoGame.createRandomLottos(lottoCount);

        // then
        assertThat(randomLottosCount).isEqualTo(lottoCount);
    }
}