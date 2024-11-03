package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    @DisplayName("로또 발급")
    @Test
    void 로또_발급() {
        LottoGame lottoGame = new LottoGame(new LottoPurchase(30000));
        assertThat(lottoGame.getLottos()).hasSize(30);
    }
}
